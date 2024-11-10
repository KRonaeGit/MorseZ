package io.github.kronae.morsez.writer;

import io.github.kronae.morsez.MorseSignal;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;
import java.util.List;

public class MorseSignalPlayer {
    private final MorseSignal signal;
    public MorseSignalPlayer(MorseSignal signal) {
        this.signal = signal;
    }
    public MorseSignal getSignal() {
        return signal;
    }
    public void play(int unitSpeed, double hz) throws LineUnavailableException, InterruptedException {
        double length = (double) 1000 / unitSpeed;
        List<Boolean> signals = signal.getSignals();

        AudioFormat audioFormat = new AudioFormat(44100, 8, 1, true, false);
        SourceDataLine line = AudioSystem.getSourceDataLine(audioFormat);
        line.open(audioFormat);
        line.start();

        List<Integer> audio = new ArrayList<>();
        Boolean type = null;
        int len = 0;
        for (int i = 0; i < signals.size(); i++) {
            boolean signal = signals.get(i);
            if(type == null) {
                type = signal;
                len++;
                continue;
            }

            if(type != signal) {
                int data = type ? len : (-len);
                audio.add(data);

                type = signal;
                len = 1;
                continue;
            }
            len++;
        }
        int d = type ? len : (-len);
        audio.add(d);

        for (Integer data : audio) {
            double soundLen = length * Math.abs(data);

            byte[] buffer = new byte[(int) (soundLen * 44.1)];

            if (data > 0) {
                for (int i = 0; i < buffer.length; i++) {
                    double angle = i / (44100.0 / hz) * 2.0 * Math.PI;
                    buffer[i] = (byte) (Math.sin(angle) * 127.0);
                }
            } else {
                Thread.sleep((long) soundLen);
            }

            line.write(buffer, 0, buffer.length);
        }
        line.drain();
        line.close();
    }
    @Override
    public String toString() {
        return "MorseSignalPlayer{" + signal + '}';
    }
}

package io.github.kronae.morsez.program;

import io.github.kronae.morsez.writer.MorseSignalPlayer;

import javax.sound.sampled.LineUnavailableException;

import static io.github.kronae.morsez.program.MorseProgramStorage.*;

public class MorseProgramPLAY {
    public static void exec(String[] command) throws LineUnavailableException, InterruptedException {
        if(TSIG_SIGNAL == null) {
            System.err.println("> PLAY: THERE IS NOTHING IN SIGNAL STORAGE.");
            return;
        }

        int opt1 = PLAY_OPT1;
        int opt2 = PLAY_OPT2;

        try {
            if (command.length - 1 >= 1) {
                opt1 = Integer.parseInt(command[1]);
                PLAY_OPT1 = opt1;
            }
            if (command.length - 1 >= 2) {
                opt2 = Integer.parseInt(command[2]);
                PLAY_OPT2 = opt2;
            }
        } catch(NumberFormatException e) {
            System.out.println("> NOT A INTEGER");
            return;
        }

        MorseSignalPlayer player = new MorseSignalPlayer(TSIG_SIGNAL);
        player.play(opt1, opt2);
    }
}

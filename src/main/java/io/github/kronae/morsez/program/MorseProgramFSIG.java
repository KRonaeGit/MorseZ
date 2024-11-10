package io.github.kronae.morsez.program;

import io.github.kronae.morsez.MorseCode;
import io.github.kronae.morsez.MorseSignal;
import io.github.kronae.morsez.translate.exception.UnknownCharacterException;
import io.github.kronae.morsez.translate.exception.UnknownLetterLength;
import io.github.kronae.morsez.translate.exception.UnknownSymbolException;
import io.github.kronae.morsez.translate.exception.UnknownSymbolLengthException;

public class MorseProgramFSIG {
    public static void exec(String opt) throws UnknownCharacterException, UnknownSymbolLengthException, UnknownSymbolException, UnknownLetterLength {
        opt = opt.substring(5);
        MorseSignal signal = new MorseSignal();
        for (char c : opt.toCharArray()) {
            signal.add(c == '1');
        }
        System.out.printf("> FSIG: SIG  %s\n", signal);

        MorseCode code = MorseProgramStorage.translator.fromMorseSignal(signal);
        System.out.printf("> FSIG: CODE %s\n", code);

        String output  = MorseProgramStorage.translator.fromMorseCode(code);

        System.out.printf("> FSIG: STR  %s\n", output);
    }
}

package io.github.kronae.morsez.program;

import io.github.kronae.morsez.*;
import io.github.kronae.morsez.translate.exception.UnknownCharacterException;
import org.jetbrains.annotations.NotNull;

import static io.github.kronae.morsez.program.MorseProgramStorage.*;

import java.util.List;

public class MorseProgramTSIG {
    public static void exec(String opt) throws UnknownCharacterException {
        opt = opt.substring(5);

        System.out.printf("> TSIG: OPT=||%s||\n", opt);

        MorseCode morse = translator.toMorseCode(opt);
        System.out.println("> MORSE CODE <");
        System.out.print("| ");
        List<MorseWord> words = morse.getWords();
        for (int i = 0; i < words.size(); i++) {
            MorseWord word = words.get(i);

            List<MorseLetter> letters = word.getLetters();
            for (int j = 0; j < letters.size(); j++) {
                MorseLetter letter = letters.get(j);

                if(j > 0)
                    System.out.print(" ");

                for (MorseSymbol symbol : letter.getSymbols()) {
                    System.out.print(symbol == MorseSymbol.DOT ? "." : "_");
                }
            }

            System.out.println();
            if(i < words.size() - 1) {
                System.out.print("| ");
            }
        }
        System.out.println("> ========== <");

        MorseSignal signal = translator.toMorseSignal(morse);

        System.out.printf("> SIGNAL: %s\n", signal.toString());

        TSIG_SIGNAL = signal;
    }
}

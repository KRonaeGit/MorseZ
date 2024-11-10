package io.github.kronae.morsez.program;

import io.github.kronae.morsez.MorseSignal;
import io.github.kronae.morsez.translate.InternationalMorseCode;
import io.github.kronae.morsez.translate.exception.UnknownCharacterException;

public class MorseProgramStorage {
    protected static final InternationalMorseCode translator = new InternationalMorseCode();
    protected static       MorseSignal TSIG_SIGNAL;

    static {
        try {
            TSIG_SIGNAL = translator.toMorseSignal(translator.toMorseCode("SOS"));
        } catch (UnknownCharacterException e) {
            throw new RuntimeException(e);
        }
    }

    protected static int   PLAY_OPT1 = 15 ;
    protected static int   PLAY_OPT2 = 400;
}

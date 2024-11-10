package io.github.kronae.morsez.translate;

import io.github.kronae.morsez.MorseCode;
import io.github.kronae.morsez.MorseSignal;
import io.github.kronae.morsez.translate.exception.UnknownCharacterException;
import io.github.kronae.morsez.translate.exception.UnknownLetterLength;
import io.github.kronae.morsez.translate.exception.UnknownSymbolException;
import io.github.kronae.morsez.translate.exception.UnknownSymbolLengthException;

public abstract class MorseTranslator {
    public abstract String getId();
    public abstract MorseCode toMorseCode(String input) throws UnknownCharacterException;
    public abstract MorseSignal toMorseSignal(MorseCode code);
    public abstract MorseCode fromMorseSignal(MorseSignal code) throws UnknownSymbolLengthException;
    public abstract String fromMorseCode(MorseCode input) throws UnknownSymbolException, UnknownLetterLength;

}

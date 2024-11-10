package io.github.kronae.morsez.translate.exception;

import io.github.kronae.morsez.translate.InternationalMorseCode;
import io.github.kronae.morsez.translate.MorseTranslator;
import org.jetbrains.annotations.NotNull;

public class UnknownLetterLength extends Throwable {
    public UnknownLetterLength(@NotNull MorseTranslator translator, int length, String msg) {
        super(String.format("MorseTranslator '%s' does not supports a letter with %d symbols%s", translator.getId(), length, msg == null ? "." : ": " + msg));
    }
}

package io.github.kronae.morsez.translate.exception;

import io.github.kronae.morsez.translate.MorseTranslator;
import org.jetbrains.annotations.NotNull;

public class UnknownSymbolLengthException extends Throwable {
    public UnknownSymbolLengthException(@NotNull MorseTranslator translator, int length, String msg) {
        super(String.format("MorseTranslator '%s' does not supports %d length of symbol%s", translator.getId(), length, msg == null ? "." : ": " + msg));
    }
}

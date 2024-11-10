package io.github.kronae.morsez.translate.exception;

import io.github.kronae.morsez.MorseSymbol;
import io.github.kronae.morsez.translate.MorseTranslator;
import org.jetbrains.annotations.NotNull;

public class UnknownSymbolException extends Throwable {
    public UnknownSymbolException(@NotNull MorseTranslator translator, MorseSymbol symbol, String msg) {
        super(String.format("MorseTranslator '%s' does not supports '%s' symbol%s", translator.getId(), symbol, msg == null ? "." : ": " + msg));
    }
}

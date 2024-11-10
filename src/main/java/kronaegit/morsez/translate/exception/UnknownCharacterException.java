package io.github.kronae.morsez.translate.exception;

import io.github.kronae.morsez.translate.MorseTranslator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UnknownCharacterException extends Exception {
    public UnknownCharacterException(@NotNull MorseTranslator translator, @NotNull String character, @Nullable String msg) {
        super(String.format("MorseTranslator '%s' does not supports character '%s'%s", translator.getId(), character, msg == null ? "." : ": " + msg));
    }
}

package io.github.kronae.morsez;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MorseLetter {
    private final List<MorseSymbol> symbols;
    public MorseLetter(@Nullable List<MorseSymbol> symbols) {
        this.symbols = symbols == null ? new ArrayList<>() : symbols;
    }
    public MorseLetter() {
        this(null);
    }
    public List<MorseSymbol> getSymbols() {
        return symbols;
    }
    public MorseLetter add(MorseSymbol... symbols) {
        Collections.addAll(this.symbols, symbols);
        return this;
    }
    @Override
    public String toString() {
        if(symbols.isEmpty())
            return "";

        String o = "[";
        for (int i = 0; i < symbols.size(); i++) {
            if(i > 0)
                o += ", ";

            o += symbols.get(i);
        }
        return o + "]";
    }
}

package io.github.kronae.morsez;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MorseWord {
    private final List<MorseLetter> letters;

    public MorseWord(@Nullable List<MorseLetter> letters) {
        this.letters = letters == null ? new ArrayList<>() : letters;
    }

    public MorseWord() {
        this(null);
    }

    public List<MorseLetter> getLetters() {
        return letters;
    }
    public void add(MorseLetter letter) {
        letters.add(letter);
    }
    @Override
    public String toString() {
        String o = "MorseWord";
        for (int i = 0; i < letters.size(); i++) {
            if(i > 0)
                o += ", ";

            o += letters.get(i);
        }
        return o;
    }
}

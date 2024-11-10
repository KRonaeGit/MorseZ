package io.github.kronae.morsez;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MorseCode {
    private final List<MorseWord> words;
    public MorseCode(@Nullable List<MorseWord> words) {
        this.words = words == null ? new ArrayList<>() : words;
    }
    public MorseCode() {
        this(null);
    }
    public List<MorseWord> getWords() {
        return words;
    }
    public void add(MorseWord word) {
        words.add(word);
    }
    @Override
    public String toString() {
        String o = "MorseCode[";
        for (int i = 0; i < words.size(); i++) {
            if(i > 0)
                o += ", ";

            o += words.get(i);
        }
        return o + "]";
    }
}

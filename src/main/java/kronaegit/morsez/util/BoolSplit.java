package io.github.kronae.morsez.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BoolSplit {
    public static @NotNull List<List<Boolean>> split(@NotNull List<Boolean> input, List<Boolean> with) {
        List<List<Boolean>> result = new ArrayList<>();
        List<Boolean> current = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            boolean matches = true;
            for (int j = 0; j < with.size(); j++) {
                if (i + j >= input.size() || input.get(i + j) != with.get(j)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                result.add(current);
                current = new ArrayList<>();
                i += with.size() - 1;
            } else {
                current.add(input.get(i));
            }
        }

        result.add(current);
        return result;
    }
}

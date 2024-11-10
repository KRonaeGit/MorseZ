package io.github.kronae.morsez;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MorseSignal {
    private final List<Boolean> signals;
    public MorseSignal(@Nullable List<Boolean> signals) {
        this.signals = signals == null ? new ArrayList<>() : signals;
    }
    public MorseSignal() {
        this(null);
    }
    public List<Boolean> getSignals() {
        return signals;
    }
    public void add(Boolean... signals) {
        this.signals.addAll(Arrays.asList(signals));
    }
    @Override
    public String toString() {
        String o = "MorseSignal(";
        for (Boolean signal : signals) o += signal ? 1 : 0;
        return o + ")";
    }
}

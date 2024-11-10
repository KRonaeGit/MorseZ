package io.github.kronae.morsez.translate;

import io.github.kronae.morsez.*;
import io.github.kronae.morsez.translate.exception.UnknownCharacterException;
import io.github.kronae.morsez.translate.exception.UnknownLetterLength;
import io.github.kronae.morsez.translate.exception.UnknownSymbolException;
import io.github.kronae.morsez.translate.exception.UnknownSymbolLengthException;
import io.github.kronae.morsez.util.BoolSplit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.kronae.morsez.MorseSymbol.*;

/**
 * This class was created with reference to <a href="https://upload.wikimedia.org/wikipedia/commons/b/b5/International_Morse_Code.svg">Wikipedia: International Morse Code</a>.
 */
public class InternationalMorseCode extends MorseTranslator {
    private static final List<Boolean> false7;
    private static final List<Boolean> false3;
    private static final List<Boolean> false1;
    static {
        false7 = new ArrayList<>();
        for (int i = 0; i < 7; i++)
            false7.add(false);

        false3 = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            false3.add(false);

        false1 = new ArrayList<>();
        false1.add(false);
    }
    @Override
    public String getId() {
        return "International Morse Code";
    }

    @Override
    public MorseCode toMorseCode(@NotNull String input) throws UnknownCharacterException {
        MorseCode morse = new MorseCode();
        MorseWord word = null;

        for (char c : input.toCharArray()) {
            if (word == null)
                word = new MorseWord();

            switch (Character.toUpperCase(c)) {
                case ' ':
                    morse.add(word);
                    word = null;
                    break;
                case 'A':
                    word.add(new MorseLetter().add(DOT, DASH));
                    break;
                case 'B':
                    word.add(new MorseLetter().add(DASH, DOT, DOT, DOT));
                    break;
                case 'C':
                    word.add(new MorseLetter().add(DASH, DOT, DASH, DOT));
                    break;
                case 'D':
                    word.add(new MorseLetter().add(DASH, DOT, DOT));
                    break;
                case 'E':
                    word.add(new MorseLetter().add(DOT));
                    break;
                case 'F':
                    word.add(new MorseLetter().add(DOT, DOT, DASH, DOT));
                    break;
                case 'G':
                    word.add(new MorseLetter().add(DASH, DASH, DOT));
                    break;
                case 'H':
                    word.add(new MorseLetter().add(DOT, DOT, DOT, DOT));
                    break;
                case 'I':
                    word.add(new MorseLetter().add(DOT, DOT));
                    break;
                case 'J':
                    word.add(new MorseLetter().add(DOT, DASH, DASH, DASH));
                    break;
                case 'K':
                    word.add(new MorseLetter().add(DASH, DOT, DASH));
                    break;
                case 'L':
                    word.add(new MorseLetter().add(DOT, DASH, DOT, DOT));
                    break;
                case 'M':
                    word.add(new MorseLetter().add(DASH, DASH));
                    break;
                case 'N':
                    word.add(new MorseLetter().add(DASH, DOT));
                    break;
                case 'O':
                    word.add(new MorseLetter().add(DASH, DASH, DASH));
                    break;
                case 'P':
                    word.add(new MorseLetter().add(DOT, DASH, DASH, DOT));
                    break;
                case 'Q':
                    word.add(new MorseLetter().add(DASH, DASH, DOT, DASH));
                    break;
                case 'R':
                    word.add(new MorseLetter().add(DOT, DASH, DOT));
                    break;
                case 'S':
                    word.add(new MorseLetter().add(DOT, DOT, DOT));
                    break;
                case 'T':
                    word.add(new MorseLetter().add(DASH));
                    break;
                case 'U':
                    word.add(new MorseLetter().add(DOT, DOT, DASH));
                    break;
                case 'V':
                    word.add(new MorseLetter().add(DOT, DOT, DOT, DASH));
                    break;
                case 'W':
                    word.add(new MorseLetter().add(DOT, DASH, DASH));
                    break;
                case 'X':
                    word.add(new MorseLetter().add(DASH, DOT, DOT, DASH));
                    break;
                case 'Y':
                    word.add(new MorseLetter().add(DASH, DOT, DASH, DASH));
                    break;
                case 'Z':
                    word.add(new MorseLetter().add(DASH, DASH, DOT, DOT));
                    break;

                case '0':
                    word.add(new MorseLetter().add(DASH, DASH, DASH, DASH, DASH));
                    break;
                case '1':
                    word.add(new MorseLetter().add(DOT, DASH, DASH, DASH, DASH));
                    break;
                case '2':
                    word.add(new MorseLetter().add(DOT, DOT, DASH, DASH, DASH));
                    break;
                case '3':
                    word.add(new MorseLetter().add(DOT, DOT, DOT, DASH, DASH));
                    break;
                case '4':
                    word.add(new MorseLetter().add(DOT, DOT, DOT, DOT, DASH));
                    break;
                case '5':
                    word.add(new MorseLetter().add(DOT, DOT, DOT, DOT, DOT));
                    break;
                case '6':
                    word.add(new MorseLetter().add(DASH, DOT, DOT, DOT, DOT));
                    break;
                case '7':
                    word.add(new MorseLetter().add(DASH, DASH, DOT, DOT, DOT));
                    break;
                case '8':
                    word.add(new MorseLetter().add(DASH, DASH, DASH, DOT, DOT));
                    break;
                case '9':
                    word.add(new MorseLetter().add(DASH, DASH, DASH, DASH, DOT));
                    break;
                default:
                    throw new UnknownCharacterException(this, String.valueOf(c), "This translator supports [A-z0-9].");
            }
        }
        morse.add(word);

        return morse;
    }

    @Override
    public MorseSignal toMorseSignal(@NotNull MorseCode code) {
        MorseSignal signal = new MorseSignal();

        List<MorseWord> words = code.getWords();
        for (int i = 0; i < words.size(); i++) {
            MorseWord word = words.get(i);

            if(i > 0) // If it isn't first: 5. The space between words is seven units.
                signal.add(false, false, false, false, false, false, false);

            List<MorseLetter> letters = word.getLetters();
            for (int j = 0; j < letters.size(); j++) {
                MorseLetter letter = letters.get(j);

                if(j > 0) // If it isn't first: 4. The space between letters is three units.
                    signal.add(false, false, false);

                List<MorseSymbol> symbols = letter.getSymbols();

                for (int k = 0; k < symbols.size(); k++) {
                    MorseSymbol symbol = symbols.get(k);

                    if(k > 0) // If it isn't first: 3. The space between parts of the same letter is one unit.
                        signal.add(false);

                    if(symbol == DASH) {
                        signal.add(true, true, true); // 2. A dash is three units.
                    } else {
                        signal.add(true); // 1. The length of a dot is one unit.
                    }
                }
            }
        }
        return signal;
    }

    @Override
    public MorseCode fromMorseSignal(@NotNull MorseSignal signal) throws UnknownSymbolLengthException {
        MorseCode morse = new MorseCode();
        List<List<Boolean>> words = BoolSplit.split(signal.getSignals(), false7);
        for (List<Boolean> word : words) {
            MorseWord oWord = new MorseWord();

            List<List<Boolean>> letters = BoolSplit.split(word, false3);
            for (List<Boolean> letter : letters) {
                MorseLetter oLetter = new MorseLetter();

                List<List<Boolean>> symbols = BoolSplit.split(letter, false1);
                for (List<Boolean> symbol : symbols) {
                    switch (symbol.size()) {
                        case 0:
                            break;
                        case 1:
                            oLetter.add(MorseSymbol.DOT);
                            break;
                        case 3:
                            oLetter.add(MorseSymbol.DASH);
                            break;
                        default:
                            throw new UnknownSymbolLengthException(this, symbol.size(), "");
                    }
                }

                oWord.add(oLetter);
            }

            morse.add(oWord);
        }
        return morse;
    }

    @Override
    public String fromMorseCode(@NotNull MorseCode code) throws UnknownSymbolException, UnknownLetterLength {
        String output = "";

        List<MorseWord> words = code.getWords();
        for (int i = 0; i < words.size(); i++) {
            MorseWord word = words.get(i);

            if(i > 0)
                output += " ";


            List<MorseLetter> letters = word.getLetters();
            for (MorseLetter letter : letters) {
                List<MorseSymbol> symbols = letter.getSymbols();

                if(symbols.isEmpty())
                    continue;

                @Nullable MorseSymbol s1 = symbols.size() > 0 ? symbols.get(0) : null;
                @Nullable MorseSymbol s2 = symbols.size() > 1 ? symbols.get(1) : null;
                @Nullable MorseSymbol s3 = symbols.size() > 2 ? symbols.get(2) : null;
                @Nullable MorseSymbol s4 = symbols.size() > 3 ? symbols.get(3) : null;
                @Nullable MorseSymbol s5 = symbols.size() > 4 ? symbols.get(4) : null;

                if (symbols.size() == 1) {
                    if (s1 == DOT) {
                        output += "E";
                    } else if (s1 == DASH) {
                        output += "T";
                    } else {
                        throw new UnknownSymbolException(this, s1, "It supports DOT or DASH symbol.");
                    }
                } else if (symbols.size() == 2) {
                    if (Arrays.equals(new MorseSymbol[]{s1, s2}, new MorseSymbol[]{DOT, DOT})) {
                        output += "I";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2}, new MorseSymbol[]{DOT, DASH})) {
                        output += "A";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2}, new MorseSymbol[]{DASH, DOT})) {
                        output += "N";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2}, new MorseSymbol[]{DASH, DASH})) {
                        output += "M";
                    } else {
                        throw new UnknownSymbolException(this, null, "It supports DOT or DASH symbol.");
                    }
                } else if (symbols.size() == 3) {
                    if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DOT, DOT, DOT})) {
                        output += "S";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DOT, DOT, DASH})) {
                        output += "U";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DOT, DASH, DOT})) {
                        output += "R";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DOT, DASH, DASH})) {
                        output += "W";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DASH, DOT, DOT})) {
                        output += "D";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DASH, DOT, DASH})) {
                        output += "K";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DASH, DASH, DOT})) {
                        output += "G";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3}, new MorseSymbol[]{DASH, DASH, DASH})) {
                        output += "O";
                    } else {
                        throw new UnknownSymbolException(this, null, "It supports DOT or DASH symbol.");
                    }
                } else if (symbols.size() == 4) {
                    if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DOT, DOT, DOT})) {
                        output += "H";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DOT, DOT, DASH})) {
                        output += "V";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DOT, DASH, DOT})) {
                        output += "F";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DASH, DOT, DOT})) {
                        output += "L";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DASH, DASH, DOT})) {
                        output += "P";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DOT, DASH, DASH, DASH})) {
                        output += "J";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DOT, DOT, DOT})) {
                        output += "B";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DOT, DOT, DASH})) {
                        output += "X";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DOT, DASH, DOT})) {
                        output += "C";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DOT, DASH, DASH})) {
                        output += "Y";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DASH, DOT, DOT})) {
                        output += "Z";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4}, new MorseSymbol[]{DASH, DASH, DOT, DASH})) {
                        output += "Q";
                    } else {
                        throw new UnknownSymbolException(this, null, String.format("Unknown symbol crafting: {%s, %s, %s, %s}.", s1, s2, s3, s4));
                    }
                } else if (symbols.size() == 5) {
                    if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DASH, DASH, DASH, DASH, DASH})) {
                        output += "0";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DOT, DASH, DASH, DASH, DASH})) {
                        output += "1";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DOT, DOT, DASH, DASH, DASH})) {
                        output += "2";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DOT, DOT, DOT, DASH, DASH})) {
                        output += "3";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DOT, DOT, DOT, DOT, DASH})) {
                        output += "4";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DOT, DOT, DOT, DOT, DOT})) {
                        output += "5";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DASH, DOT, DOT, DOT, DOT})) {
                        output += "6";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DASH, DASH, DOT, DOT, DOT})) {
                        output += "7";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DASH, DASH, DASH, DOT, DOT})) {
                        output += "8";
                    } else if (Arrays.equals(new MorseSymbol[]{s1, s2, s3, s4, s5}, new MorseSymbol[]{DASH, DASH, DASH, DASH, DOT})) {
                        output += "9";
                    } else {
                        throw new UnknownSymbolException(this, null, String.format("Unknown symbol crafting: {%s, %s, %s, %s, %s}.", s1, s2, s3, s4, s5));
                    }
                } else {
                    throw new UnknownLetterLength(this, symbols.size(), "It supports 1~5 length");
                }
            }
        }
        return output;
    }
}

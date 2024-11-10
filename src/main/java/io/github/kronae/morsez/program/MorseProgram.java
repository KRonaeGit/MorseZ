package io.github.kronae.morsez.program;

import io.github.kronae.morsez.translate.exception.UnknownCharacterException;
import io.github.kronae.morsez.translate.exception.UnknownLetterLength;
import io.github.kronae.morsez.translate.exception.UnknownSymbolException;
import io.github.kronae.morsez.translate.exception.UnknownSymbolLengthException;

import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;

public class MorseProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print(">>> ");

            String cmd = scanner.nextLine().toUpperCase();
            String[] line = cmd.split("\\s");
            if(line.length == 1 && line[0].isEmpty())
                continue;

            if (line[0].equals("SKTU"))
                break;

            try {
                switch (line[0]) {
                    case "TSIG":
                        MorseProgramTSIG.exec(cmd);
                        break;
                    case "FSIG":
                        MorseProgramFSIG.exec(cmd);
                        break;
                    case "PLAY":
                        MorseProgramPLAY.exec(line);
                        break;
                    case "NLNL":
                        System.out.println();
                        System.out.println();
                        break;
                    default:
                        System.out.println("> Unknown Command: " + line[0]);
                }
            } catch (UnknownCharacterException | LineUnavailableException | InterruptedException |
                     UnknownSymbolLengthException | UnknownSymbolException | UnknownLetterLength e) {
                throw new RuntimeException(e);
            }
        }
    }
}

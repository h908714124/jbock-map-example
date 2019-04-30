package de.h90.example;

import de.h90.example.commandline.GradleArgs;
import de.h90.example.commandline.GradleArgs_Parser;

public class Main {

    public static void main(String[] argv) {
        GradleArgs args = GradleArgs_Parser.create()
                .withIndent(4)
                .parseOrExit(argv);
        System.out.println(args.headers());
    }
}

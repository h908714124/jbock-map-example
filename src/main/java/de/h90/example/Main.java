package de.h90.example;

import static java.util.ResourceBundle.getBundle;

public class Main {

    public static void main(String[] argv) {
        MapArgs args = MapArgs_Parser.create()
                .withIndent(4)
                .withResourceBundle(getBundle("de.h90.example.bundle.MyBundle"))
                .parseOrExit(argv);
        System.out.println(args.headers());
    }
}

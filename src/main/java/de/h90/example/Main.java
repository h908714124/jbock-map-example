package de.h90.example;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] argv) {
        ResourceBundle messages = ResourceBundle.getBundle("de/h90/example/bundle/MyBundle");
        MapArgs args = MapArgs_Parser.create()
                .withResourceBundle(messages)
                .parseOrExit(argv);
        System.out.println(args.headers());
    }
}

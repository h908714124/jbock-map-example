package de.h90.example;

import java.io.InputStream;

public class Main {

    public static void main(String[] argv) {
        InputStream messages = Main.class.getResourceAsStream("/de/h90/example/bundle/MyBundle_"
                + System.getProperty("user.language")
                + ".properties");
        MapArgs args = MapArgs_Parser.create()
                .withIndent(4)
                .withMessages(messages)
                .parseOrExit(argv);
        System.out.println(args.headers());
    }
}

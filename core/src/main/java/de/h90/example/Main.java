package de.h90.example;

import de.h90.example.commandline.GradleArgs_Parser;

public class Main {

  public static void main(String[] args) {
    System.out.println(GradleArgs_Parser.create().parseOrExit(args));
  }
}

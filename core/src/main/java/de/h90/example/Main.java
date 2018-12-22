package de.h90.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import de.h90.example.commandline.GradleArgs;
import de.h90.example.commandline.GradleArgs_Parser;

public class Main {

  private static final ObjectWriter WRITER = new ObjectMapper()
      .writerFor(GradleArgs.class);

  public static void main(String[] argv) throws JsonProcessingException {
    GradleArgs args = GradleArgs_Parser.create().parseOrExit(argv);
    System.out.println(WRITER.writeValueAsString(args));
  }
}

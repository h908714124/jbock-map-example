package de.h90.example.commandline;

import net.jbock.CommandLineArguments;
import net.jbock.PositionalParameter;

import java.util.List;

@CommandLineArguments
public abstract class GradleArgs {

  @PositionalParameter(repeatable = true)
  public abstract List<String> operations();
}

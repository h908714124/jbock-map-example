package de.h90.example.commandline;

import com.fasterxml.jackson.annotation.JsonGetter;
import net.jbock.CommandLineArguments;
import net.jbock.PositionalParameter;

import java.util.List;

@CommandLineArguments
public abstract class GradleArgs {

  @JsonGetter
  @PositionalParameter(repeatable = true)
  public abstract List<String> operations();
}

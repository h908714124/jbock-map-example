package de.h90.example.commandline;

import net.jbock.CommandLineArguments;
import net.jbock.Positional;

import java.util.List;

@CommandLineArguments
public abstract class GradleArgs {

    @Positional
    public abstract List<String> operations();
}

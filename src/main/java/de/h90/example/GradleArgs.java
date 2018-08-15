package de.h90.example;

import net.jbock.CommandLineArguments;
import net.jbock.Positional;

import java.util.List;

@CommandLineArguments
abstract class GradleArgs {

    @Positional
    abstract List<String> operations();
}

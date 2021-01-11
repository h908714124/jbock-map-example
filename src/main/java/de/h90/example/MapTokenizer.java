package de.h90.example;

import net.jbock.Mapper;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Function;

@Mapper
class MapTokenizer implements Function<String, Map.Entry<String, String>> {

    @Override
    public Map.Entry<String, String> apply(String s) {
        if (!s.startsWith("-")) {
            throw new IllegalArgumentException("tokens must start with '-'");
        }
        s = s.substring(1);
        String[] tokens = s.split("[=]", 2);
        if (tokens.length != 2) {
            throw new IllegalArgumentException("token must be of the form '-a=b'");
        }
        return new AbstractMap.SimpleImmutableEntry<>(tokens[0], tokens[1]);
    }
}

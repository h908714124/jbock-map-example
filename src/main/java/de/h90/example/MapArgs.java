package de.h90.example;

import net.jbock.CommandLineArguments;
import net.jbock.PositionalParameter;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This is the program description. Its internationalization bundle key is 'jbock.description'.
 */
@CommandLineArguments(
        allowPrefixedTokens = true,
        programName = "parse-map",
        missionStatement = "This is the project's mission. Its internationalization bundle key is 'jbock.mission'.")
abstract class MapArgs {

    /**
     * A HTTP header
     */
    @PositionalParameter(
            mappedBy = MapTokenizer.class,
            collectedBy = MapCollector.class,
            bundleKey = "headers")
    abstract Map<String, String> headers();

    static class MapTokenizer implements Function<String, Entry<String, String>> {

        @Override
        public Entry<String, String> apply(String s) {
            if (!s.startsWith("-")) {
                throw new IllegalArgumentException("tokens must start with '-'");
            }
            s = s.substring(1);
            String[] tokens = s.split("[=]", 2);
            if (tokens.length != 2) {
                throw new IllegalArgumentException("token must be of the form '-a=b'");
            }
            return new SimpleImmutableEntry<>(tokens[0], tokens[1]);
        }
    }

    static class MapCollector<K, V> implements Supplier<Collector<Entry<K, V>, ?, Map<K, V>>> {

        @Override
        public Collector<Entry<K, V>, ?, Map<K, V>> get() {
            return Collectors.toMap(Entry::getKey, Entry::getValue);
        }
    }
}


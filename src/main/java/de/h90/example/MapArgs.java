package de.h90.example;

import net.jbock.CommandLineArguments;
import net.jbock.Parameter;

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
        programName = "parse-map",
        missionStatement = "This is the project's mission. Its internationalization bundle key is 'jbock.mission'.")
abstract class MapArgs {

    /**
     * A HTTP header
     */
    @Parameter(
            repeatable = true,
            shortName = 'X',
            mappedBy = MapTokenizer.class,
            collectedBy = MapCollector.class,
            bundleKey = "headers")
    abstract Map<String, String> headers();

    static class MapTokenizer implements Function<String, Entry<String, String>> {

        @Override
        public Entry<String, String> apply(String s) {
            String[] tokens = s.split("[=]", 2);
            if (tokens.length != 2) {
                throw new IllegalArgumentException("try '-X Header1=foo -X Header2=bar'");
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


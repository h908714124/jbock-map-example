package de.h90.example;

import net.jbock.CommandLineArguments;
import net.jbock.Parameter;

import java.util.AbstractMap;
import java.util.Map;
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
    @Parameter(repeatable = true,
            shortName = 'H',
            mappedBy = MapTokenizer.class,
            collectedBy = MapCollector.class,
            bundleKey = "headers")
    abstract Map<String, String> headers();

    // sample mapper
    static class MapTokenizer implements Supplier<Function<String, Map.Entry<String, String>>> {

        @Override
        public Function<String, Map.Entry<String, String>> get() {
            return s -> {
                String[] tokens = s.split("[=]", 2);
                if (tokens.length != 2) {
                    throw new IllegalArgumentException("try '-X Header1=foo -X Header2=bar'");
                }
                return new AbstractMap.SimpleImmutableEntry<>(tokens[0].trim(), tokens[1].trim());
            };
        }
    }

    // sample collector
    static class MapCollector<K, V> implements Supplier<Collector<Map.Entry<K, V>, ?, Map<K, V>>> {

        @Override
        public Collector<Map.Entry<K, V>, ?, Map<K, V>> get() {
            return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
        }
    }
}


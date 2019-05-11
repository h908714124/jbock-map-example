package de.h90.example;

import net.jbock.CommandLineArguments;
import net.jbock.Parameter;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@CommandLineArguments
abstract class MapArgs {

    /**
     * A HTTP header
     */
    @Parameter(repeatable = true,
            shortName = 'X',
            mappedBy = MapTokenizer.class,
            collectedBy = MapCollector.class,
            bundleKey = "headers")
    abstract Map<String, String> headers();

    static class MapTokenizer implements Supplier<Function<String, Map.Entry<String, String>>> {

        @Override
        public Function<String, Map.Entry<String, String>> get() {
            return s -> {
                String[] tokens = s.split(":", 2);
                if (tokens.length < 2) {
                    throw new IllegalArgumentException("Invalid pair: " + s);
                }
                return new AbstractMap.SimpleImmutableEntry<>(tokens[0].trim(), tokens[1].trim());
            };
        }
    }

    static class MapCollector<K, V> implements Supplier<Collector<Map.Entry<K, V>, ?, Map<K, V>>> {

        @Override
        public Collector<Map.Entry<K, V>, ?, Map<K, V>> get() {
            return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
        }
    }
}

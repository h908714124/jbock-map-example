package de.h90.example;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class MapCollector<K, V> implements Supplier<Collector<Map.Entry<K, V>, ?, Map<K, V>>> {

    @Override
    public Collector<Map.Entry<K, V>, ?, Map<K, V>> get() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }
}

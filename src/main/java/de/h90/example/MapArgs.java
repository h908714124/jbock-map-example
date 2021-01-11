package de.h90.example;

import net.jbock.Command;
import net.jbock.Param;

import java.util.List;
import java.util.Map;


@Command("parse-map")
abstract class MapArgs {

    /**
     * A HTTP header
     */
    @Param(value = 1,
            mappedBy = MapTokenizer.class,
            bundleKey = "headers")
    abstract List<Map.Entry<String, String>> headers();

    Map<String, String> headersAsMap() {
        return headers().stream().collect(new MapCollector<String, String>().get());
    }
}

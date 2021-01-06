package de.h90.example;

import net.jbock.Command;
import net.jbock.Param;

import java.util.Map;


@Command("parse-map")
abstract class MapArgs {

    /**
     * A HTTP header
     */
    @Param(value = 1,
            mappedBy = MapTokenizer.class,
            collectedBy = MapCollector.class,
            bundleKey = "headers")
    abstract Map<String, String> headers();

}

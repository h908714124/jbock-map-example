package de.h90.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GradleArgsTest {

    @Test
    void simpleTest() {
        Optional<GradleArgs> parsed = GradleArgs_Parser.parse(new String[]{"clean", "build"}, System.out);
        assertTrue(parsed.isPresent());
        assertThat(parsed.get().operations(), is(Arrays.asList("clean", "build")));
    }
}
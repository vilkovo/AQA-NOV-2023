package org.prog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JUnitTests {

    @BeforeAll
    public static void setUp() {

    }

    @BeforeEach
    public void beforeTest() {

    }

    @Test
    public void myTest1() {
        System.out.println("Test 1 works!");
    }

    @Test
    public void myTest2() {
        System.out.println("Test 2 works!");
    }

    @ParameterizedTest
    @MethodSource("args")
    public void paramsTest(String value, String value2, boolean flag){
        if (flag){
            System.out.println(value);
        } else {
            System.out.println(value2);
        }
    }

    public static Stream<Arguments> args(){
        return Stream.of(
                Arguments.of("Flag is true", "Flag is false", true),
                Arguments.of("Flag is true", "Flag is false", false),
                Arguments.of("Flag is true", "Flag is false", false),
                Arguments.of("Flag is true", "Flag is false", false),
                Arguments.of("Flag is true", "Flag is false", true)
        );
    }

    @AfterEach
    public void afterTest() {
        System.out.println("---------------");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After all tests");
    }
}

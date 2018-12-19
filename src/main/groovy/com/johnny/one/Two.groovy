package com.johnny.one

import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.Stream

import static java.lang.Integer.parseInt
import static java.util.function.Function.identity
import static java.util.stream.Collectors.*

class Two {
    static List<String> boxes = new File(getClass().getResource('/day-two-input.txt').toURI()).readLines()

    public static void partOne() {
        boxes.each { box ->
            println(box)
            List<String> list = box.codePoints()
                    .mapToObj { c -> String.valueOf((char) c) }
                    .collect(toList())

            Map<String, Long> map = list.stream()
                    .collect(groupingBy(identity(), Collectors.counting()))

            map.forEach { a, count ->
                if (count == 2 || count == 3) {
                    println(a + ":" + count)
                }
            }

            int twos = map.keySet().stream()
                    .filter { key -> map.get(key) == 2 }
                    .collect(Collectors.counting())

            int threes = map.keySet().stream()
                    .filter { key -> map.get(key) == 3 }
                    .collect(Collectors.counting())

            println("Twos: $twos")
            println("Threes: $threes")
            println("checksum: ${twos * threes}")
        }
    }



    public static void partTwo(){

    }
}

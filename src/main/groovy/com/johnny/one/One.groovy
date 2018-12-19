package com.johnny.one


import static java.lang.Integer.parseInt

class One {
    static List<Integer> changes

    static {
        changes = new File(getClass().getResource('/day-one-input.txt').toURI())
                .readLines()
                .collect {
            parseInt(it)
        }
    }

    public static void partOne() {
        println "The sum of all the frequency changes is: ${changes.sum()}"
    }

    public static void partTwo() {
        int frequency
        Set<Integer> allChanges = []

        while (true) {
            def result = changes.findResult {
                // the add method returns false if the set already contains a value
                !allChanges.add( frequency+= it) ? frequency :  null
            }
            if (result) {
                println("The first duplicate is $result")
                break;
            }
        }
    }
}

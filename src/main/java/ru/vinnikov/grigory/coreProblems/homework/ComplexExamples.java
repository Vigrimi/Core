package ru.vinnikov.grigory.coreProblems.homework;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ComplexExamples {

    public static class Person {
        final int id;
        final String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(8, "Amelia"),
            new Person(3, "Emily"),
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"), // "Amelia"
            new Person(7, "Amelia"), // "Amelia"
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
//        System.out.println("Raw data:");
//        System.out.println();
//        for (Person person : RAW_DATA) {
//            System.out.println(person.id + " - " + person.name);
//        }
//        System.out.println();
//        System.out.println("**************************************************");
//        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
//        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */
        System.out.println("\nTask1.");
        String JOHN_DOE = "JohnDoeNull";

        if (RAW_DATA == null) {
            System.out.println("Упс, входные данные - массив null, попробуйте позже -_-");
        } else {
            Set<Person> resultTask1 = Arrays.stream(RAW_DATA).sorted(Comparator.comparing(Person::getId))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            TreeMap<String, Integer> countMap = new TreeMap<>();
            for (Person person : resultTask1) {
                countMap.put(Optional.ofNullable(person.getName()).orElse(JOHN_DOE)
                        ,countMap.getOrDefault(Optional.ofNullable(person.getName()).orElse(JOHN_DOE), 0) + 1);
            }
            countMap.forEach((key, value) -> System.out.println("Key:" + key + "\nValue:" + value));
        }

        /* ---------------------------------------------------------------------
        Task2
            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
         */
        int[] incomingArray = new int[]{3, 4, 2, 7};
        int[] result = new int[2];
        int sum10 = 10;
        int FIRST_ELEMENT = 0;
        int SECOND_ELEMENT = 1;

        if (incomingArray == null || result == null){
            System.out.println("Упс, входные данные - массив null, попробуйте позже -_-");
        } else {
            boolean possibleTask2 = false;
            Hashtable<Integer, Integer> hashtable = new Hashtable();
            for (int i = 0; i < incomingArray.length; i++) {
                if (hashtable.containsKey(sum10-incomingArray[i])){
                    result[FIRST_ELEMENT] = incomingArray[hashtable.get(sum10-incomingArray[i])];
                    result[SECOND_ELEMENT] = incomingArray[i];
                    possibleTask2 = true;
                    break;
                } else {
                    hashtable.put(incomingArray[i], i);
                }
            }
            System.out.println("\nTask2.");
            System.out.println(possibleTask2 ? Arrays.toString(result) : "Не существует пары, которая даёт сумму = 10.");
        }

        /* --------------------------------------------------------
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
        HashMap<String, String> frazesForSearch = new HashMap<>((Map.of(
                "car","ca6$$#_rtwheel",
                "cwhl","cartwheel",
                "cwhee","cartwheel",
                "cartwheel","cartwheel",
                "cwheeel","cartwheel",
                "lw","cartwheel")));

        System.out.println("\nTask3.");
        BiFunction<String, String, String> fuzzySearch = (s1, s2) -> {
            String s2Incoming = s2;
            int qtyEquals = 0;
            if ((s1.length() <= s2.length()) && s1 != null && s2 != null) {
                char[] s1CharArray = s1.toCharArray();
                for (int i = 0; i < s1CharArray.length; i++) {
                     if (s2.contains(String.valueOf(s1CharArray[i]))) {
                        qtyEquals++;
                        int order = s2.indexOf(String.valueOf(s1CharArray[i]));
                        s2 = s2.substring(order + 1);
                    }
                }
            }
            return "\"" + s1 + "\"-=AND=-\"" + s2Incoming + "\": " + (qtyEquals == s1.length());
        };

        if (frazesForSearch == null){
            System.out.println("Упс, входные данные - массив null, попробуйте позже -_-");
        } else {
            List<String> resultTask3 = frazesForSearch.entrySet().stream()
                    .map((s) -> fuzzySearch.apply(s.getKey(),s.getValue()))
                    .toList();
            System.out.println(resultTask3);
        }
    }
}

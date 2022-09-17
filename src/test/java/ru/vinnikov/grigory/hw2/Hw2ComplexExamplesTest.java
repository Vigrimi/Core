package ru.vinnikov.grigory.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vinnikov.grigory.coreProblems.homework.ComplexExamples;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Hw2ComplexExamplesTest {
    public Hw2ComplexExamplesTest() {
    }

    @Test
    void duplicateSortArrayTest(){
        // given
        ComplexExamples.Person[] RAW_DATA = new ComplexExamples.Person[]{
                new ComplexExamples.Person(6, "Amelia"),
                new ComplexExamples.Person(5, "Amelia"),
                new ComplexExamples.Person(4, "Jack"),
                new ComplexExamples.Person(5, "Amelia"),
        };
        Set<ComplexExamples.Person> correctExample = new LinkedHashSet<>();
        correctExample.add(new ComplexExamples.Person(4, "Jack"));
        correctExample.add(new ComplexExamples.Person(5, "Amelia"));
        correctExample.add(new ComplexExamples.Person(6, "Amelia"));

        // when Убрать дубликаты, отсортировать по идентификатору Id
        Set<ComplexExamples.Person> resultTask1 = Arrays.stream(RAW_DATA)
                .sorted(Comparator.comparing(ComplexExamples.Person::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // result
        Assertions.assertIterableEquals(correctExample, resultTask1); // exp act
    }
}

package com.jo;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.example.starter_test.RandomUtils.*;

/*
https://www.baeldung.com/java-8-streams
 */
public class StreamTest {

    List<Staff> staffList = new ArrayList<>();
    String separator = "================";


    @Before
    public void prepareData() {
        Function<Integer, Staff> newStaff = number -> randomPojo(Staff.class, o -> {
            o.setAge(randomInteger(18, 60));
            o.setOrder(number);
        });

        Stream<Integer> integerStream = IntStream.range(0, 10).boxed();
        staffList = integerStream.map(newStaff).collect(Collectors.toList());

        printStaffs();
    }

    public void printStaffs(){
        System.out.println(separator);
        staffList.stream()
                .forEach(System.out::println);
    }

    @Test
    public void sorting(){
        System.out.println(separator);
        staffList.stream()
                .sorted((o1,o2) -> o2.getOrder() - o1.getOrder())
                .forEach(System.out::println);
    }

    @Test
    public void streamTest() {
        System.out.println(separator);
        int avgAge = (staffList.stream()
                .mapToInt(Staff::getAge)
                .sum()) / staffList.size();
        System.out.printf("avgAge is %d",avgAge);
    }

}

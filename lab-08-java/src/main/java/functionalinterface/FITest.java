package functionalinterface;


import java.util.function.Function;

public class FITest {

    public void fiTest(){
        String name = "joey";
        Function<String, Integer> stringLength = String::length;

        System.out.println(stringLength.apply(name));
    }



}

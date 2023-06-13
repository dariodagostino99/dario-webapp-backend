package com.dario.webapp.backend.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.relational.core.sql.In;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
@EnableScheduling
public class DemoApplication {

    static int age;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(age);
    }

    public static List<Integer> orderArrayDesc(int[] array){
        Function<Integer, Integer> squareLambda = x -> x * x;
        return new ArrayList<>();
    }



    // getPositionAt()
    public static int getPositionAt(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return -2;
        }

        int initialState = -1;
        int ultimate = -2;
        int penultimate = 1;
        int temp;

        for (int i = 0; i <= n; i++){
            if (i > 2){
                temp = penultimate;
                penultimate = ultimate;
                ultimate = ultimate - (temp);
                initialState+= ultimate;
            }
        }
        return initialState;
    }

    public static int factorial(int n){
        if (n == 1){
            return n;
        }
        return n * factorial(n - 1);
    }

    // isDouDigit()
    public static String isDuoDigit(int number){
        List<String> numbers = new ArrayList<>(List.of(String.valueOf(number).split("")));
        HashMap<String, String> digits = new HashMap<>();
        for (String n: numbers){
            digits.putIfAbsent(n, n);
        }
        return digits.keySet().size() > 2 ? "n" : "y";
    }

    public static int reduceArray(List<Integer> values){
        if (values.size() == 1){
            return values.get(0);
        }
        int lastIndex = values.size() - 1;
        values.remove(lastIndex);
        return values.get(values.size()-1) + reduceArray(values);
    }

    public static boolean isPalindrome(String word){
        List<String> letters = Arrays.asList(word.split(""));
        String result = "";
        for (int i = word.length() - 1; i >=0; i --){
            result+=letters.get(i);
        }
        return result.equals(word);
    }

    public static boolean hasOnlyOdds(List<Integer> values){
        for (Integer value: values){
            if (value % 2 != 0) return false;
        }
        return true;
    }

    /**
     * fibonacci is a series of numbers starting from 0, 1 that
     * corresponds to the sum of last two values.
     *
     * 0, 1, 1, 2, 3, 5, 8, 13, 21 ...
     */
    public static int fibonacci(int length){
        if (length <= 1) return length;
        return fibonacci(length - 1) + fibonacci(length - 2);
    }

    /**
     * check if you can divide value only by 1 and by itself giving 0 as rest
     * for that, create a list containing from 1 to value and start dividing value by them
     * if result is zero, add it to a list
     * at the end, the list should be 2 size of large (1 and value itself)
     */
    public static Boolean isPrime(int value){

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= value; i++){
            divisors.add(i);
        }
        List<Integer> result = divisors.stream().filter(d -> value % d == 0).collect(Collectors.toList());
        return result.size() == 2;
    }

    public static void exercises() {
        // Q #1) Write a Java Program to reverse a string without using String inbuilt function.
        // 1 accept input type String
        // 2 create a list being each letter an element
        // 3 iterate backwards and append each letter to final String
        // 4 return string
        // code
        // in java always the start value of an index is zero.
        int firstLetter = 0;
        String example = "example"; // desired = elpmaxe
        List<String> letters = Arrays.asList(example.split("")); // [e,x,a,m,p,l,e]
        int length = (int) letters.size() - 1;
        String finalString = "";
        for (int i = length; i >= firstLetter; i--) {
            finalString += letters.get(i);
        }
        System.out.printf("The initial String is: %s and the final String is: %s%n", example, finalString);

        // Q #3) Write a Java Program to swap two numbers using the third variable.
        String a = "1";
        String b = "2";
        String temp = "0";
        System.out.println("Before execution");
        System.out.printf("A value is: %s, B value is %s%n", a, b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("After execution");
        System.out.printf("A value is: %s, B value is %s%n", a, b);


        // Q#4) Write a Java Program to swap two numbers without using the third variable.
        // create two variables, c and d;
        // c will temporally hold both values appended
        // then d will extract first value from c
        // lately c will hold only second value

        int c = 1;
        int d = 2;
        System.out.printf("C value is: %s, D value is %s", c, d);
        System.out.println("");
        c = (c + d);
        d = (c - d);
        c = (c - d);
        System.out.printf("C value is: %s, D value is %s", c, d);
        System.out.println("");

        // Q #5) Write a Java Program to count the number of words in a string using HashMap.
        String phrase = "Hi my name is dario and I am a software dev!";

        System.out.println(phrase);

        List<String> words = Arrays.asList(phrase.split(" "));
        HashMap<String, Integer> map = new HashMap<>() {{
            for (int i = 0; i < words.size(); i++) {
                put(words.get(i), i);
            }
        }};

        int amountOfWords = map.keySet().size();

        System.out.println("Amount of words: " + amountOfWords);
    }
}

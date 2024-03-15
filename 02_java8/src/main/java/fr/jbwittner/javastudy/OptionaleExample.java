package fr.jbwittner.javastudy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionaleExample {

    public static void main(String[] args) {
        emptyOptional();
        presentOptional();
        ofNullableNotNull();
        ofNullableNull();
        filter();
        map();
    }

    public static void emptyOptional() {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());
    }

    public static void presentOptional() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());
    }

    public static void ofNullableNotNull() {
        String name = "baeldung";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());
    }

    public static void ofNullableNull() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());
    }

    public static void orElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(name);
    }

    public static void orElseGet() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        System.out.println(name);
    }

    public static void filter() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);
    }

    public static void map() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional.map(List::size).orElse(0);

        System.out.println(size);
    }
}

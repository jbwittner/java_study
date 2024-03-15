package fr.jbwittner.javastudy;

import java.util.Optional;

public class OptionaleExample {

    public static void main(String[] args) {
        emptyOptional();
        presentOptional();
    }

    public static void emptyOptional() {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
    }

    public static void presentOptional() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());
    }
}

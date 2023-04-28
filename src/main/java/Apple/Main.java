package Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple(160, Color.GREEN),
                new Apple(100, Color.RED),
                new Apple(200, Color.GREEN),
                new Apple(170, Color.RED)
        );
        Comparator<Apple> byWeight = Comparator.comparingInt((Apple a) -> a.getWeight());

        System.out.println(filterApples(apples, (Apple apple) -> Color.RED.equals(apple.getColor())));
        System.out.println(filterApples(apples, (Apple apple) -> apple.getWeight() > 150));
        prettyPrintApple(apples, (Apple apple) -> apple.getWeight() > 150);
        apples.stream()
                .sorted(byWeight)
                .forEach(System.out::println);

        Function<List<Apple>, Integer> lengthOfList = List::size;
        System.out.println(lengthOfList);
        IntBinaryOperator multiply = (int a, int b) -> a * b;
        System.out.println("multiply.applyAsInt(1, 2) = " + multiply.applyAsInt(1, 2));
        Consumer<String> print = System.out::println;
        print.accept("Hello");
        Supplier<Integer> age = () -> 150;
        System.out.println("age.get() = " + age.get());
        BiFunction<String, String, Integer> countOfLetter = (String word1, String word2) -> word1.length() + word2.length();
        System.out.println("countOfLetter.apply(\"Hello\", \"World\") = " + countOfLetter.apply("Hello", "World"));
    }

    public static <T> List<T> filterApples(List<T> someone, ApplePredicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : someone) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static <T> void prettyPrintApple(List<T> someone, ApplePredicate<T> p) {
        for (T e : someone) {
            if (p.test(e)) {
                System.out.println("A heavy apple");
            } else {
                System.out.println("A light apple");

            }
        }

    }


//       MeaningOfThis meaning = new MeaningOfThis();
//       meaning.doIt();

}


package Apple;

import java.nio.file.LinkOption;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple(160, Color.GREEN),
                new Apple(100, Color.RED),
                new Apple(200, Color.GREEN),
                new Apple(170, Color.RED),
                new Apple(210, Color.RED)
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
        BiFunction<String, String, Integer> countOfLetter = (word1, word2) -> word1.length() + word2.length();
        System.out.println("countOfLetter.apply(\"Hello\", \"World\") = " + countOfLetter.apply("Hello", "World"));

        ToIntFunction<String> stringToInt = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;

        List<Integer> app = Arrays.asList(2, 4, 5, 10);
        List<Apple> apples1 = apples(app, Apple::new);
        System.out.println(apples1);

        BiFunction<Integer, Color, Apple> a2 = Apple::new;
        Apple app2 = a2.apply(150, Color.GREEN);
        System.out.println(app2);

        Predicate<Apple> predicate = apple -> apple.getColor().equals(Color.RED);
        Predicate<Apple> and = predicate.negate().and(apple -> apple.getWeight() > 150);
        System.out.println(and.test(apples.get(3)));

        List<Color> heavyApples = apples.stream()
                .filter(a -> a.getWeight() > 150)
                .map(a -> a.getColor())
                .collect(Collectors.toList());

        System.out.println(heavyApples);

        List<Apple> heavy = apples.stream()
                .filter(AppleUtils::heavyApple)
                .collect(Collectors.toList());
        System.out.println(heavy);

        apples.stream()
                .filter(apple -> apple.getColor() == Color.RED)
                .limit(2)
                .forEach(System.out::println);

        Arrays.stream(MathematicalExample.getQuadOfDigit(new int[]{1, 2, 3, 4, 5}))
                .forEach(System.out::println);
        MathematicalExample.pairedDigit(Arrays.asList(1, 2, 3), Arrays.asList(3, 4))
                .stream()
                .filter(arr -> (arr[0] + arr[1]) % 3 == 0)
                .map(d -> Arrays.toString(d))
                .forEach(System.out::println);

        Optional<Apple> greenApple = AppleUtils.getGreenApples(apples);
        System.out.println(greenApple.orElse(app2));

        Optional<Integer> reduce = apples.stream()
                .map(a -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());


    }

    public static List<Apple> apples(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
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


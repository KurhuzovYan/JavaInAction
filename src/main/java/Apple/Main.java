package Apple;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple(160, Color.GREEN, "Golden Delicious"),
                new Apple(100, Color.RED, "McIntosh"),
                new Apple(200, Color.GREEN, "Gala"),
                new Apple(170, Color.RED, "Fuji"),
                new Apple(210, Color.RED, "Golden Delicious")
        );
//        Comparator<Apple> byWeight = Comparator.comparingInt((Apple a) -> a.getWeight());
//
//        System.out.println(filterApples(apples, (Apple apple) -> Color.RED.equals(apple.getColor())));
//        System.out.println(filterApples(apples, (Apple apple) -> apple.getWeight() > 150));
//        prettyPrintApple(apples, (Apple apple) -> apple.getWeight() > 150);
//        apples.stream()
//                .sorted(byWeight)
//                .forEach(System.out::println);
//
//        Function<List<Apple>, Integer> lengthOfList = List::size;
//        System.out.println(lengthOfList);
//        IntBinaryOperator multiply = (int a, int b) -> a * b;
//        System.out.println("multiply.applyAsInt(1, 2) = " + multiply.applyAsInt(1, 2));
//        Consumer<String> print = System.out::println;
//        print.accept("Hello");
//        Supplier<Integer> age = () -> 150;
//        System.out.println("age.get() = " + age.get());
//        BiFunction<String, String, Integer> countOfLetter = (word1, word2) -> word1.length() + word2.length();
//        System.out.println("countOfLetter.apply(\"Hello\", \"World\") = " + countOfLetter.apply("Hello", "World"));
//
//        ToIntFunction<String> stringToInt = Integer::parseInt;
//        BiPredicate<List<String>, String> contains = List::contains;
//
//        List<Integer> app = Arrays.asList(2, 4, 5, 10);
//        List<Apple> apples1 = apples(app, Apple::new);
//        System.out.println(apples1);
//
//        Predicate<Apple> predicate = apple -> apple.getColor().equals(Color.RED);
//        Predicate<Apple> and = predicate.negate().and(apple -> apple.getWeight() > 150);
//        System.out.println(and.test(apples.get(3)));
//
//        List<Color> heavyApples = apples.stream()
//                .filter(a -> a.getWeight() > 150)
//                .map(a -> a.getColor())
//                .collect(Collectors.toList());
//
//        System.out.println(heavyApples);
//
//        List<Apple> heavy = apples.stream()
//                .filter(AppleUtils::heavyApple)
//                .collect(Collectors.toList());
//        System.out.println(heavy);
//
//        apples.stream()
//                .filter(apple -> apple.getColor() == Color.RED)
//                .limit(2)
//                .forEach(System.out::println);
//
//        Arrays.stream(MathematicalExample.getQuadOfDigit(new int[]{1, 2, 3, 4, 5}))
//                .forEach(System.out::println);
//        MathematicalExample.pairedDigit(Arrays.asList(1, 2, 3), Arrays.asList(3, 4))
//                .stream()
//                .filter(arr -> (arr[0] + arr[1]) % 3 == 0)
//                .map(d -> Arrays.toString(d))
//                .forEach(System.out::println);
//
//        Optional<Apple> greenApple = AppleUtils.getGreenApples(apples);
//
//        Optional<Integer> reduce = apples.stream()
//                .map(a -> 1)
//                .reduce(Integer::sum);
////        System.out.println(reduce.get());
//
//        List<Integer> integerList = MathematicalExample.getRange(2, 80).mapToObj(Integer::valueOf).collect(Collectors.toList());
//
////        MathematicalExample.createPythagoreanTriples(2,100).map(Arrays::toString).limit(10).forEach(System.out::println);
////        MathematicalExample.createSequenceOfFibonacci();
        String s = apples.stream().map(Apple::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
        String s2 = apples.stream().collect(reducing("", Apple::getName, (d1, d2) -> d1 + d2));
        System.out.println(s2);
        Map<Color, List<Apple>> groupingApples = AppleUtils.groupingByColor(apples);
        System.out.println(groupingApples);
        System.out.println(AppleUtils.groupingWithFlatMapping(apples));
        System.out.println(AppleUtils.groupingWithTwoGroupingBy(apples));
        System.out.println(AppleUtils.groupingByCounting(apples));
        Map<Color, Apple> colorOptionalMap = AppleUtils.groupingByWeightWithMaxBy(apples);
        MathematicalExample.partitionPrimes(30).forEach((k, v) -> System.out.println(k + ":" + v));

        var annotation = Apple.class.isAnnotation();
        System.out.println(annotation);


//        System.out.println(s);
//        System.out.println("Total weight " + AppleUtils.getTotalWeight(apples) + "g");
//        System.out.println("Average weight " + AppleUtils.getAverageWeight(apples) + "g");
//        IntSummaryStatistics allStatisticAboutApples = AppleUtils.getAllStatisticAboutApples(apples);
//        System.out.println(allStatisticAboutApples);
//        System.out.println(AppleUtils.getNamesOfList(apples));
//        System.out.println("AppleUtils.groupingByWeight = " + AppleUtils.groupingByWeight(apples));

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


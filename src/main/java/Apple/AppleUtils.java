package Apple;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class AppleUtils {

    public static boolean heavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static Optional<Apple> getGreenApples(List<Apple> apples) {
        return apples.stream()
                .filter(a -> a.getColor().equals(Color.YELLOW))
                .findAny();
    }

    public static int getTotalWeight(List<Apple> apples) {
        return apples.stream()
                .collect(summingInt(Apple::getWeight));
    }

    public static double getAverageWeight(List<Apple> apples) {
        return apples.stream()
                .collect(averagingInt(Apple::getWeight));
    }

    public static IntSummaryStatistics getAllStatisticAboutApples(List<Apple> apples) {
        return apples.stream()
                .collect(summarizingInt(Apple::getWeight));
    }

    public static String getNamesOfList(List<Apple> apples) {
        return apples.stream().map(Apple::getName).collect(joining(", "));
    }

    public static Map<Color, List<Apple>> groupingByColor(List<Apple> apples) {
        return apples.stream()
                .collect(groupingBy(Apple::getColor));
    }

    public static Map<String, List<Apple>> groupingByWeight(List<Apple> apples) {
        return apples.stream().collect(
                groupingBy(apple -> {
                    if (apple.getWeight() < 99) return "Light";
                    else if (apple.getWeight() >= 100 && apple.getWeight() <= 199) return "Middle";
                    else return "Heavy";
                }));
    }

    public static Map<Color, Map<String, List<Apple>>> groupingWithTwoGroupingBy(List<Apple> apples) {
        return apples.stream()
                .collect(groupingBy(Apple::getColor,
                        groupingBy(apple -> {
                            if (apple.getWeight() >= 100 && apple.getWeight() <= 199) return "Light";
                            else return "Heavy";
                        })));
    }

    public static Map<Color, Set<Apple>> groupingWithFlatMapping(List<Apple> apples) {
        return apples.stream()
                .collect(groupingBy(Apple::getColor,
                        flatMapping(app -> groupingByColor(apples).get(app.getColor()).stream(),
                                toSet())));
    }

    public static Map<Color, Long> groupingByCounting(List<Apple> apples) {
        return apples.stream()
                .collect(groupingBy(Apple::getColor, counting()));
    }

    public static Map<Color, Apple> groupingByWeightWithMaxBy(List<Apple> apples) {
        return apples.stream()
                .collect(groupingBy(Apple::getColor,
                        collectingAndThen(maxBy(Comparator.comparingInt(Apple::getWeight)), Optional::get)));
    }

}

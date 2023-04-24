package Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(
                new Apple(160, Color.GREEN),
                new Apple(100, Color.RED),
                new Apple(200, Color.GREEN),
                new Apple(170, Color.RED)
        );
        filterApples(apples, new AppleGreenColor());
        filterApples(apples, new RedHeavyApples());
        prettyPrintApple(apples, new PrintOnlyWeight());
    }

    public static void filterApples(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println(result.toString());
    }

    public static void prettyPrintApple(List<Apple> apples, PrettyPrintPredicate p) {
        for (Apple apple: apples) {
            System.out.println(p.prettyPrint(apple));
        }
    }

}
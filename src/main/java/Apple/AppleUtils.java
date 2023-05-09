package Apple;

import java.util.List;
import java.util.Optional;

public class AppleUtils {

    public static boolean heavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static Optional<Apple> getGreenApples(List<Apple> apples) {
        return apples.stream()
                .filter(a -> a.getColor().equals(Color.YELLOW))
                .findAny();
    }


}

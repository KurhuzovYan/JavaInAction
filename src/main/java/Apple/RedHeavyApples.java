package Apple;

public class RedHeavyApples implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }
}

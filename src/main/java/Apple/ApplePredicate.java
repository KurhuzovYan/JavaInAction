package Apple;
@FunctionalInterface
public interface ApplePredicate<T> {
    boolean test(T t);
}

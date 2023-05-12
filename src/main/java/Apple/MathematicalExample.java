package Apple;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MathematicalExample {

    public static int[] getQuadOfDigit(int[] digits) {
        return Arrays.stream(digits)
                .map(d -> d * d)
                .toArray();
    }

    public static List<Integer[]> pairedDigit(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new Integer[]{i, j}))
                .collect(toList());
    }

    public static IntStream getRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(d -> d % 2 == 0)
                .sorted();
    }

    public static Stream<double[]> createPythagoreanTriples(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, end)
                                .mapToObj(b ->
                                        new double[]{a, b, Math.sqrt(a * a + b * b)}))
                .filter(t -> t[2] % 1 == 0);
    }

    public static void createSequenceOfFibonacci() {
        Stream.iterate(new int[]{0, 1}, seed -> new int[]{seed[1], seed[0] + seed[1]})
                .limit(20)
                .map(f -> f[0])
                .forEach(System.out::println);
    }

    private static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(i -> isPrime(i)));
    }
}

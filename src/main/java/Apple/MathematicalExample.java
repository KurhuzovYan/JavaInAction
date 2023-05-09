package Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class MathematicalExample {

    public static int[] getQuadOfDigit(int[] digits){
        return Arrays.stream(digits)
                .map(d -> d * d)
                .toArray();
    }

    public static List<Integer[]> pairedDigit(List<Integer> list1, List<Integer> list2){
        return list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new Integer[]{i, j}))
                .collect(Collectors.toList());
    }

}

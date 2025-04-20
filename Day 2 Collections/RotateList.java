import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;
        int n = list.size();
        k = k % n;
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));
        System.out.println(rotated);
    }
}
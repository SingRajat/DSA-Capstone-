package inheritance.Array;

import java.util.*;

public class TwoSum {
    static int[] TwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = { -1, -1 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(TwoSum(arr, 9)));
    }
}
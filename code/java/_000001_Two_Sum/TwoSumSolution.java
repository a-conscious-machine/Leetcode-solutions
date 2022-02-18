package _000001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution implements TwoSum {

    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

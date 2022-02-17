package _000001_Two_Sum;

import commons.*;

import java.lang.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

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

    public void test() {
        boolean success = false;
        List<TestCase> tests = List.of(
                new TestCase(new InputTest(new int[] {2,7,11,15}, 9), new ExpectedResponse(new int[] {0, 1})),
                new TestCase(new InputTest(new int[] {3, 2, 4}, 6), new ExpectedResponse(new int[] {1, 2})),
                new TestCase(new InputTest(new int[] {3, 3}, 6), new ExpectedResponse(new int[] {0, 1}))
        );
        for(int i = 0;i < tests.size();i++) {
            System.out.println("Running test: " + i);
            try {
                var resp = twoSum(tests.get(i).getInputTest().getNums(), tests.get(i).getInputTest().getTarget());
                if (validateResponse(resp, tests.get(i).getExpectedResponse().getExpectedResult())) {
                    success = true;
                    System.out.println("Success - Test: " + i);
                } else {
                    System.out.println(Arrays.toString(resp));
                    System.err.println("Failed - Test: " + i);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        if (success) {
            System.out.println("Success! " + this.getClass().getSimpleName());
        } else {
            System.err.println("Failed! " + this.getClass().getSimpleName());
        }
    }

    private boolean validateResponse(int[] resp, int[] expectedResult) {
        return Arrays.equals(resp, expectedResult);
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.test();
    }
}

package _000001_Two_Sum.utils;

import _000001_Two_Sum.*;

import java.util.Arrays;
import java.util.List;

public class Evaluator {

    private void test(TwoSum twoSum) {
        boolean success = false;
        List<TestCase> tests = getTestCases();
        for(int i = 0;i < tests.size();i++) {
            try {
                System.out.println("Running test: " + i);
                Runtime runtime = Runtime.getRuntime();
                System.gc();
                long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                long startTime = System.currentTimeMillis();
                var resp = twoSum.twoSum(tests.get(i).getInputArgs().getNums(), tests.get(i).getInputArgs().getTarget());
                long endTime = System.currentTimeMillis();
                System.gc();
                long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                if (validateResponse(resp, tests.get(i).getExpectedObj().getExpectedResult())) {
                    success = true;
                    System.out.println("Success - Test: " + i + ", time: " + (endTime - startTime) + "ms, memoryUsed: " + (usedMemoryAfter - usedMemoryBefore) + "b");
                } else {
                    System.out.println(Arrays.toString(resp));
                    System.err.println("Failed - Test: " + i + ", time: " + (endTime - startTime) + "ms, memoryUsed: " + (usedMemoryAfter - usedMemoryBefore) + "b");
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        if (success) {
            System.out.println("Success! " + twoSum.getClass().getSimpleName());
        } else {
            System.err.println("Failed! " + twoSum.getClass().getSimpleName());
        }
    }

    private boolean validateResponse(int[] resp, int[] expectedResult) {
        return Arrays.equals(resp, expectedResult);
    }

    private List<TestCase> getTestCases() {
        return List.of(
            // Given test cases
            new TestCase(
                    new InputArgs(new int[] {2,7,11,15}, 9),
                    new ExpectedObj(new int[] {0, 1})),
            new TestCase(
                    new InputArgs(new int[] {3, 2, 4}, 6),
                    new ExpectedObj(new int[] {1, 2})),
            new TestCase(
                    new InputArgs(new int[] {3, 3}, 6),
                    new ExpectedObj(new int[] {0, 1}))
            // Private test cases

            // Custom test cases
        );
    }

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        for(TwoSum twoSum: List.of(
//                new TwoSumSolution()
                new TwoSumPractice()
        )) {
            evaluator.test(twoSum);
        }
    }
}

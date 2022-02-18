package _000002_Add_Two_Numbers.utils;

import _000002_Add_Two_Numbers.*;
import commons.ListNode;

import java.util.List;

public class Evaluator {

    public void test(AddTwoNumbers addTwoNumbers) {
        boolean success = false;
        List<TestCase> tests = getTestCases();
        for(int i = 0;i < tests.size();i++) {
            try {
                System.out.println("Running test: " + i);
                Runtime runtime = Runtime.getRuntime();
                System.gc();
                long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
                long startTime = System.currentTimeMillis();
                var resp = addTwoNumbers.addTwoNumbers(tests.get(i).getInputArgs().getL1(), tests.get(i).getInputArgs().getL2());
                long endTime = System.currentTimeMillis();
                System.gc();
                long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
                if (validateResponse(resp, tests.get(i).getExpectedObj().getExpectedResult())) {
                    success = true;
                    System.out.println("Success - Test: " + i + ", time: " + (endTime - startTime) + "ms, memoryUsed: " + (usedMemoryAfter - usedMemoryBefore) + "b");
                } else {
//                    System.out.println(Arrays.toString(resp));
                    System.err.println("Failed - Test: " + i + ", time: " + (endTime - startTime) + "ms, memoryUsed: " + (usedMemoryAfter - usedMemoryBefore) + "b");
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        if (success) {
            System.out.println("Success! " + addTwoNumbers.getClass().getSimpleName());
        } else {
            System.err.println("Failed! " + addTwoNumbers.getClass().getSimpleName());
        }
    }

    private boolean validateResponse(ListNode resp, ListNode expectedResult) {
        while (resp!= null && expectedResult != null) {
            if (resp.val != expectedResult.val) {
                return false;
            }
            resp = resp.next;
            expectedResult = expectedResult.next;
        }
        if (resp != null || expectedResult != null) { // This will check if there are any listNode which are longer than the other
            return false;
        }
        return true;
    }

    private List<TestCase> getTestCases() {
    return List.of(
        // Given test cases
        new TestCase(
            new InputArgs(new ListNode(List.of(2, 4, 3)), new ListNode(List.of(5, 6, 4))),
            new ExpectedObj(new ListNode(List.of(7, 0, 8)))),
        new TestCase(
            new InputArgs(new ListNode(List.of(0)), new ListNode(List.of(0))),
            new ExpectedObj(new ListNode(List.of(0)))),
        new TestCase(
            new InputArgs(
                new ListNode(List.of(9, 9, 9, 9, 9, 9, 9)), new ListNode(List.of(9, 9, 9, 9))),
            new ExpectedObj(new ListNode(List.of(8, 9, 9, 9, 0, 0, 0, 1)))),
        // Private test cases

        // Custom test cases
        new TestCase(
            new InputArgs(new ListNode(List.of(1, 2, 3)), new ListNode(List.of(4, 5, 6))),
            new ExpectedObj(new ListNode(List.of(5, 7, 9)))));
    }

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        for(AddTwoNumbers addTwoNumbers: List.of(
//                new AddTwoNumbersSolution()
                new AddTwoNumbersPractice()
        )) {
            evaluator.test(addTwoNumbers);
        }
    }
}

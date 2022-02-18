package _000001_Two_Sum.utils;

public class InputArgs {

    public int[] nums;
    public int target;

    public InputArgs(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] getNums() {
        return nums;
    }

    public int getTarget() {
        return target;
    }
}

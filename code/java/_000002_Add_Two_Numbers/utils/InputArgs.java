package _000002_Add_Two_Numbers.utils;

import commons.ListNode;

public class InputArgs {

    public ListNode l1;
    public ListNode l2;

    public InputArgs(ListNode l1, ListNode l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public ListNode getL1() {
        return l1;
    }

    public ListNode getL2() {
        return l2;
    }
}

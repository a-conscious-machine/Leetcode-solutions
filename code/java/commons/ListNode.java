package commons;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(List<Integer> values) {
        if (values.size() > 0) {
            ListNode _listNode = new ListNode(values.get(0), null);
            for (int i = 1; i < values.size(); i++) {
                ListNode _listNode_next = new ListNode(values.get(i));
                _listNode.next = _listNode_next;
                _listNode = _listNode.next;
            }
        }
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    public void print() {
//        ListNode t = this;
//
//    }
}

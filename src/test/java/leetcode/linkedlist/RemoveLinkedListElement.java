package leetcode.linkedlist;

import org.junit.Test;

public class RemoveLinkedListElement {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public ListNode removeElements(ListNode head, int val) {
//        ListNode temp = head;
//        while (temp != null) {
//            if (temp.val == val) {
//                head = temp.next;
//                temp = head;
//                continue;
//            } else if (temp.next != null && temp.next.val == val) {
//                temp.next = temp.next.next;
//                continue;
//            }
//            temp = temp.next;
//        }
//        return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.next == null && head.val == val){
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);

        head.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

    }
}

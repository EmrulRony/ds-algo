package leetcode.linkedlist;

import org.junit.Test;

public class ReverseALinkedList {
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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

        ListNode _head = reverseList(head);
        ListNode tempNode = _head;
        while (tempNode != null){
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }

    }
}

package leetcode.linkedlist;

import org.junit.Test;

import java.util.List;

public class MiddleOfTheLinkedList {
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
    public ListNode middleNode(ListNode head) { // false answer, find it in leetcode
        if (head == null) return null;
        else if (head.next == null) return head;
        else if (head.next.next == null) return head.next;
        int size = 0;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null){
            slow = slow.next;
            size++;
            if (fast.next == null || fast.next.next == null){
                fast = null;
            } else {
                fast = fast.next.next;
            }
        }

        if (size%2 > 0){
            return slow;
        } else {
            return slow.next;
        }
    }


    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);
        ListNode node_5 = new ListNode(6);

        head.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

        ListNode _head = middleNode(head);
        ListNode tempNode = _head;
        while (tempNode != null){
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }

    }
}

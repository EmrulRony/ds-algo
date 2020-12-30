package leetcode.linkedlist;

import org.junit.Test;

import java.util.List;

public class PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return  true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseLinkedList(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

        System.out.println(isPalindrome(head));

//        ListNode _head = middleNode(head);
//        ListNode tempNode = _head;
//        while (tempNode != null){
//            System.out.println(tempNode.val);
//            tempNode = tempNode.next;
//        }

    }
}

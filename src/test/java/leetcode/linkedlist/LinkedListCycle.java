package leetcode.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode tempNode = head;
        Set<ListNode> set = new HashSet<>();
        while (tempNode != null){
            if (!set.contains(tempNode)){
                set.add(tempNode);
                tempNode = tempNode.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleUsingTwoPointer(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        ListNode headNode = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        headNode.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(headNode));
        System.out.println(hasCycleUsingTwoPointer(headNode));

//        ListNode tempNode = headNode;
//        int itrCount = 0;
//        while (tempNode != null && itrCount <10){
//            System.out.println(tempNode.val);
//            tempNode = tempNode.next;
//            itrCount++;
//        }
    }
}

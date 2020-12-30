package leetcode.linkedlist;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
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

    // using two pointer
    //
    public ListNode getIntersectionNodeTwoPointer(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        ListNode tailA = null;
        ListNode tailB = null;
        ListNode lastNodeA = null;
        ListNode lastNodeB = null;
        while (p1 != p2){
            if (lastNodeA != null & lastNodeB !=null){
                if (lastNodeA != lastNodeB) {
                    return null;
                }
            }
            tailA = p1;
            p1 = p1.next;
            tailB = p2;
            p2 = p2.next;

            if (p1 == null){
                lastNodeA = tailA;
                p1 = headB;
            }
            if (p2 == null){
                lastNodeB = tailB;
                p2 = headA;
            }


        }
        return p1;
    }

    // time complexity O(n) , space complexity O(n)
    // using hash table
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        Set<ListNode> hashSet = new HashSet<>();
        while (tempA != null) {
            hashSet.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (hashSet.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode headA = new ListNode(4);
        ListNode nodeA_1 = new ListNode(1);
        headA.next = nodeA_1;

        ListNode headB = new ListNode(5);
        ListNode nodeB_1 = new ListNode(6);
        ListNode nodeB_2 = new ListNode(1);
        headB.next = nodeB_1;
        nodeB_1.next = nodeB_2;

        ListNode common_1 = new ListNode(8);
        ListNode common_2 = new ListNode(4);
        ListNode common_3 = new ListNode(5);
        common_1.next = common_2;
        common_2.next = common_3;

        nodeA_1.next = common_1;
        nodeB_2.next = common_1;

        ListNode resultNode = getIntersectionNode(headA, headB);
        ListNode resultNodeTwoPointer = getIntersectionNodeTwoPointer(headA, headB);
        System.out.println("Intersected node ---> " + resultNode.val);
        System.out.println("Intersected node two pointer ---> "+resultNodeTwoPointer.val);

    }
}
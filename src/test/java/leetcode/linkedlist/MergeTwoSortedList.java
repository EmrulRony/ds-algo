package leetcode.linkedlist;



public class MergeTwoSortedList {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(); // Head of newly merged list
        ListNode newTail = new ListNode();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        if (l1 == null && l2 == null){
            return null;
        } else if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        }
        if (curr1.val <= curr2.val){
            newHead = l1;
            newTail = l1;
            curr1 = curr1.next;
        } else {
            newHead = l2;
            newTail = l2;
            curr2 = curr2.next;
        }
        while (curr1 != null && curr2 !=null){
            if(curr1.val <= curr2.val){
                newTail.next = curr1;
                newTail = curr1;
                curr1 = curr1.next;
            } else {
                newTail.next = curr2;
                newTail = curr2;
                curr2 = curr2.next;
            }
        }
        if (curr1 != null){
            newTail.next = curr1;
        } else if (curr2 != null){
            newTail.next = curr2;
        }

        return newHead;
    }


    public static void main(String[] args) {
        ListNode l1  = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2  = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = mergeTwoLists(l1, l2);


        ListNode tempNode = mergedList;
        while (tempNode != null){
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }
}

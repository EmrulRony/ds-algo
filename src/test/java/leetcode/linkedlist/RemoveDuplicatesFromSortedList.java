package leetcode.linkedlist;


public class RemoveDuplicatesFromSortedList {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head  = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode listNode = deleteDuplicates(head);

        ListNode tempNode = listNode;
        while (tempNode != null){
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }

}

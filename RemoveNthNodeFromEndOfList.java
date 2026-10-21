/*
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1] */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode RemoveNthNode(ListNode head, int n){
        // dummy sits before head, so deleting the head needs no special case
        ListNode dummy = new ListNode(0, head);
        // both pointers start at dummy (not head)
        ListNode slow = dummy;
        ListNode fast = dummy;
        // move fast n+1 steps ahead to create a gap of n+1 between fast and slow
        for(int i=0;i<n+1;i++){
            fast = fast.next;
        }
         // move both one step at a time until fast falls off the end (null)
        while(fast != null){
            slow = slow.next; //slow moves one step at a time
            fast = fast.next;  // fast moves one step, so the gap stays the same
        }
        // now slow is one node BEFORE the target, so skip over the target node
        slow.next = slow.next.next;
         // dummy.next is the real head (it changes if the old head was deleted)
        return dummy.next;
    }
    //Only the above function
    static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Print a linked list like [1, 2, 3]
    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList sol = new RemoveNthNodeFromEndOfList();

        // Test 1: normal case
        ListNode head1 = buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Test 1 (n=2): ");
        printList(sol.RemoveNthNode(head1, 2));   // [1, 2, 3, 5]

        // Test 2: single node, remove the head
        ListNode head2 = buildList(new int[]{1});
        System.out.print("Test 2 (n=1): ");
        printList(sol.RemoveNthNode(head2, 1));   // []

        // Test 3: remove the head of a longer list
        ListNode head3 = buildList(new int[]{1, 2});
        System.out.print("Test 3 (n=2): ");
        printList(sol.RemoveNthNode(head3, 2));   // [2]

        // Test 4: remove the last node
        ListNode head4 = buildList(new int[]{1, 2, 3});
        System.out.print("Test 4 (n=1): ");
        printList(sol.RemoveNthNode(head4, 1));   // [1, 2]
    }
}

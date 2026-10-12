/*
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:
Input: head = []
Output: [] */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {//only the function
        ListNode curr = head;                 // start working from the first node
ListNode prev = null;                 // nothing is behind the first node yet; it will end up pointing to null

while (curr != null) {                // keep going as long as there is a node to process

    ListNode next = curr.next;        // Step 1: save the rest of the list before we break the link

    curr.next = prev;                 // Step 2: flip the arrow so this node points backward

    prev = curr;                      // Step 3: this node is done, so it becomes the "node behind"

    curr = next;                      // Step 4: move to the saved next node (not curr.next, which now points backward)
}

  return prev;                          // curr is null here, so prev (the old last node) is the new head
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                        new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));

        System.out.print("Original: ");
        for (ListNode n = head; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();

        ListNode reversed = new ReverseLinkedList().reverseList(head);

        System.out.print("Reversed: ");
        for (ListNode n = reversed; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }
}
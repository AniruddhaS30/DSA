/*
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// Using Hare And Tortoise Algorithm
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        // Loop 1: find the middle of the list.
        // fast moves 2 steps, slow moves 1 step.
        // When fast reaches the end, slow is at the middle
        // (for odd length) or the start of the second half (for even length).
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Loop 2: reverse the second half of the list in place.
        // prev builds the reversed chain, starting from null.
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;// save the next node before we break the link
            slow.next = prev;          // point the current node backwards
            prev = slow;               // move prev forward to the current node
            slow = next;               // move slow to the saved next node
        }
         // Now prev is the head of the reversed second half.

        // Loop 3: compare the first half (from head) with the reversed second half (from prev).
        // Any mismatch means it's not a palindrome.
        while(prev != null){
            if(head.val != prev.val){
                return false;   // found a mismatch, stop immediately
            }
            head = head.next;   // match so far, move to the next pair
            prev = prev.next;
        }
        return true; // Every pair matched, so it is a palindrome.
    }
    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList sol = new PalindromeLinkedList();
        System.out.println(sol.isPalindrome(head)); // true
    }
}


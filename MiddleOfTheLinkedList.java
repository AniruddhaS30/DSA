/*
Example1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
example2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one. */
public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head){
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    // Finds the middle node of a linked list.
// slow moves 1 step, fast moves 2 steps. When fast reaches the end, slow is at the middle.
// If there are two middles, this returns the second one.
    //till here is something to understand for placements others are just not very important..
    public static void main(String[] args){
        ListNode head = makeList(1,2,3,4,5,6);
        ListNode mid = middleNode(head);
        while(mid!=null){
            System.out.print(mid.val + " ");
            mid=mid.next;
        }
    }

    // added: builds a linked list from the given values and returns the head
    static ListNode makeList(int... vals){
        if(vals.length==0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode last = head;
        for(int i=1;i<vals.length;i++){
            last.next = new ListNode(vals[i]);
            last = last.next;
        }
        return head;
    }
}

// added: LeetCode gives you this class, in VS Code you write it yourself
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
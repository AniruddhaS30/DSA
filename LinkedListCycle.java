/*
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */ //Here pos tells from last node till which node is the arrow extended
import java.util.HashSet;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> set = new HashSet<>();//Do not allow duplicates
        ListNode curr = head; // Pointer to the head
        while(curr != null){// as we dont know how many iterations , so we use while loop instead of for
            if(set.contains(curr)){
                return true;
            }
            else{
                set.add(curr);
                curr = curr.next;
            }

        }
        return false;//if loop ends with no cycle in the linked list then return false

    }
public static void main(String[] args) {
        int[] head = {3, 2, 0, -4};
        int pos = 1;

        System.out.println(new LinkedListCycle().hasCycle(build(head, pos)));
    }

    // Builds the list from the array, like LeetCode does behind the scenes
    static ListNode build(int[] vals, int pos) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode cycleTarget = null;
        for (int i = 0; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
            if (i == pos) cycleTarget = tail;
        }
        if (pos >= 0) tail.next = cycleTarget;
        return dummy.next;
    }    
}

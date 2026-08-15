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
class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode ptr = head.next;
            head.next = prev;
            prev = head;
            head = ptr;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //slow in middle 
        if(fast!=null){
            slow = slow.next;
        }

        //half part reverse 
        slow = reverse(slow);
        fast = head;

        while(fast!=null && slow!=null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
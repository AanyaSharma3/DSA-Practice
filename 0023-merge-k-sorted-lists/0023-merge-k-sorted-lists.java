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
    public ListNode mergeLL(ListNode h1 , ListNode h2){
        ListNode p , dumy = new ListNode(0);
        p = dumy;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = (h1==null) ? h2:h1;
        return dumy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        for(int i=1; i<lists.length; i++){
            lists[0] = mergeLL(lists[0],lists[i]);
        }
        return lists[0];
    }
}
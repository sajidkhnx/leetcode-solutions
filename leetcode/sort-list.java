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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        } 
        ListNode mid = getmid(head);
        ListNode righthead =  mid.next;
        mid.next = null;
        ListNode lefthalf = sortList(head);
        ListNode righthalf = sortList(righthead);
        return merge(lefthalf,righthalf);
    }
    private ListNode getmid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge (ListNode left, ListNode right){
        ListNode mergeLL = new ListNode(-1);
        ListNode temp = mergeLL;
        while (left!= null && right!=null){
            if(left.val <= right.val){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while(left!=null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while(right!=null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }
}
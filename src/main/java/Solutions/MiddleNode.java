package Solutions;

import DataStructure.ListNode;

public class MiddleNode {

    public ListNode middleNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null){
            slow = slow.next;
            if (fast.next.next == null){
                return slow;
            }
            fast = fast.next.next;
        }
        return slow.next;
    }

}

package Solutions;


import DataStructure.ListNode;

public class HasCycleList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);

        slow.next = head;
        fast.next = head;

        if (head.next == null){
            return false;
        }

        slow.next = slow.next.next;

        while (slow.next != null && fast.next.next != null){
            fast.next = fast.next.next.next;
            if (fast.next == null){
                return false;
            }else if (slow.next == fast.next){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = head;

        HasCycleList hasCycleList = new HasCycleList();
        hasCycleList.hasCycle(head);
    }
}

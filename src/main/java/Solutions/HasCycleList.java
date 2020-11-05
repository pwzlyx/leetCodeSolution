package Solutions;


import DataStructure.ListNode;

public class HasCycleList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);

        slow.next = head;
        fast.next = head;

        if (head == null && head.next == null){
            return false;
        }


        while (slow.next.next != null && fast.next.next != null){
            fast.next = fast.next.next.next;
            slow.next = slow.next.next;
            if (fast.next == null){
                return false;
            }else if (slow.next == fast.next){
                return true;
            }
        }
        return false;
    }

    public ListNode hasCycle2(ListNode head){
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);

        slow.next = head;
        fast.next = head;

        if (head == null || head.next == null){
            return null;
        }


        while (slow.next.next != null && fast.next.next != null){
            fast.next = fast.next.next.next;
            slow.next = slow.next.next;
            if (fast.next == null){
                return null;
            }else if (slow.next == fast.next){
                ListNode listNode = new ListNode(0);
                listNode.next = head;
                while (listNode.next != slow.next){
                    listNode.next = listNode.next.next;
                    slow.next = slow.next.next;
                }
                return slow.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = head;

        HasCycleList hasCycleList = new HasCycleList();
        hasCycleList.hasCycle(head);
    }
}

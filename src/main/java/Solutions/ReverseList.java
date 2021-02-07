package Solutions;

import DataStructure.ListNode;

import java.util.List;

/**
 * 206.反转链表 92.反转链表 II
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseListRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseListRecursion(head);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseBetween(ListNode head, int m,int n){
        ListNode start = head;
        if (m==n){
            return head;
        }
        ListNode pre = null;
        for (int i =1; i < m;i++){
            pre = start;
            start = start.next;
        }
        ListNode startTemp = start;
        ListNode newHead = null;
        ListNode nextEnd = null;
        for (int i=m;i<=n;i++){
            if (i==n){
                nextEnd = start.next;
            }
            ListNode next = start.next;
            start.next = newHead;
            newHead = start;
            start = next;
        }
        if (pre !=null){
            pre.next = newHead;
        }
        startTemp.next = nextEnd;
        if (m ==1){
            return newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseList reverseList = new ReverseList();
        reverseList.reverseBetween(head, 1,2);
    }
}

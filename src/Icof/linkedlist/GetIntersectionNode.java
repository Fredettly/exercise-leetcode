package Icof.linkedlist;

import java.util.Objects;

/**
 * Created by xwx_ on 2020/7/3
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (!Objects.equals(node1, node2)) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

    public static void main(String[] args) {
        GetIntersectionNode solution = new GetIntersectionNode();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(6);
        headB.next = new ListNode(3);
        headB.next.next = new ListNode(4);
        headB.next.next.next = new ListNode(5);
        ListNode res = solution.getIntersectionNode(headA, headB);
        System.out.println(res.toString());
    }
}

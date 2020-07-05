package Icof.linkedlist;
/**
 * Created by xwx_ on 2020/7/2
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ReverseList solution = new ReverseList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode res = solution.reverseList(node);
        System.out.println(res.toString());
    }
}

package draft;

/**
 * Created by xwx_ on 2020/5/4
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append("->");
            }
            head = head.next;
        }
        return sb.toString();
    }
}

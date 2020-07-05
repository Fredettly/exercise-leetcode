package Icof.linkedlist;

import java.util.Objects;

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
				sb.append("-->");
			}
			head = head.next;
		}
		return sb.toString();
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(val, next);
    }
}
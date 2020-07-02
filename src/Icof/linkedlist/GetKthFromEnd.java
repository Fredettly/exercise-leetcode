package linkedlist;

public class GetKthFromEnd {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode front = head;
		ListNode behind = head;
		while (front != null && k > 0) {
			front = front.next;
			k --;
		}
		while (front != null) {
			front = front.next;
			behind = behind.next;
		}
		return behind;
	}
	public static void main(String[] args) {
		GetKthFromEnd solution = new GetKthFromEnd();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		int k = 2;
		ListNode res = solution.getKthFromEnd(node, k);
		System.out.println(res.toString());
	}
}
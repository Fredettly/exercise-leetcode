package linkedlist;

public class DeleteNode {

	public ListNode deleteNode(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node = dummy;
		while (node.next != null) {
			if (node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		DeleteNode solution = new DeleteNode();
		ListNode head = new ListNode(4);
		head.next = new ListNode(5); 
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		int val = 1;
		ListNode res = solution.deleteNode(head, val);
		System.out.println(res.toString());
	}
}
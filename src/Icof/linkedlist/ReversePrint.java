package linkedlist;

import java.util.Arrays;
public class ReversePrint {

	public int[] reversePrint(ListNode head) {
		ListNode node = head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		int[] num = new int[count];
		node = head;
		for (int i = count - 1; i >= 0; i--) {
			num[i] = node.val;
			node = node.next;
		}
		return num;
	}

	public static void main(String[] args) {
		ReversePrint solution = new ReversePrint();
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		int[] res = solution.reversePrint(head);
		System.out.println(Arrays.toString(res));
	}
}
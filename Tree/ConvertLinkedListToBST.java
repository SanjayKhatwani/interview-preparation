//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
	}
}
 
// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
}
 
public class Solution {
	ListNode head;
 
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		this.head = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
 
		TreeNode leftNode = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode rightNode = sortedListToBST(mid + 1, end);
 
		root.left = leftNode;
		root.right = rightNode;
 
		return root;
	}
}
public class Solution {
	public ListNode plusOne(ListNode head) {
		if (head == null) return head;

		head = reverse(head);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy.next;
		int carry = 1;
		while (p != null) {
			int sum = p.val + carry;
			p.val = sum % 10;
			carry = sum / 10;
			p = p.next;
		}
		if (carry > 0) {
			p = new ListNode(carry);
		}
		return reverse(dummy.next);
	}

	private void reverse(ListNode node) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}

// better solution, without reversing
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        }
        
        return dummy;
    }
}

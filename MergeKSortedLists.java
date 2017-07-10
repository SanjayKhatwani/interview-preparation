public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                heap.add(node);
        }
        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null) 
                heap.add(curr.next);
        }
        return dummy.next;
    }

}


// Divid and conque, better time complexity
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) 
            return lists[start];
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partion(lists, s, mid);
            ListNode l2 = partion(lists, mid + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }
}
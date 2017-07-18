public class Solution {
    
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    public int getRandom() {
        int count = 0;
        ListNode p = head;
        int res = 0;
        while (p != null) {
            count++;
            if (rand.nextInt(count) == 0) 
                res = p.val;
            p = p.next;
        }
        return res;
    }
}
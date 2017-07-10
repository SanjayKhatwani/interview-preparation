class Node {
    int data;
    Node next, prev;
 
    Node(int d) {
        data = d;
        next = prev = null;
    }
}
 
public class Solution {
    Node head;

    Node sortedListToBST(Node head) {
        this.head = head;
        int n = countNodes(head);
        return sortedListToBSTRecur(n);
    }
 
    Node sortedListToBSTRecur(int n) {
        if (n <= 0) return null;
        
        Node leftNode = sortedListToBSTRecur(n / 2);
        Node root = head;
        root.prev = leftNode;
        head = head.next;
        root.next = sortedListToBSTRecur(n - n / 2 - 1);
 
        return root;
    }
 
    int countNodes(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
 
}
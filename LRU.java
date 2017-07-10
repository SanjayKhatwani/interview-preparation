//实现起来比较简单. 维护一个链表,每次数据新添加或者有访问时移动到链表尾,
//每次淘汰数据则是淘汰链表头部的数据.
//也就是最近最少访问的数据在链表头部,最近刚访问的数据在链表尾部    

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (! map.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        moveToTail(current);
        return map.get(key).value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }
        // key doesn't exist in cache and cache reached max size
        if (map.size() == capacity) {
            map.remove(head.next.key); // remove 的同时要link head 和 next
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node current) {
        // insert between tail and tail.prev
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
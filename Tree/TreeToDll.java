private class Node {
    int value;
    Node left;
    Node right;
}
 
private Node concatenate(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;
 
    Node aEnd = a.left;
    Node bEnd = b.left;
 
    a.left = bEnd;
    bEnd.right = a;
    aEnd.right = b;
    b.left = aEnd;
    return a;
}
 
public Node treeToList(Node n) {
    if (n == null) return n;
    Node leftList = treeToList(n.left);
    Node rightList = treeToList(n.right);
    n.left = n;
    n.right = n;
 
    n = concatenate(leftList, n);
    n = concatenate(n, rightList);
    return n;
}
/*
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
*/

public class Solution {
    public String expressionExpand(String s) {
        // Write your code here
        Deque<Object> deque = new LinkedList<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                deque.push(num);
                num = 0;
            } else if (c == ']') {
                popStack(deque);
            } else {
                deque.push(c);
            }
        }
        popStack(deque);
        return deque.isEmpty() ? "" : deque.pop().toString();
    }
    
    private void popStack(Deque<Object> deque) {
        StringBuilder toAdd = new StringBuilder();
        StringBuilder unit = new StringBuilder();
        while (!deque.isEmpty() && (deque.peek() instanceof Integer == false)) {
            unit.insert(0, deque.pop());
        }
        int count = deque.isEmpty() ? 1 : (Integer)(deque.pop());
        if (count > 0) {
            for (int i = 0; i < count; i++) toAdd.append(unit);
            deque.push(toAdd.toString());
        }
    }
}
/*
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
*/

public class ExpressionExpand {
	public String expressionExpand(String s) {
        // Write your code here
        Deque<Object> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        
        int num = 0;
        for (char c : arr){
           if (Character.isDigit(c)) {
               num = num * 10 + c - '0';
           } else if (c == '[') {
               stack.push(Integer.valueOf(num));
               num = 0;
           } else if (c == ']') {
               popStack(stack);
           } else {
               stack.push(c);
           }
        }
        popStack(stack);
        return stack.pop().toString();
    }

    private void popStack(Deque<Object> stack) {
        StringBuilder add = new StringBuilder();
        StringBuilder unit = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() instanceof Integer == false) {
            unit.insert(0, stack.pop());
        }
        int count = stack.isEmpty() ? 1 : (Integer) stack.pop();
        if (count > 0) {
            for (int i = 0; i < count; i++)
                add.append(unit);
            stack.push(add);// reput
        }
    }
}
public class Solution {

    public String decodeString(String s) {

        Deque<Integer> countStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        strStack.push("");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) i++;
                countStack.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (c == '[') {
                strStack.push("");
            } else if (c == ']') {
                String str = strStack.pop();
                StringBuilder sb = new StringBuilder();
                int times = countStack.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                strStack.push(strStack.pop() + sb.toString());
            } else {
                strStack.push(strStack.pop() + c);
            }
        }
        return strStack.pop();
    }

}
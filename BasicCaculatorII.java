public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] chs = s.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        int num = 0;
        char operator = '+';
        for (int i = 0; i < len; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = num * 10 + chs[i] - '0';
            } 
            if ((!(chs[i] >= '0' && chs[i] <= '9') && chs[i] != ' ') || i == len - 1) {  // 易错点
                switch (operator) {
                    case '+' :
                        deque.push(num);
                        break;
                    case '-' :
                        deque.push(-num);
                        break;
                    case '*' :
                        deque.push(deque.pop() * num);
                        break;
                    case '/' :
                        deque.push(deque.pop() / num);
                        break;
                }
                operator = chs[i];
                num = 0;
            }
        }
        int res = num;
        for (int number : deque) res += number;
        return res;
    }
}
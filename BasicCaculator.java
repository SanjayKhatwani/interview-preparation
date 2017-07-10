public class Solution {

	public static int calculate(String s) {
		int len = s.length();
		int sign = 1;
		int result = 0;
		
		char[] chars = s.toCharArray();
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			if (chars[i] == '+') {
				sign = 1;
			} else if (chars[i] == '-') {
				sign = -1;
			} else if (Character.isDigit(chars[i])) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(chars[i + 1])) {
					sum = sum * 10 + (chars[i + 1] - '0');
					i++;
				}
				result += sum * sign;
			} else if (chars[i] == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (chars[i] == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}

		return result;
	}

}
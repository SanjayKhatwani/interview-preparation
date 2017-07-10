public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] prod = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = p + prod[i + j + 1];
                prod[i + j + 1] = sum % 10;
                prod[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < m + n && prod[start] == 0) 
            start++;
        for (int i = start; i < m + n; i++)
            sb.append(prod[i]);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
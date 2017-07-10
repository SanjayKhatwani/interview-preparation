public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        int i = cha.length - 1, j = chb.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += cha[i--] - '0';
            if (j >= 0) sum += chb[j--] - '0';
            res.append(sum & 1);
            carry = sum >> 1;
        }
        if (carry > 0) 
            res.append(carry);
        return res.reverse().toString();
    }
}
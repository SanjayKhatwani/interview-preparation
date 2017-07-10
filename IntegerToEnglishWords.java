public class Solution {
    
    private static String[] lessThanTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] larges = new String[] {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        int i = 0;
        StringBuilder words = new StringBuilder();
        
        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, helper(num % 1000) + larges[i] + " ");
            }
            num /= 1000;
            i++;
        }
        
        return words.toString().trim();
    }
    
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return lessThanTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return lessThanTwenty[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
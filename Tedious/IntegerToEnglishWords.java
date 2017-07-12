public class Solution {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder builder = new StringBuilder();
        int level = 0;
        while (num > 0) {
            builder.insert(0, getLessThan1000(num % 1000) + THOUSANDS[level++] + " ");
            num /= 1000;
        }
        return builder.toString().trim();
    }
    
    private String getLessThan1000(int num) {
        if (num < 20) return LESS_THAN_20[num] + " ";
        else if (num < 100) {
            return TENS[num / 10] + " " + getLessThan1000(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + getLessThan1000(num % 100);
        }
    }
}
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int head = 0;
        int tail = chars.length -1;
        while (head < tail) {
            while (head < tail && isLowercase(chars[head])) head++;
            while (head < tail && !isLowercase(chars[tail])) tail--;
            if (head < tail) {
                char tmp = chars[head];
                chars[head] = chars[tail];
                chars[tail] = tmp;
                head++;
                tail--;
            }
        }
    }
    
    private boolean isLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }
}

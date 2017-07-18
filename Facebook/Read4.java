public class Solution extends Reader4 {

    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int total = 0;
        boolean eof = false;
        while (!eof && total < n) {
            int count = read4(tmp);
            if (count < 4) eof = true;
            count = Math.min(count, n - total);
            for (int i = 0; i < count; i++)
                buf[total++] = tmp[i];
        }
        return total;
    }
    
}
/*
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
*/

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while (start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if (a >= 0) {
                if (startNum >= endNum) {
                    res[i--] = startNum;
                    start++;
                } else {
                    res[i--] = endNum;
                    end--;
                }
            } else {
                if (startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                } else {
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }
    public int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
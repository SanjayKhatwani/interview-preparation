public class Solution {
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {   
        List<String> result = new ArrayList<>(); 
        for (int i = 0; i <= nums.length; i++) {
            int start = (i == 0) ? lower : nums[i - 1] + 1;
            int end = (i == nums.length) ? upper : nums[i] - 1;
            if (start <= end)
                addMissing(result, start, end);
        } 
        return result;
    }
    
    private void addMissing(List<String> result, int start, int end) {     
        if (start == end) result.add(start + "");
        else result.add(start + "->" + end);
    }

}
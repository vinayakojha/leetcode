class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;

        // Single pass to find the indices of the minimum and maximum elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        // Establish relative order of the two indices
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // Strategy 1: Delete both from the front
        int opt1 = right + 1;
        
        // Strategy 2: Delete both from the back
        int opt2 = n - left;
        
        // Strategy 3: Delete left from front and right from back
        int opt3 = (left + 1) + (n - right);

        // Return the minimum of the three strategies
        return Math.min(opt1, Math.min(opt2, opt3));
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int start = 0 , end = n - 1;
        for(int i = n - 1 ; i >= 0 ; i--)
        {
           if(nums[start] * nums[start] >= nums[end] * nums[end]) 
           {
                ans[i] = nums[start] * nums[start];
                start += 1;
           }
           else
           {
                ans[i] = nums[end] * nums[end];
                end -= 1;
           }
        } 
        return ans;
    }
}
// TC : O(N)
// SC : O(1)

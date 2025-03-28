class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j  = height.length - 1;
        int maxWaterStored = 0;
        while(i < j)
        {
           int currWaterStored = (j - i) * Math.min(height[i] , height[j]);
           maxWaterStored = Math.max(currWaterStored , maxWaterStored);
           if(height[i] <= height[j])
           i += 1;
           else
           j -= 1;  
        }
        return maxWaterStored;
    }
}
// TC : O(N)
// SC : O(1)

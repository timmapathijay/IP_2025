class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int subarrayCount = 0;
        int prevValidCount = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > right){
                j = i + 1;
                prevValidCount = 0;
            }
            else if(nums[i] < left){
                subarrayCount += prevValidCount;
            }
            else{
                subarrayCount += i - j  + 1;
                prevValidCount = i - j + 1;
            }
        }
        return subarrayCount;
    }
}
// TC : O(N)
// SC : O(1)

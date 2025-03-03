class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = nums[n - 1];

        for(int i = n - 2 ; i >= 0 ; i--) 
        ans[i] = nums[i] * ans[i + 1];

        int prefixProduct = 1;
        for(int i = 0 ; i < n - 1; i++)
        {
           ans[i] = prefixProduct *  ans[i + 1];
           prefixProduct *= nums[i];     
        }
        ans[n - 1] = prefixProduct;
        return ans;
        
    }
}
// TC : N [To compute suffix product] + N [To compute ans & prefix product] => O(2N)
// SC : O(1)

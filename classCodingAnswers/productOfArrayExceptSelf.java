class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int n = nums.length;
        int carry = 1;
        for(int i=0; i<n; i++){
            left[i] = carry;
            carry = carry*nums[i];
        }

        carry=1;

        for(int i=n-1; i>=0; i--){
            left[i] = carry*left[i];
            carry = carry*nums[i];
        }

        return left;
    }
}

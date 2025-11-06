class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int n = nums[0];
        int max=1;
        int len = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == n+1){
                n++;
                len++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                n = nums[i];
                len=1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}

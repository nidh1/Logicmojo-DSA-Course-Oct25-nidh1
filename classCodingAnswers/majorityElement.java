class Solution {
    public int majorityElement(int[] nums) {
        int seat=nums[0];
        int count=0;

        for(int i=1; i<nums.length; i++){
            if(nums[i]==seat){
                count++;
            }else if(count>0){
                count--;
            }else{
                seat=nums[i];
            }
        }

        count=0;
        for(int n: nums){
            if(n==seat){
                count++;
            }
        }

        if(count > nums.length/2){
            return seat;
        }

        return -1;
    }
}

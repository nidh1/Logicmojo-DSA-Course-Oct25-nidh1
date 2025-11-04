class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int k=nums.length-1;
            int j=i+1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(nums[k]);
                    j++;
                    k--;
                    ans.add(lst);
                    while(j<k && nums[j-1]==nums[j]) j++;
                    while (j<k && nums[k+1]==nums[k]) k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                    }

                    
            }
            

        }

        return ans;
    }
}

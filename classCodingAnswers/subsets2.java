class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> trol = new ArrayList<>();
        trol.add(new ArrayList<>());
        helper(nums, new ArrayList<>(), trol, 0);
        return trol;
    }

    public void helper(int[] nums, List<Integer> bag, List<List<Integer>> trol, int index){
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            bag.add(nums[i]);
            trol.add(new ArrayList<>(bag));
            helper(nums, bag, trol, i+1);
            bag.remove(bag.size()-1);
        }
    }
}

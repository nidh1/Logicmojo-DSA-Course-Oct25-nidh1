class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, nums.length, ans, new ArrayList<>());
        return ans;

    }

    public void helper(int[] nums, int i, int n, 
    List<List<Integer>> ans, List<Integer> a) {
        //your code goes here
        if(i==n){
            ans.add(new ArrayList<>(a));
            return;
        }
        a.add(nums[i]);
        helper(nums, i+1, n, ans, a);
        a.remove(a.size()-1);
        helper(nums, i+1, n, ans, a);
        
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 0, candidates, target, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> bag, int i, int[] candidates, int target, int sum){
        if(i==candidates.length){
            if(sum==target){
                ans.add(new ArrayList<>(bag));
            }
            return;
        }

        if(sum==target){
            ans.add(new ArrayList<>(bag));
            return;
        }

        if(sum>target){
            return;
        }
        
        bag.add(candidates[i]);
        helper(ans, bag, i, candidates, target, sum+candidates[i]);
        bag.remove(bag.size()-1);
        helper(ans, bag, i+1, candidates, target, sum);
    }
}

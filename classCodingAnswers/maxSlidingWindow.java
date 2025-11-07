class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        
        int[] ans = new int[n-k+1];
        for(int i=0; i<k; i++){
            while(!q.isEmpty() && nums[i]>q.peekLast()){
                q.pollLast();
            }
            q.offerLast(nums[i]);
        }

        ans[0] = q.peekFirst();
        int id=1;

        for(int i=k; i<nums.length; i++){
            if(nums[i-k] == q.peekFirst()){
                q.pollFirst();
            }

            while(!q.isEmpty() && q.peekLast()<nums[i]){
                q.pollLast();
            }
            
            q.offerLast(nums[i]);
            ans[id++]=q.peekFirst();
        }

        return ans;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i], mp.get(nums[i])+1);
            }else{
                mp.put(nums[i], 1);
            }
        }

        List<Integer>[] flipped = new ArrayList[nums.length+1];
        for(int i=0; i<=nums.length; i++){
            flipped[i] = new ArrayList<>();
        }

        for(int i: mp.keySet()){
            flipped[mp.get(i)].add(i);
        }


        int[] res = new int[k];
        int j=0;

        for(int i=nums.length; i>0; i--){
            if(flipped[i].isEmpty()){
                continue;
            }
            for(int a: flipped[i]){
                res[j] = a;
                j++;
                if(j==k){
                    return res;
                }
            }
        }

        return res;
    }
}

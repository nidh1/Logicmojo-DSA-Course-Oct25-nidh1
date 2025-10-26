class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] bucket = new int[26];
        Map<String, List<String>> mp = new HashMap<>();

        for(String str: strs){

            for(int i=0; i<26; i++){
               bucket[i]=0;
             }

            for(char c: str.toCharArray()){
                bucket[c - 'a']++;
            }

            String leaderKey = "";

            for(int i=0; i<26; i++){
                leaderKey = leaderKey + ',' + bucket[i];
            }

            if(mp.containsKey(leaderKey)){
                mp.get(leaderKey).add(str);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                mp.put(leaderKey, temp);
            }
        }

        return new ArrayList <> (mp.values());
    }
}

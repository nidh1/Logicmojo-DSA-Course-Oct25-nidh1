class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();

        for(Character ch: t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int r=0;
        int l=0;
        int required = t.length();
        int start=0;
        int min=Integer.MAX_VALUE;
        while(r < s.length()){
            Character ch = s.charAt(r);
            if(mp.containsKey(ch)){
                if(mp.get(ch) > 0){
                    required--;
                }
                mp.put(ch, mp.get(ch)-1);
                
            }

            while(required==0){
                if(min > r-l+1){
                    min = r-l+1;
                    start = l;
                }

                char deleted = s.charAt(l);
                if(mp.containsKey(deleted)){
                    mp.put(deleted, mp.get(deleted)+1);
                    if(mp.get(deleted) > 0){
                        required++;
                    }
                }
                l++;
              }
              r++;
            }

            return min!=Integer.MAX_VALUE?s.substring(start, start+min):"";
    }
}

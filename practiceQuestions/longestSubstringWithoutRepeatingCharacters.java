class Solution {
    public int longestNonRepeatingSubstring(String s) {
        //your code goes here
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        int max=0;
        int l=0;
        int r=0;
        while(r < s.length()){
            if(freq[s.charAt(r)] >= l){
                l = freq[s.charAt(r)] + 1;
            }

            max = Math.max(max, r-l+1);
            freq[s.charAt(r)] = r;
            r++;


        }
        return max;
    }
}

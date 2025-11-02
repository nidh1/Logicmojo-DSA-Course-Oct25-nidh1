class Solution {
    public boolean isSubsequence(String s, String t) {
        int sCount=0;
        int tCount=0;

        while(sCount<s.length() && tCount<t.length()){
            if(s.charAt(sCount)==t.charAt(tCount)){
                sCount++;
            }
            tCount++;
        }

        return s.length()==sCount;
    }
}

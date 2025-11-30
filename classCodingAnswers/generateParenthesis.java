class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        helper(ans, s, n, 0, 0);
        return ans;
    }

    public void helper(List<String> ans, String s, int n, int close, int open){
        if(open+close == 2*n){
            ans.add(s);
        }

        if(open < n){
            helper(ans, s+"(", n, close, open+1);
        }

        if(close < open){
            helper(ans, s+")", n, close+1, open);
        }
    }
}

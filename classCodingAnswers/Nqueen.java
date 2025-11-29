class Solution {
    public List<List<String>> solveNQueens(int n) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<n; i++){
            l.add(-1);
        }
        helper(l, 0, ans, n);
        for(List<Integer> lst: ans){
            List<String> str = new ArrayList<>();
            for(Integer i: lst){
                String[] s = new String[n];
                Arrays.fill(s, ".");
                s[i]="Q";
                str.add(String.join("", s));
            }
            res.add(str);
        }

        return res;

    }

    public void helper(List<Integer> arr, int row, List<List<Integer>> ans, int n){
        if(row == n){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int  col=0; col<n; col++){
            if(canPlace(row, col, arr, n)){
                arr.set(row, col);
                helper(arr, row+1, ans, n);
                arr.set(row, -1);
            }
        }
    }

    public boolean canPlace(int row, int col, List<Integer> arr, int n){
        if(arr.get(row) == col){
            return false;
        }

        for(int i=0; i<row; i++){
            if(arr.get(i)==col){
                return false;
            }
        }

        int temp = 1;

        for(int i=row-1; i>=0; i--){
            if(col-temp < 0){
                break;
            }
            if(arr.get(i)==col-temp){
                return false;
            }
            temp++;
        }

        temp=1;
        for(int i=row-1; i>=0; i--){
            if(col+temp >= n){
                break;
            }
            if(arr.get(i)==col+temp){
                return false;
            }
            temp++;
        }

        return true;

    }
}

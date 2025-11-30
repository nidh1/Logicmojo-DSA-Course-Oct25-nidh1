class Solution {
    public int totalNQueens(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        return helper(0, 0, arr, n);
    }

    public int helper(int row, int col, int[] arr, int n){
        if(row==n){
            return 1;
        }
        int count=0;

        for(int i=0; i<n; i++){
            if(canPlace(row, i, n, arr)){
                arr[row] = i;
                count+=helper(row+1, col, arr, n);
                arr[row] = -1;
            }
        }

        return count;

    }

    public boolean canPlace(int row, int col, int n, int[] arr){
        if(arr[row]==col) return false;

        for(int i=0; i<row; i++){
            if(arr[i]==col) return false;
        }

        int temp = 1;

        for(int i=row-1; i>=0; i--){
            if(col-temp < 0) break;
            if(arr[i]==col-temp) return false;
            temp++;
        }

        temp=1;
        for(int i=row-1; i>=0; i--){
            if(col+temp >= n) break;
            if(arr[i]==col+temp) return false;
            temp++;
        }

        return true;
    }
}

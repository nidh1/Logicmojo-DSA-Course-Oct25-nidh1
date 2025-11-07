class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack();
        int max=0;

        for(int i=0; i<=heights.length; i++){
            while(!st.isEmpty() && (i==heights.length ||  heights[st.peek()]>heights[i])){
                int height =heights[st.pop()];
                int width = 0;
                if(st.isEmpty()){
                    width=i;
                }else{
                    width = i - st.peek() - 1;
                }

                max = Math.max(max, height*width);
            }
            st.push(i);
        }

        return max;
    }
}

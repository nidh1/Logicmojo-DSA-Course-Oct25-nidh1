class MinStack {

    Stack<Long> st = new Stack();
    Long min = Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        Long v = Long.valueOf(val);
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else if(val < min){
            st.push(2*v - min);
            min = v;
        }else{
            st.push(v);
        }
    }
    
    public void pop() {
        Long top = st.pop();
        if(top < min){
            min = 2*min - top;
        }
    }
    
    public int top() {
        Long top = st.peek();
        if(top < min){
            return min.intValue();
        }else{
            return top.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

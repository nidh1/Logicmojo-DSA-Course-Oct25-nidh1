class Solution {
    public int compress(char[] chars) {
        Stack<Character> st = new Stack();
        int count=1;
        String s ="";
        for(int i=0; i<chars.length; i++){
            if(st.isEmpty() || (st.peek()!=chars[i] && count==1)){
                st.push(chars[i]);
                s+=st.peek();
            }
            else if(st.peek()==chars[i]){
                st.push(chars[i]);
                count++;
            }else if(st.peek()!=chars[i] && count>1){
                st.push(chars[i]);
                s+=count;
                count=1;
                s+=st.peek();
            }
        }

        if(count>1){
            s+=count;
        }

        System.out.print(s);

        for(int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}

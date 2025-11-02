class Solution {
    public void reverse(StringBuilder sb, int left, int right){
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, s.length()-1);

        int j=0;
        int i=0;
        int n=s.length();

        while(j < n){
            while(j<n && sb.charAt(j)==' '){
                j++;
            }

            if(j==n){
                break;
            }

            int start = i;

            while(j<n && sb.charAt(j)!=' '){
                if(i < n){
                    sb.setCharAt(i, sb.charAt(j));
                    i++;
                    j++;
                }else{
                    sb.append(sb.charAt(j));
                }
            }

            int end = i-1;

            reverse(sb, start, end);

            if(j<n){
                if(i<n){
                    sb.setCharAt(i, ' ');
                    i++;
                }
            }
        }

        return sb.substring(0,i);
    }
}

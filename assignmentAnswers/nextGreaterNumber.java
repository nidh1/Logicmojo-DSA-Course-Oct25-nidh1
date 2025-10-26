import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nge_func' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int nge_func(int n) {
    // Write your code here
        String s = String.valueOf(n);
        
        if(s.length() == 1){
            return n;
        }
        int len = s.length();
        int prev = (int) (s.charAt(len-1) - '0');
        int pos = 0;
        int smallDigit  =-1;
        for(int i=len-2; i>=0; i--){
            int cur = ((int) s.charAt(i) - '0');
            //System.out.println(cur);
            if(prev > cur){
                pos=i;
                smallDigit=cur;
                break;
            }
            prev=cur;
        }
        
        System.out.println(smallDigit);
        System.out.println(pos);
        
        if(smallDigit==-1){
            return -1;
        }
        
        int min=0;
        int pos2=0;
        int largeDigit=-1;
        
        for(int i=pos; i<len; i++){
            int num = ((int) s.charAt(i) - '0');
            if(min < num && num > smallDigit){
                pos2=i;
                largeDigit=num;
            }
        }
        
        if(largeDigit==-1){
            return -1;
        }
        
        char[] arr = s.toCharArray();
        char temp = arr[pos2];
        arr[pos2] = arr[pos];
        arr[pos] = temp;
        //s = new String(arr);
        
        int start = pos+1;
        int end = s.length()-1;
        
        
        while(start < end){
            temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        
        return Integer.valueOf(new String(arr));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.nge_func(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

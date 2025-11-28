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
     * Complete the 'getPermutation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static String getPermutation(int n, int k) {
    // Write your code here
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        
        for(int i=1; i<n; i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        
        StringBuilder sb = new StringBuilder();
        k=k-1;
        while(true){
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            
            if(nums.isEmpty()){
                break;
            }
            k = k%fact;
            fact = fact/nums.size();
        }
        
        return sb.toString();
    }
    
    public static void helper(List<Integer> nums, List<String> ans, StringBuilder sb, int i){
//         if(sb.length()==nums.size()){
//             ans.add(sb.toString());
//             //return;
//         }
        
        if(i == nums.size()){
            ans.add(sb.toString());
            return;
        }
        
        sb.append(nums.get(i));
        helper(nums, ans, sb, i+1);
        sb.deleteCharAt(sb.length()-1);
        helper(nums, ans, sb, i+1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.getPermutation(n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

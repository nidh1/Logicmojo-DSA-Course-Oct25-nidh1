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
     * Complete the 'subsetSum' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER n
     */

    public static List<Integer> subsetSum(List<Integer> nums, int n) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        helper(0, 0, ans, nums);
        Collections.sort(ans);
        return ans;

    }
    
    public static void helper(int i, int sum, List<Integer> ans, List<Integer> nums){
        if(i==nums.size()){
            ans.add(sum);
            return;
        }
        helper(i+1, sum+nums.get(i), ans, nums);
        helper(i+1, sum, ans, nums);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> subsetSumArray = Result.subsetSum(arr, n);

        bufferedWriter.write(
            subsetSumArray.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

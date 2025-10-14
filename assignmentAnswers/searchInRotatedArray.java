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
     * Complete the 'search_element' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER target
     */

    public static int search_element(List<Integer> arr, int target) {
    // Write your code here
        int high = arr.size()-1;
        int low = 0;
        while(high>=low){
            int mid = (high+low)/2;
            if(arr.get(mid) == target){
                return mid;
            }
            if(arr.get(mid) >= arr.get(low)){
                if(arr.get(low) <= target && arr.get(mid) >= target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(arr.get(mid) <= target && arr.get(high) >= target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        
        return -1;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int target = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.search_element(arr, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

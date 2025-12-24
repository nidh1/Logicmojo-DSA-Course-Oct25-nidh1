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
     * Complete the 'sort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> sort(int n, List<Integer> arr) {
    // Write your code here
        mergeSort(0, n-1, arr);
        return arr;
    }
    
    public static void mergeSort(int start, int end, List<Integer> arr){
        if(start >= end){
            return;
        }
        int mid = (int) (start + Math.floor((end-start)/2));
        mergeSort(start, mid, arr);
        mergeSort(mid+1, end, arr);
        merge(mid, start, end, arr);
    }
    
    public static void merge(int mid, int low, int high, List<Integer> arr){
        int left=low;
        int right=mid+1;
        List<Integer> ans = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr.get(left) > arr.get(right)){
                ans.add(arr.get(right));
                right++;
            }else{
                ans.add(arr.get(left));
                left++;
            }
        }
        
        
        while(left <= mid){
            ans.add(arr.get(left));
            left++;
        }
        
        while(right <= high){
            ans.add(arr.get(right));
            right++;
        }
        
        int j = 0;
        for(int i=low; i<=high; i++){
            arr.set(i, ans.get(j));
                j++;
        }
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

        List<Integer> result = Result.sort(n, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

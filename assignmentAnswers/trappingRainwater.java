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
     * Complete the 'rain_water' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY hei as parameter.
     */

    public static int rain_water(List<Integer> hei) {
    // Write your code here
        int left=0;
        int right=hei.size()-1;
        int leftMax = 0;
        int rightMax = 0;
        int tot=0;
        
        while(left < right){
            if(hei.get(left)<=hei.get(right)){
                if(hei.get(left)<leftMax){
                    tot+=(leftMax-hei.get(left));
                }else{
                    leftMax=hei.get(left);
                }
                left++;
            }else{
                if(hei.get(right)<rightMax){
                    tot+=(rightMax-hei.get(right));
                }else{
                    rightMax=hei.get(right);
                }
                right--;
            }
        }
        return tot;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> hei = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.rain_water(hei);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

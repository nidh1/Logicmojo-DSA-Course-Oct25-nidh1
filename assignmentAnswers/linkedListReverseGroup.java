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

class SinglyLinkedListNode {
    public long data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(long nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(long nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {

    /*
     * Complete the 'findLinkedList' function below.
     *
     * The function is expected to return a LONG_INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_SINGLY_LINKED_LIST head
     *  2. INTEGER k
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     long data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode findLinkedList(SinglyLinkedListNode head, int k) {
    // Write your code here
        
        Stack<SinglyLinkedListNode> st = new Stack<>();
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode temp = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode ans =  temp;
        while(curr!=null){
            int i=0;
            
            while(curr!=null && i < k){
                st.push(curr);
                curr = curr.next;
                i++;
            }
            
            while(!st.isEmpty()){
                SinglyLinkedListNode node = st.pop();
                node.next = null;  
                ans.next = node;
                ans = ans.next;
            }
            
           
        }
        
        return temp.next;
    

    }


    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList l = new SinglyLinkedList();

        int lCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, lCount).forEach(i -> {
            try {
                long lItem = Long.parseLong(bufferedReader.readLine().trim());

                l.insertNode(lItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode result = Result.findLinkedList(l.head, k);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

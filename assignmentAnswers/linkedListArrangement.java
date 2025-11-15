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
     * Complete the 'rearrangeList' function below.
     *
     * The function is expected to return a LONG_INTEGER_SINGLY_LINKED_LIST.
     * The function accepts LONG_INTEGER_SINGLY_LINKED_LIST head as parameter.
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

    public static SinglyLinkedListNode rearrangeList(SinglyLinkedListNode head) {
    // Write your code here
        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        SinglyLinkedListNode temp = slow.next;
        slow.next = null;
        
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = temp;
        
        while(curr !=null){
            SinglyLinkedListNode backup = curr.next;
            curr.next = prev;
            prev = curr;
            curr = backup;
        }
        
        SinglyLinkedListNode ans = head;
        while(prev!=null && ans!=null){
            SinglyLinkedListNode temp1 = ans.next;
            ans.next = prev;
            ans = temp1;
            SinglyLinkedListNode temp2 = prev.next;
            prev.next = temp1;
            prev = temp2;
        }
        
        return head;
        
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

        SinglyLinkedListNode result = Result.rearrangeList(l.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

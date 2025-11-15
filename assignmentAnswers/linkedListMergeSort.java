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
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
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

    public void insertNode(int nodeData) {
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
     * Complete the 'sortLinkedList' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST start as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode sortLinkedList(SinglyLinkedListNode start) {
    // Write your code here
        if(start == null || start.next==null){
            return start;
        }
        
        SinglyLinkedListNode second = split(start);
        start = sortLinkedList(start);
        second = sortLinkedList(second);
        return merge(start, second);

    }
    
    public static SinglyLinkedListNode split(SinglyLinkedListNode node){
        SinglyLinkedListNode fast = node.next;
        SinglyLinkedListNode slow = node;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        SinglyLinkedListNode temp = slow.next;
        slow.next=null;
        return temp;
    }
    
    public static SinglyLinkedListNode merge(SinglyLinkedListNode first, SinglyLinkedListNode second){
        if(first == null){
            return second;
        }
        
        if(second == null){
            return first;
        }
        
        if(first.data < second.data){
            first.next = merge(first.next, second);
            return first;
        }else{
            second.next = merge(first, second.next);
            return second;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList start = new SinglyLinkedList();

        int startCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, startCount).forEach(i -> {
            try {
                int startItem = Integer.parseInt(bufferedReader.readLine().trim());

                start.insertNode(startItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = Result.sortLinkedList(start.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

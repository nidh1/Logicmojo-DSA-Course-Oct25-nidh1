    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode ptr1=head1;
        SinglyLinkedListNode ptr2=head2;
        
        while(ptr1!=ptr2){
          ptr1= ptr1!=null?ptr1.next:head2;
          ptr2= ptr2!=null?ptr2.next:head1;
     }
        return ptr1.data;
    }

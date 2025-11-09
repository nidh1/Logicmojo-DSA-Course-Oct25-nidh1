    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists( SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode curr = temp;
        while(head1!=null && head2!=null){
             if(head1.data <= head2.data){
                  curr.next = head1;
                  head1=head1.next;
              }else{
                 curr.next=head2;
                 head2=head2.next;
              }
              curr=curr.next;
      }
        
        while(head1!=null){
         curr.next = head1;
         curr=curr.next;
         head1=head1.next;
     }

        while(head2!=null){
         curr.next = head2;
         curr=curr.next;
         head2=head2.next;
     }
        return temp.next;
    }

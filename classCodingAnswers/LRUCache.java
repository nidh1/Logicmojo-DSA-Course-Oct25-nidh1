class LRUCache {

    int c;
    Map<Integer, Node> mp = new HashMap<>();
    Node head;
    Node tail;
    public LRUCache(int capacity) {
       head = new Node(0,0);
       tail = new Node(0,0);
       head.next=tail;
       tail.prev=head;
       c=capacity;
    }

    public int get(int key) {
       if(!mp.containsKey(key)){
        return -1;
       }
       remove(mp.get(key));
       add(mp.get(key));
       return mp.get(key).val;
    }

    public void put(int key, int value) {
        if(!mp.containsKey(key) && c == mp.size()){
            mp.remove(tail.prev.key);
            remove(tail.prev);
        }
      if(!mp.containsKey(key)){
        Node n = new Node(key,value);
        mp.put(key, n);
        add(n);
      }else{
        Node n = mp.get(key);
        n.val = value;
        remove(n);
        add(n);
      }
    }

    public void remove(Node n){
        Node prev = n.prev;
        Node next = n.next;
        next.prev = prev;
        prev.next = next;
    }

    public void add(Node n){
        Node next = head.next;
        next.prev = n;
        n.next = next;
        head.next = n;
        n.prev = head;
    }

}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key_, int val_){
        this.key = key_;
        this.val = val_;
    }
}

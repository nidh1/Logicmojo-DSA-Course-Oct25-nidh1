class BrowserHistory {

    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node n = new Node(url);
        curr.next = n;
        n.prev = curr;
        curr = n;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps > 0){
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps > 0){
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

class Node{
    String val;
    Node next;
    Node prev;

    Node(String _val){
        this.val = _val;
        next = null;
        prev = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

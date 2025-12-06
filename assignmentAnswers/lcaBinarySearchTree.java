	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
        List<Node> lst1 = new ArrayList<>();
        List<Node> lst2 = new ArrayList<>();
        helper(root, v1, lst1);
        helper(root, v2, lst2);
        
        Collections.reverse(lst1);
        
        for(Node n: lst1){
            if(lst2.contains(n)){
                return n;
            }
        }
        
        return new Node(-1);
    }
   

    public static void helper(Node root, int v1, List<Node> lst){
        if(root.data == v1){
            lst.add(root);
            return;
        }
        if(root.data > v1){
            lst.add(root);
            helper(root.left, v1, lst);
        }
        else{
            lst.add(root);
            helper(root.right, v1, lst);
        }
    }
 

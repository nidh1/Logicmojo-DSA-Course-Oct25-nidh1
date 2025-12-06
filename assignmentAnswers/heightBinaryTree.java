	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    int height = 0;
	public static int height(Node root) {
      	// Write your code here.
        int d = helper(root);
        return d-1;
    }

    public static int helper(Node root){
        if(root==null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return 1+Math.max(left, right);
}

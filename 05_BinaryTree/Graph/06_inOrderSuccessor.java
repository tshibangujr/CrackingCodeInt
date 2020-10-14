public class MyClass {
    public static void main(String args[]) {

    }
    public static class Node{
        int data;
        Node left;
        Node right;
        Node parent;
    }
  
    public static Node successor(Node n){
        if(n.right == null){
            if(n.parent != null && n.data > n.parent.data)
                return findParent(n);
            else
                return n.parent;
        }
        else{
            return findSuccessor(n.right);
        }
    }
    public static Node findSuccessor(Node n){
        if(n.left != null)
            return findSuccessor(n.left);
        else
            return n;
    }
    public static Node findParent(Node n){
        if(n.parent == null)
            return null;
        else{
            if(n.data > n.parent.data)
                return findParent(n.parent);
            else
                return n.parent;
        }
    }
}
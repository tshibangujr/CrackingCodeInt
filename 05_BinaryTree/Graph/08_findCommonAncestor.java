public class MyClass {
    public static void main(String args[]) {
        System.out.println("TEST");
    }
    public static class Node{
        Node left;
        Node right;
        Node parent;
        int depth;
    }
    
    public static Node firstCommonAncestor(Node nodeA, Node nodeB){
        if(nodeA != null && nodeB != null){
            Node currentA = nodeA;
            Node currentB = nodeB;
            if(nodeA.depth > nodeB.depth)
                harmonizeDepth(currentA, nodeA.depth - nodeB.depth);
            
            if(nodeB.depth > nodeA.depth)
                harmonizeDepth(currentB, nodeB.depth - nodeA.depth);
            
            //Check common parent
            while(currentA != null && currentB != null){
                if(currentA.parent != currentB.parent){
                    currentA = currentA.parent;
                    currentB = currentB.parent;
                }
                else
                    return currentA;
            }
        }
        return null;
    }
    public static void harmonizeDepth(Node node, int diff){
        for(int i = 0; i < diff; i++){
            node = node.parent;
        }
    }

}
public class MyClass {
    public static void main(String args[]) {
        
        MyClass.Node a1 = new MyClass.Node(6);
        MyClass.Node a2 = new MyClass.Node(1);
        MyClass.Node a3 = new MyClass.Node(7);
        a1.next = a2;
        a2.next = a3;
        
      
        MyClass.Node b1 = new MyClass.Node(3);
        MyClass.Node b2 = new MyClass.Node(9);
        MyClass.Node b3 = new MyClass.Node(5);
        b1.next = b2;
        b2.next = b3;
        
        MyClass.Node res = sumListNormalInit(a1, b1);
        displayNodes(res);
        
    }
    public static void displayNodes(Node head){
            Node current = head;
            System.out.println("Print Linkedlist: ");
            while(current != null){
                System.out.print(current.data + " , ");
                current = current.next;
            }
        }
    public static Node sumList(Node NodeA, Node NodeB){
        Node head = null;
        Node lastNode = head;
        int unit = 0;
        int valueA = 0, valueB = 0;
        
        while(NodeA != null || NodeB != null || unit == 1){
            Node newNode = new Node(0);
            if(NodeA != null){
                valueA = NodeA.data;
                NodeA = NodeA.next;
            }
            if(NodeB != null){
                valueB = NodeB.data;
                NodeB = NodeB.next;
            }
            newNode.data = valueA + valueB + unit;
            if(newNode.data >= 10){
                newNode.data -= 10;
                unit = 1;
            }else{
                unit = 0;
            }
            //Link to node
            if (head == null){
                head = newNode;
                lastNode = head;
            }else{
                lastNode.next = newNode;
                lastNode = newNode;
            }
            valueA = 0;
            valueB = 0;
        }
        return head;
    }
    public static Node sumListNormalInit(Node nodeA, Node nodeB){
        MyClass.WrapperIndex idx = new WrapperIndex();
        idx.unit = 0;
        MyClass.Node res = sumListNormal(nodeA, nodeB, idx);
        if(idx.unit == 1){
            //Add additional node at the begining
            MyClass.Node finalNode = new Node(idx.unit);
            finalNode.next = res;
            return finalNode;
        }else
            return res;
    }
    public static Node sumListNormal(Node nodeA, Node nodeB, WrapperIndex idx){
        if(nodeA != null && nodeB != null){
            Node last = sumListNormal(nodeA.next, nodeB.next, idx);
            Node current = new Node(0);
            current.data = nodeA.data + nodeB.data + idx.unit;
            current.next = last;
            if(current.data >= 10){
                current.data -= 10;
                idx.unit = 1;
            }else{
                idx.unit = 0;
            }
            return current;
        }else{
            return null;
        }
    }
    
    //node are in reverse order and equal length
    public static Node sumList(Node nodeA, Node nodeB, int unit){
        if(nodeA == null && nodeB == null)
            return null;
        Node result = new Node(0);
        result.data = nodeA.data + nodeB.data + unit;
        if(result.data >= 10){
            result.data -= 10;
            unit = 1;
        }else{
            unit = 0;
        }
        result.next = sumList(nodeA.next, nodeB.next, unit);
        return result;
    }
    public static class WrapperIndex{
        int unit;
    }
    
    public static class Node{
        int data;
        Node next;
        public Node(int d){
            data = d;
        }   
    }
    private class CLinkedList{
        Node head;
        
        public CLinkedList(){
            head = new Node(0);
        }
        public void addTail(Node node){
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            //Add
            current.next = node;
        }
        //Display
        public void displayNodes(){
            Node current = head;
            System.out.println("Print Linkedlist: ");
            while(current != null){
                System.out.print(current.data + " , ");
            }
        }
        
    }
}
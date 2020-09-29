import java.util.ArrayList;
import java.util.LinkedList;
public class MyClass {
    public static void main(String args[]) {
      Graph<Integer> graph = new Graph<Integer>();
      Node<Integer> a = new Node<Integer>(1);
      Node<Integer> b = new Node<Integer>(2);
      Node<Integer> c = new Node<Integer>(3);
      Node<Integer> d = new Node<Integer>(4);
      Node<Integer> f = new Node<Integer>(6);
      
      //Adjacent
      a.addChild(b);
      a.addChild(c);
      b.addChild(a);
      //b.addChild(d);
      d.addChild(f);
      f.addChild(d);
      f.addChild(b);
      
      //Add Node to graph
      graph.add(a);
      graph.add(b);
      graph.add(c);
      graph.add(d);
      graph.add(f);
      
      boolean res = graph.searchRoute(a, f);
      System.out.println("Search Route = " + res);
    }
    public static class Graph<T>{
        ArrayList<Node<T>> nodes;
        public Graph(){
            nodes = new ArrayList<Node<T>>();
        }
        
        public void add(Node<T> node){
            if(nodes != null){
                nodes.add(node);
            }
        }
        
        public boolean searchRoute(Node<T> fromNode, Node<T> toNode){
            //BFS from Node fromNode to  toNode
            LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
            fromNode.marked = true;
            queue.add(fromNode);
            
            Node<T> curr;
            while(!queue.isEmpty()){
                curr = queue.poll();
                if(curr != null){
                    for(Node<T> child : curr.children){
                        if(child == toNode)
                            return true;
                        if(child.marked == false){
                            child.marked = true;
                            queue.add(child);
                        }
                    }   
                    curr.marked = true;
                }
            }
            return false;   
        }
    }
    public static class Node<T>{
        boolean marked;
        T value; 
        ArrayList<Node<T>> children;
        public Node(T value){
            this.value = value;
            children = new ArrayList<Node<T>>();
        }
        public void addChild(Node<T> child){
            children.add(child);
        }
    }
}
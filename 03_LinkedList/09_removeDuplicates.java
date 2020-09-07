public void removeDups(Node head){
        if(head != null){
            HashMap<Integer, Integer> hashTable = new HashMap<>();
            Node current = head;
            while(current.next != null){
                if(hashTable.containsKey(current.next.data)){
                    //remove next element
                    current.next = current.next.next;
                }else{
                    //Add to hashtable
                    hashTable.put(current.next.data, 1);
                    //Move to next element
                    current = current.next;
                }
            }
        }
    }
    private class Node{
        int data;
        Node next;
    }
    private class CLinkedList{
        Node head;
    
        public CLinkedList(){
            head = new Node();
        }
        
    }
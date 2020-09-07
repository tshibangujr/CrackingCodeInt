public static Node kthToLast(Node head, int k){
        Node current = head;
        Node runner = head;
        
        //Move runner k steps
        for(int i = 0; i < k; i++){
            runner = runner.next;
        }
        while(runner != null){
            runner = runner.next;
            current = current.next;
        }
        return current;
    }
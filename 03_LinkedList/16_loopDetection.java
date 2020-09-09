public static Node loopDetection(Node head){
        if(head != null){
            Node current = head;
            HashSet<Node> hash = new HashSet<>();
            while(!hash.contains(current)){
                //Add to hash
                hash.add(current);
                current = current.next;
            }
            return current;
        }
        return null;
    }
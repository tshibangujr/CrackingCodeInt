    public static void deleteMiddleNode(Node middle){
        if(middle != null){
            Node current = middle;
            if(current.next != null){
                current.data = current.next.data;
                current.next = current.next.next;
            }else{
				current = null;
			}
            
        }
    }
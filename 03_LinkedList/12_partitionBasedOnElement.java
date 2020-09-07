    public static void partition(Node head, int p){
        Node current = head;
        Node mover = head;
        int temp;
        while(mover != null){
            if(mover.data < p){
                temp = current.data;
                current.data = mover.data;
                mover.data = temp;
                //Move current
                current = current.next;
            }
            mover = mover.next;
        }
    }
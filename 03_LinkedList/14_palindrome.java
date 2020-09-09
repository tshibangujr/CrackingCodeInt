public static boolean isPalindrome(Node head){
        if(head != null){
            MyClass.WrapperIndex idx = new MyClass.WrapperIndex();
            idx.unit = 1;
            Node rev = reverseList(head, idx);
            Node current = head;
            for(int i = 0; i < idx.unit / 2; i++){
                if(current.data != rev.data)
                    return false;
                current = current.next;
                rev = rev.next;
            }
            return true;
        }
        return false;
    }
    public static Node reverseList(Node head, WrapperIndex idx){
        MyClass.Node result = new Node(head.data);
        result.next = null;
        Node current = head;
        while(current.next != null){
            current = current.next;
            //New node 
            MyClass.Node newNode = new MyClass.Node(current.data);
            newNode.next = result;
            result = newNode;
            idx.unit++;
        }
        return result;
    }
    public static class WrapperIndex{
        int unit;
    }
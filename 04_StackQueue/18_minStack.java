private static class CStack{
        StackNode top;
        StackNode minTop;
        
        private static class StackNode{
            int data;
            StackNode next;
            
            public StackNode(int v){
                data = v;
            }
        }
        
        public void push(int value){
            StackNode newNode = new StackNode(value);
            newNode.next = top;
            top = newNode;
            //Push in MinStack
            pushMin(value);
        }
        public int pop(){
            if(top == null) throw new EmptyStackException();
            int item = top.data;
            top = top.next;
            //Pop from MinStack
            popMin(item);
            return item;
        }
        public void pushMin(int value){
            if(minTop == null)
                pushNodeMin(value);
            else{
                int min = getMin();
                if(min >= value)
                    pushNodeMin(value);
            }
        }
        public void popMin(int value){
            if(minTop == null) throw new EmptyStackException();
            int min = getMin();
            if(min == value)
                popNodeMin();
        }
        
        public int getMin(){
            if(minTop == null) throw new EmptyStackException();
            return minTop.data;
        }
        
        public void pushNodeMin(int value){
            StackNode newNode = new StackNode(value);
            newNode.next = minTop;
            minTop = newNode;
        }
        
        public void popNodeMin(){
            minTop = minTop.next;
        }
    }
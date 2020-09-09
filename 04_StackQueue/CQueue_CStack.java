private static class CQueue<T>{
        QueueNode<T> first;
        QueueNode<T> last;
        private static class QueueNode<T>{
            T data;
            QueueNode<T> next;
            public QueueNode(T data){
                this.data = data;
            }
        }
        
        public void add(T value){
            QueueNode<T> newNode = new QueueNode<T>(value);
            if(last != null){
                last.next = newNode;
            }
            last = newNode;
            if(first == null)
                first = last;
        }
        public T remove(){
            if(first == null)
                throw new NoSuchElementException();
            T data = first.data;
            first = first.next;
            if(first == null)
                last = null;
            return data;
        }
        
        public T peek(){
            if(first == null)
                throw new NoSuchElementException();
            return first.data;
        }
    }

    private static class CStack<T>{
        StackNode<T> top;
        
        private static class StackNode<T>{
            T data;
            StackNode<T> next;
            
            public StackNode(T data){
                this.data = data;
            }
        }
        
        public void push(T value){
            StackNode<T> newNode = new StackNode<T>(value);
            newNode.next = top;
            top = newNode;
        }
        public T pop(){
            if(top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }
        public T peek(){
            if(top == null) throw new EmptyStackException();
            return top.data;
        }
        
        public boolean isEmpty(){
            return top == null;
        }
    }
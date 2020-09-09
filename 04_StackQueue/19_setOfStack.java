private static class SetOfStacks<T> extends CStack<T>{
        int capacity;
        int counter = 0;
        ArrayList<StackNode<T>> stacks = new ArrayList<StackNode<T>>();
        
        public SetOfStacks(int capacity){
            super();
            this.capacity = capacity;
        }
        
        public void push(T value){
            if(counter < capacity){
                super.push(value);
                counter++;
            }else{
                stacks.add(this.top);
                counter = 1;
                this.top = new StackNode<T>(value);
            }
        }
        public T pop(){
            if(this.top == null){
                if(stacks.isEmpty()) throw new EmptyStackException();
                else{
                    this.top = stacks.get(stacks.size() - 1);
                    counter = capacity;
                }
            }
            T item = top.data;
            top = top.next;
            counter--;
            return item;
        }
        
        public T peek(){
            if(top == null){
                if(stacks.isEmpty()) throw new EmptyStackException();
                else{
                    this.top = stacks.get(stacks.size() - 1);
                    counter = capacity;
                }
            }
            return top.data;
        }
}
private static class CQueue<T>{
        CStack<T> firstStack;
        CStack<T> secondStack;
        
        public CQueue(){
            firstStack = new CStack<T>();
            secondStack = new CStack<T>();
        }
        
        public void add(T item){
            if(!secondStack.isEmpty()){
                //Move nodes from second to First
                move(secondStack, firstStack);
            }
            //Add to first Stack
            firstStack.push(item);
        }
        
        public T remove(){
            if(secondStack.isEmpty() && !firstStack.isEmpty()){
                move(firstStack, secondStack);
            }
            if(secondStack.isEmpty) throw new EmptyStackException();
            return secondStack.pop();
        }
        
        public T peek(){
            if(secondStack.isEmpty() && !firstStack.isEmpty()){
                move(firstStack, secondStack);
            }
            if(secondStack.isEmpty()) throw new EmptyStackException();
            return secondStack.peek();
        }
        
        public void move(CStack<T> first, CStack<T> second){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
}
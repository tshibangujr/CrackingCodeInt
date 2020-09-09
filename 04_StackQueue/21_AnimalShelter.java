private abstract class Animal{
        String name;
        Date dateOfBirth;
        String color;
        public Animal(String n){
            name = n;
        }
    }
    private class Dog extends Animal{
        public Dog(String n){
            super(n);
        }
    }
    private  class Cat extends Animal{
        public Cat(String n){
            super(n);
        }
    }
    
    private class Registration<T>{
        T animal;
        Date arrivalDate;
        
        public Registration(T item){
            animal = item;
            arrivalDate = new Date();
        }
    }
    private static class Shelter{
        LinkedList<Registration> dogBook;
        LinkedList<Registration> catBook;
        
        public Shelter(){
            dogBook = new LinkedList<Registration>();
            catBook = new LinkedList<Registration>();
        }
        
        public void enqueue(Registration<Animal> item){
            if(item.animal instanceof Dog)
                dogBook.add(item);
            else
                catBook.add(item);
        }
        public Registration<Animal> dequeueAny(){
            if(dogBook.size() == 0 && catBook.size() == 0) 
                throw new NoSuchElementException();
            else if (dogBook.size() == 0) 
                return catBook.remove();
            else if (catBook.size() == 0)
                return dogBook.remove();
            else{    
                if(dogBook.getFirst().arrivalDate.before(catBook.getFirst().arrivalDate)){
                    return dogBook.remove();
                }
                else
                    return catBook.remove();
            }
        }
        public Registration<Animal> dequeueDog(){
            return dogBook.remove();
        }
        public Registration<Animal> dequeueCat(){
            return catBook.remove();
        }
    }
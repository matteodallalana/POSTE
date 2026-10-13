public class Queue<T> extends List<T>{
    public Queue(){
        super();
    }

    public void enqueue(T value){
        this.addTail(value);
    }

    //public T deque(T value){
    //    return this.remove();
    //}

    public T deque(){
        return this.removeHead();
    }
}

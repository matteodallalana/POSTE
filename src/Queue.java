import java.util.function.Predicate;

public class Queue<T> extends List<T>{
    public Queue(){
        super();
    }

    // inserisce in fondo alla coda
    public void enqueue(T value){
        this.addTail(value);
    }

    // senza parametro: restituisce il primo elemento entrato in coda
    public T deque(){
        return this.removeHead();
    }

    // con condizione: restituisce il primo elemento (in ordine di arrivo) che la soddisfa,
    // oppure null se non ce ne sono
    public T deque(Predicate<T> condition){
        return this.removeFirst(condition);
    }
}
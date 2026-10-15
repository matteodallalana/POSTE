import java.util.Objects;

public class Queue<T> extends List<T> {
    public Queue(){
        super();
    }

    public void enqueue(T value){
        this.addHead(value);
    }

    /**
     * Removes the item at index.
     *
     * @param value of the item to remove
     */
    protected T dequeueWithParam(Operations value) {
        if (this.getHead() == null) {
            System.out.println(
                    "List empty, couldn't find " + value + "."
            );
            return null;
        }

        Node<T> cur = this.getHead();

        //Search for the item to remove
        while (cur != null && !Objects.equals(cur.getValue().toString(), value.toString())) {
            cur = cur.getNext();
        }

        if (cur == null) {
            System.out.println("Prodotto " + value + " non trovato.");
            return null;
        }else if (cur == this.getHead()) {
            return this.removeHead();
        }else if (cur == this.getTail()) {
            return this.removeTail();
        }else{
            Node<T> prev = cur.getPrev();
            Node<T> next = cur.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            cur.setPrev(null);
            cur.setNext(null);
            return cur.getValue();
        }
    }

    public T dequeue(){
        return this.removeTail();
    }
}

import java.util.Objects;

public class Queue extends List<Ticket> {
    public Queue(){
        super();
    }

    public void enqueue(Ticket value){
        this.addHead(value);
    }

    /**
     * Removes the item at index.
     *
     * @param value of the item to remove
     */
    protected Ticket dequeueWithParam(Operations value) {
        if (this.getHead() == null) {
            System.out.println(
                    "List empty, couldn't find " + value + "."
            );
            return null;
        }

        Node<Ticket> cur = this.getHead();

        //Search for the item to remove
        while (cur != null && cur.getValue().getType() != value) {
            cur = cur.getNext();
        }

        if (cur == null) {

            System.out.println("Prodotto " + value + " non trovato.");
            return null;

        }else if (cur == this.getHead()) {
            Node<Ticket> tempHead = this.getHead();
            tempHead.getValue().setFinish(System.currentTimeMillis());
            return this.removeHead();

        }else if (cur == this.getTail()) {

            Node<Ticket> tempTail = this.getHead();
            tempTail.getValue().setFinish(System.currentTimeMillis());
            return this.removeTail();

        }else{
            Node<Ticket> prev = cur.getPrev();
            Node<Ticket> next = cur.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            cur.setPrev(null);
            cur.setNext(null);
            cur.getValue().setFinish(System.currentTimeMillis());
            return cur.getValue();
        }
    }

    public Ticket dequeue(){
        Node<Ticket> tempTail = this.getHead();
        tempTail.getValue().setFinish(System.currentTimeMillis());
        return this.removeTail();
    }
}

import java.io.IO;
import java.util.function.Predicate;

public class List<T>{
    private ListItem<T> head;
    private ListItem<T> tail;

    protected List() {
        this.head = null;
        this.tail = null;
    }

    protected void addHead(T value){
        ListItem<T> newItem = new ListItem<T>(value);
        newItem.setNext(head);

        if(this.head == null){
            this.head = newItem;
            this.tail = newItem;
            return;
        }

        head.setPrev(newItem);
        head = newItem;
    }

    protected void addTail(T value){
        ListItem<T> newItem = new ListItem<T>(value);

        if(this.head == null){
            this.head = newItem;
            this.tail = newItem;
            return;
        }

        newItem.setPrev(this.tail);
        this.tail.setNext(newItem);
        this.tail = newItem;
    }

    protected void insert(int index, T value){
        if(index <= 0){
            addHead(value);
        }else{
            int cont = 0;
            ListItem<T> cur = head;
            while (cur != null && cont < index){
                cont ++;
                cur = cur.getNext();
            }
            if(cur == null){
                addTail(value);
            }else {
                ListItem<T> newItem = new ListItem<T>(value);
                newItem.setNext(cur);
                newItem.setPrev(cur.getPrev());
                cur.getPrev().setNext(newItem);
                cur.setPrev(newItem);
            }
        }
    }

    protected T removeHead(){
        if(this.head == null){
            IO.println("La lista è vuota");
            return null;
        }
        // BUG CORRETTO: prima leggeva il valore dalla coda (tail) invece che dalla testa
        T removedElement = this.head.getValue();

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        return removedElement;
    }

    protected T removeTail(){
        if(this.head == null){
            IO.println("La lista è vuota");
            return null;
        }

        T removedElement = this.tail.getValue();

        if(this.head == this.tail){
            this.tail = null;
            this.head = null;
        }else{
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        return removedElement;
    }

    // ora restituisce l'elemento rimosso (prima era void)
    protected T remove(int index){
        if(head == null){
            IO.println("La lista è vuota");
            return null;
        }
        if(index < 0){
            IO.println("Indice non valido");
            return null;
        }

        ListItem<T> cur = head;
        int cont = 0;

        while(cur != null && cont < index){
            cur = cur.getNext();
            cont ++;
        }

        if (cur == null){
            IO.println("Indice fuori dal limite");
            return null;
        }

        return unlink(cur);
    }

    // rimuove e restituisce il primo elemento che soddisfa la condizione, null se non esiste
    protected T removeFirst(Predicate<T> condition){
        ListItem<T> cur = head;
        while(cur != null && !condition.test(cur.getValue())){
            cur = cur.getNext();
        }
        if(cur == null){
            return null;
        }
        return unlink(cur);
    }

    // scollega un nodo dalla lista aggiornando head/tail/riferimenti
    private T unlink(ListItem<T> cur){
        if(cur == head){
            head = cur.getNext();
            if(head != null){
                head.setPrev(null);
            }else{
                tail = null;
            }
        }else if(cur == tail){
            tail = cur.getPrev();
            tail.setNext(null);
        }else{
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
        }
        return cur.getValue();
    }

    public T get(int index){
        if(head == null){
            IO.println("La lista è vuota");
            return null;
        }
        if(index < 0){
            IO.println("L'indice non è valido");
            return null;
        }
        ListItem<T> cur = head;
        int cont = 0;

        while (cur != null && cont < index){
            cur = cur.getNext();
            cont ++;
        }
        // BUG CORRETTO: se l'indice era fuori dal limite andava in NullPointerException
        if(cur == null){
            IO.println("Indice fuori dal limite");
            return null;
        }
        return cur.getValue();
    }

    public void clear(){
        // BUG CORRETTO: la tail non veniva azzerata
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int cont = 0;
        ListItem<T> cur = head;

        while(cur != null){
            cont ++;
            cur = cur.getNext();
        }
        return cont;
    }

    @Override
    public String toString() {
        // BUG CORRETTO: con la lista vuota stampava e poi andava in NullPointerException
        if(head == null){
            return "[ lista vuota ]";
        }

        String finalString = "";
        ListItem<T> cur = head;

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";
        finalString += "[ ";

        while (cur != null) {
            finalString += cur.getValue();
            if (cur.getNext() != null) {
                finalString += " <-> ";
            }
            cur = cur.getNext();
        }
        finalString += " ]";
        return finalString;
    }
}
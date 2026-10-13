
public class ListItem<T>{
    //valore numerico del nodo
    private T value;
    private ListItem<T> prev;//riferimento al nodo precendente
    private ListItem<T> next;//riferimento al nodo successivo

    //costruttore, inizializzo il valore e imposto il successivo a null
    public ListItem(T value){
        this.value = value;
        this.next = null; //creo di default una lista vuota
        this.prev = null;
    }

    //restituisce il valore del nodo
    public T getValue() {
        return value;
    }

    //imposta il puntatore al nodo successivo
    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    //restituisce il riferimento al nodo successivo
    public ListItem<T> getNext() {
        return this.next;
    }

    public void setPrev(ListItem<T> prev){
        this.prev = prev;
    }

    public ListItem<T> getPrev(){
        return this.prev;
    }

}
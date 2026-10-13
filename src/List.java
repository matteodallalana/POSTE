import java.io.IO;

public class List<T>{
    private ListItem<T> head;
    private ListItem<T> tail;

    protected  List() {
        this.head = null;
        this.tail = null;
    }

    protected void addHead(T value){
        ListItem<T> newItem = new ListItem<T>(value);
        newItem.setNext(head);

        if(this.head == null){
            this.head = newItem;
            this.tail = head;
            return;
        }else if(head != null){
            head.setPrev(newItem);
        }
        head = newItem;
    }

    protected  void addTail(T value){
        ListItem<T> newItem = new ListItem<T>(value);

        if(this.head == null){
            this.head = newItem;
            this.tail = head;
            return;
        }

        newItem.setPrev(this.tail);
        this.tail.setNext(newItem);
        this.tail = this.tail.getNext();

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

    protected  T removeHead(){
        if(this.head == null){
            System.out.println("la lista é vuota");
            return null;
        }
        T removedElement = this.tail.getValue();

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        return removedElement;
    }

    protected  T removeTail(){
        if(this.head == null){
            System.out.println("La lista é vuota");
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

    protected  void remove(int index){
        if(head == null){
            IO.println("La lista é vuota");
            return;
        }else if(index < 0){
            IO.println("Indice non valido");
            return;
        }else{

            ListItem<T> cur = head;
            int cont = 0;

            while(cur != null && cont < index){
                cur = cur.getNext();
                cont ++;
            }

            if (cur == null){
                IO.println("Indice fuori dal limite");
                return;
            }else if(cur == head){
                head = cur.getNext();
                if(head != null){
                    head.setPrev(null);
                }else {
                    tail = null;
                }
            }

            else if (cur == tail){
                tail = cur.getPrev();
                if(tail != null){
                    tail.setNext(null);
                }
            }else {
                cur.getPrev().setNext(cur.getNext());
                cur.getNext().setPrev(cur.getPrev());
            }
        }
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
        return cur.getValue();
    }

    public void clear(){
        ListItem<T> cur = head;
        while(cur != null){
            cur = cur.getNext();
            this.head = null;
        }
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
        if(head == null){
            IO.println("La lista è vuota");
        }

        String finalString = " ";
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

    /*
    public T[] toArray(){
        int size = this.size();
        T[] array = new T[size];

        ListItem<T> cur = head;
        int cont = 0;
        while(cur != null){
            System.out.println(cur.getValue());
            array[cont] = cur.getValue();
            cont ++;
            cur = cur.getNext();
        }
        return array;
    }*/

}
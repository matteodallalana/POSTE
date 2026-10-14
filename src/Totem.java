import java.util.EnumMap;

// Distributore dei numeri + coda unica dei clienti in attesa
public class Totem {
    private final Queue<Ticket> queue = new Queue<Ticket>();
    // ultimo numero emesso per ogni tipo di operazione (sequenze indipendenti)
    private final EnumMap<Operations, Integer> counters = new EnumMap<>(Operations.class);

    public Totem(){
        for(Operations op : Operations.values()){
            counters.put(op, 0);
        }
    }

    // un cliente chiede un numero: viene creato il ticket (con timestamp) e messo in coda
    public Ticket requestTicket(Operations type){
        int next = counters.get(type) + 1;
        counters.put(type, next);

        Ticket ticket = new Ticket(type, next);
        queue.enqueue(ticket);
        return ticket;
    }

    // primo cliente entrato in coda, qualunque sia il servizio (null se coda vuota)
    public Ticket next(){
        return queue.deque();
    }

    // primo cliente in coda per il servizio indicato (null se non ce ne sono)
    public Ticket next(Operations type){
        return queue.deque(t -> t.getType() == type);
    }

    public int waiting(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString(){
        return queue.toString();
    }
}
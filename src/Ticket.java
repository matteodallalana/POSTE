import java.time.Duration;
import java.time.Instant;

public class Ticket {
    private final Operations type;
    private final int number;          // numero progressivo, diverso per ogni tipo di operazione
    private final Instant issuedAt;    // timestamp di quando il numero è stato richiesto
    private Instant completedAt;       // timestamp di fine servizio (null finché non evaso)

    public Ticket(Operations type, int number){
        this.type = type;
        this.number = number;
        this.issuedAt = Instant.now();
        this.completedAt = null;
    }

    public Operations getType(){
        return this.type;
    }

    public int getNumber(){
        return this.number;
    }

    public Instant getIssuedAt(){
        return this.issuedAt;
    }

    public Instant getCompletedAt(){
        return this.completedAt;
    }

    // da chiamare quando il cliente ha finito di essere servito
    public void complete(){
        this.completedAt = Instant.now();
    }

    public boolean isCompleted(){
        return this.completedAt != null;
    }

    // tempo trascorso tra l'emissione del ticket e la fine del servizio
    // (null se il ticket non è ancora stato evaso)
    public Duration getElapsedTime(){
        if(completedAt == null){
            return null;
        }
        return Duration.between(issuedAt, completedAt);
    }

    // es. "P1", "F3", "A2"
    @Override
    public String toString(){
        return "" + this.type + this.number;
    }
}
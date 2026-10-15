
public class Ticket{
    private final Operations type;
    long start = System.currentTimeMillis();
    long finish;


    public Ticket(Operations type) {
        this.type = type;
    }

    /**
     * @return the Ticket's type
     */
    public Operations getType(){
        return this.type;
    }

    public long getStart() {
        return start;
    }

    public long getFinish(){
        return this.finish;
    }

    public void setFinish(long finish){
        this.finish = finish;
    }

    @Override
    public String toString(){
        return (this.type.toString());
    }
}

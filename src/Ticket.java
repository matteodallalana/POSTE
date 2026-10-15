public class Ticket{
    private final Operations type;

    public Ticket(Operations type) {
        this.type = type;
    }

    /**
     * @return the Ticket's type
     */
    public Operations getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return (this.type.toString());
    }
}

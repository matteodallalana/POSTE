public class Ticket {
    private Operations type;

    public Ticket(Operations type){
        this.type = type;
    }

    public Operations getType(){
        return this.type;
    }

    @Override
    public String toString(){
        String fin = "";
        return fin + this.type;
    }

}

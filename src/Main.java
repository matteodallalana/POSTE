public static Queue<Ticket> tickets = new Queue<Ticket>();

void main(){
    tickets.enqueue(new Ticket(Operations.A));
    tickets.enqueue(new Ticket(Operations.F));
    tickets.enqueue(new Ticket(Operations.P));
    tickets.enqueue(new Ticket(Operations.P));

    IO.println(tickets);
}
public static Queue<Ticket> queue = new Queue<Ticket>();

void main() {
    queue.enqueue(new Ticket(Operations.P));
    queue.enqueue(new Ticket(Operations.A));
    queue.enqueue(new Ticket(Operations.P));
    queue.enqueue(new Ticket(Operations.P));
    queue.enqueue(new Ticket(Operations.F));
    queue.enqueue(new Ticket(Operations.F));
    queue.enqueue(new Ticket(Operations.A));

    IO.println(queue);

    queue.dequeueWithParam(Operations.A);
    IO.println(queue);

}
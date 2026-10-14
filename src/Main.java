Totem totem = new Totem();

void main(){
    totem.requestTicket(Operations.A);
    totem.requestTicket(Operations.F);
    totem.requestTicket(Operations.P);
    totem.requestTicket(Operations.P);
    totem.requestTicket(Operations.A);

    IO.println("In coda:\n" + totem);

    // uscita senza parametro: il primo entrato (A1)
    Ticket t1 = totem.next();
    IO.println("Servo " + t1);
    t1.complete();
    IO.println("Tempo per " + t1 + ": " + t1.getElapsedTime().toMillis() + " ms");

    // uscita per tipo: il primo pacco (P1), anche se F1 e A2 sono davanti/dietro
    Ticket t2 = totem.next(Operations.P);
    IO.println("Servo " + t2);
    t2.complete();
    IO.println("Tempo per " + t2 + ": " + t2.getElapsedTime().toMillis() + " ms");

    IO.println("Rimasti in coda:\n" + totem);
}
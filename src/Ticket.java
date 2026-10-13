public class Biglietto {
    private Operazioni tipo;

    public Biglietto(Operazioni tipo){
        this.tipo = tipo;
    }

    public Operazioni getTipo(){
        return this.tipo;
    }

}

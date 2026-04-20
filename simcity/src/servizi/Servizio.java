package servizi;

public abstract class Servizio {
    protected String nome;
    protected int costo;
    protected int capacita;

    public Servizio(String nome, int costo, int capacita) {
        this.nome = nome;
        this.costo = costo;
        this.capacita = capacita;
    }

    public String getNome() { return nome; }
    public int getCosto() { return costo; }
    public int getCapacita() { return capacita; }

    @Override
    public String toString() {
        return nome + " (+" + capacita + ")";
    }
}

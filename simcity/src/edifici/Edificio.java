package edifici;

public abstract class Edificio {
    protected String nome;
    protected int costo;

    public Edificio(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return nome + "| Costo: " + costo;
    }
}
package model;

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

    // Metodo astratto → polimorfismo
    public abstract void effetto(Citta citta);

    @Override
    public String toString() {
        return nome + " (Costo: " + costo + ")";
    }
}
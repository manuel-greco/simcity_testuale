package edifici.residenziali;

import edifici.Edificio;

public abstract class EdificioResidenziale extends Edificio {
    protected int capacitaAbitanti;

    public EdificioResidenziale(String nome, int capacitaAbitanti) {
        super(nome);
        this.capacitaAbitanti = capacitaAbitanti;
    }

    public int getCapacitaAbitanti() {
        return capacitaAbitanti;
    }

    @Override
    public String getInfo() {
        return nome + " - Capacità: " + capacitaAbitanti + " abitanti";
    }

    @Override
    public void stampaMexCostruito() {
        System.out.println("Costruzione di " + nome + " completata!");
        System.out.println("Può ospitare fino a " + capacitaAbitanti + " abitanti.");
    }
}
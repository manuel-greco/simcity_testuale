package edifici.commerciali;

import edifici.Edificio;

public abstract class EdificioCommerciale extends Edificio {
    protected int guadagnoGiornaliero;
    protected int felicita;

    public EdificioCommerciale(String nome, int costo, int guadagnoGiornaliero, int felicita) {
        super(nome, costo);
        this.guadagnoGiornaliero = guadagnoGiornaliero;
        this.felicita = felicita;
    }

    public int getGuadagnoGiornaliero() {
        return guadagnoGiornaliero;
    }

    public int getFelicita() {
        return felicita;
    }

    @Override
    public String toString() {
        return nome + " | Costo: " + costo + " | Guadagno/giorno: " + guadagnoGiornaliero + " | Felicità: +" + felicita;
    }
}
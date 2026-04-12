package edifici.residenziali;

import edifici.Edificio;

/**
 * Classe astratta che rappresenta un edificio residenziale.
 * Gli edifici residenziali ospitano abitanti e aumentano la popolazione della città.
 */
public abstract class EdificioResidenziale extends Edificio {
    protected int capacitaAbitanti;

    /**
     * Costruttore della classe EdificioResidenziale.
     */
    public EdificioResidenziale(String nome, int capacitaAbitanti) {
        super(nome);
        this.capacitaAbitanti = capacitaAbitanti;
    }

    /**
     * Ottiene la capacità di abitanti dell'edificio.
     */
    public int getCapacitaAbitanti() {
        return capacitaAbitanti;
    }

    @Override
    public String getInfo() {
        return nome + " - Capacità: " + capacitaAbitanti + " abitanti";
    }

    @Override
    public void costruisci() {
        System.out.println("🏠 Costruzione di " + nome + " completata!");
        System.out.println("   Può ospitare fino a " + capacitaAbitanti + " abitanti.");
    }
}
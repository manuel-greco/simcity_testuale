package edifici;

import risorse.TipoRisorsa;
import java.util.HashMap;

/**
 * Classe astratta che rappresenta un edificio generico.
 * Tutti gli edifici (residenziali, industriali, commerciali, servizi) estendono questa classe.
 */
public abstract class Edificio {
    protected String nome;
    protected HashMap<TipoRisorsa, Integer> costoCostruzione;

    /**
     * Costruttore della classe Edificio.
     */
    public Edificio(String nome) {
        this.nome = nome;
        this.costoCostruzione = new HashMap<>();
    }

    /**
     * Aggiunge un costo di costruzione.
     */
    protected void aggiungiCosto(TipoRisorsa risorsa, int quantita) {
        costoCostruzione.put(risorsa, quantita);
    }

    /**
     * Metodo astratto per costruire l'edificio.
     */
    public abstract void costruisci();

    /**
     * Metodo astratto per ottenere informazioni sull'edificio.
     */
    public abstract String getInfo();

    // Getter
    public String getNome() {
        return nome;
    }

    public HashMap<TipoRisorsa, Integer> getCostoCostruzione() {
        return costoCostruzione;
    }

    /**
     * Mostra i costi di costruzione dell'edificio.
     */
    public void mostraCosti() {
        System.out.println("Costi per " + nome + ":");
        for (TipoRisorsa risorsa : costoCostruzione.keySet()) {
            System.out.println("  - " + risorsa + ": " + costoCostruzione.get(risorsa));
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
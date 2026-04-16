package edifici;

import risorse.TipoRisorsa;
import java.util.HashMap;

public abstract class Edificio {
    protected String nome;
    protected HashMap<TipoRisorsa, Integer> costoCostruzione;

    public Edificio(String nome) {
        this.nome = nome;
        this.costoCostruzione = new HashMap<>();
    }

    protected void aggiungiCosto(TipoRisorsa risorsa, int quantita) {
        costoCostruzione.put(risorsa, quantita);
    }

    public abstract void stampaMexCostruito();

    public abstract String getInfo();

    public HashMap<TipoRisorsa, Integer> getCostoCostruzione() {
        return costoCostruzione;
    }

    public void mostraCosti() {
        System.out.println("Costi per " + nome + ":");
        for (TipoRisorsa risorsa : costoCostruzione.keySet()) {
            System.out.println("  - " + risorsa + ": " + costoCostruzione.get(risorsa));
        }
    }
}
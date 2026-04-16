package risorse;

import java.util.HashMap;

/**
 * Classe che gestisce tutte le risorse della città.
 * Utilizza HashMap per una gestione dinamica e type-safe delle risorse.
 */
public class Risorse {
    private HashMap<TipoRisorsa, Integer> risorse;

    /**
     * Costruttore: inizializza le risorse con valori di partenza.
     */
    public Risorse() {
        risorse = new HashMap<>();

        // Risorsa principale
        risorse.put(TipoRisorsa.DENARO, 10000);

        // Servizi essenziali
        risorse.put(TipoRisorsa.ENERGIA, 0);
        risorse.put(TipoRisorsa.ACQUA, 0);

        // Popolazione
        risorse.put(TipoRisorsa.POPOLAZIONE, 0);

        // Materiali GREZZI
        risorse.put(TipoRisorsa.LEGNO, 10);
        risorse.put(TipoRisorsa.METALLO, 10);

        // Materiali LAVORATI
        risorse.put(TipoRisorsa.CHIODI, 5);
        risorse.put(TipoRisorsa.ASSI, 5);
        risorse.put(TipoRisorsa.MARTELLO, 0);
        risorse.put(TipoRisorsa.NASTRO, 0);
    }

    /**
     * Ottiene la quantità di una specifica risorsa.
     */
    public int get(TipoRisorsa tipo) {
        Integer valore = risorse.get(tipo);
        if (valore != null) {
            return valore;
        }
        return 0;
    }

    /**
     * Consuma una certa quantità di risorsa.
     */
    public boolean consuma(TipoRisorsa tipo, int quantita) {
        Integer valore = risorse.get(tipo);
        if (valore != null && valore >= quantita) {
            risorse.put(tipo, valore - quantita);
            return true;
        }
        return false;
    }

    /**
     * Produce/aggiunge una certa quantità di risorsa.
     */
    public void produci(TipoRisorsa tipo, int quantita) {
        Integer valore = risorse.get(tipo);
        if (valore != null) {
            risorse.put(tipo, valore + quantita);
        } else {
            risorse.put(tipo, quantita);
        }
    }

    /**
     * Imposta direttamente il valore di una risorsa.
     */
    public void set(TipoRisorsa tipo, int valore) {
        risorse.put(tipo, valore);
    }

    /**
     * Mostra tutte le risorse disponibili.
     */
    public void mostraRisorse() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║         RISORSE CITTÀ          ║");
        System.out.println("╚════════════════════════════════╝");

        System.out.println("\n- DENARO: " + risorse.get(TipoRisorsa.DENARO));
        System.out.println("- POPOLAZIONE: " + risorse.get(TipoRisorsa.POPOLAZIONE));

        System.out.println("\n- Servizi:");
        System.out.println("\tEnergia: " + risorse.get(TipoRisorsa.ENERGIA));
        System.out.println("\tAcqua: " + risorse.get(TipoRisorsa.ACQUA));

        System.out.println("\n- Materiali GREZZI:");
        System.out.println("\tLegno: " + risorse.get(TipoRisorsa.LEGNO));
        System.out.println("\tMetallo: " + risorse.get(TipoRisorsa.METALLO));

        System.out.println("\n- Materiali LAVORATI:");
        System.out.println("\tChiodi: " + risorse.get(TipoRisorsa.CHIODI));
        System.out.println("\tAssi: " + risorse.get(TipoRisorsa.ASSI));
        System.out.println("\tMartello: " + risorse.get(TipoRisorsa.MARTELLO));
        System.out.println("\tNastro: " + risorse.get(TipoRisorsa.NASTRO));
        System.out.println();
    }
}
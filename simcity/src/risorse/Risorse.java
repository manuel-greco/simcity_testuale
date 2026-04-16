package risorse;

import java.util.HashMap;

public class Risorse {
    private HashMap<TipoRisorsa, Integer> risorse;

    public Risorse() {
        risorse = new HashMap<>();

        // Risorsa principale
        risorse.put(TipoRisorsa.DENARO, 1000);

        // Servizi essenziali
        risorse.put(TipoRisorsa.ENERGIA, 0);
        risorse.put(TipoRisorsa.ACQUA, 0);

        // Popolazione
        risorse.put(TipoRisorsa.POPOLAZIONE, 0);

        // Materiali GREZZI
        risorse.put(TipoRisorsa.LEGNO, 15);
        risorse.put(TipoRisorsa.METALLO, 15);

        // Materiali LAVORATI
        risorse.put(TipoRisorsa.CHIODI, 5);
        risorse.put(TipoRisorsa.ASSI, 5);
        risorse.put(TipoRisorsa.MARTELLO, 0);
        risorse.put(TipoRisorsa.NASTRO, 0);
    }

    public int get(TipoRisorsa tipo) {
        Integer valore = risorse.get(tipo);
        if (valore != null) {
            return valore;
        }
        return 0;
    }

    public boolean consuma(TipoRisorsa tipo, int quantita) {
        Integer valore = risorse.get(tipo);
        if (valore != null && valore >= quantita) {
            risorse.put(tipo, valore - quantita);
            return true;
        }
        return false;
    }

    public void produci(TipoRisorsa tipo, int quantita) {
        Integer valore = risorse.get(tipo);
        if (valore != null) {
            risorse.put(tipo, valore + quantita);
        } else {
            risorse.put(tipo, quantita);
        }
    }

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
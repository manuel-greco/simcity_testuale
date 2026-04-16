package edifici.residenziali;

import risorse.TipoRisorsa;

/**
 * Classe concreta che rappresenta l'edificio "Zona Residenziale".
 * È un edificio residenziale di base che ospita un numero limitato di abitanti.
 */
public class ZonaResidenziale extends EdificioResidenziale {

    /**
     * Costruttore di ZonaResidenziale.
     */
    public ZonaResidenziale() {
        super("Zona Residenziale", 25);
        aggiungiCosto(TipoRisorsa.DENARO, 1200);
        aggiungiCosto(TipoRisorsa.LEGNO, 10);
        aggiungiCosto(TipoRisorsa.METALLO, 5);
        aggiungiCosto(TipoRisorsa.CHIODI, 8);
        aggiungiCosto(TipoRisorsa.ASSI, 4);
    }
}
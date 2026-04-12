package edifici.residenziali;

import risorse.TipoRisorsa;

public class ZonaResidenziale extends EdificioResidenziale {
    /**
     * Costruttore della classe ZonaResidenziale.
     */
    public ZonaResidenziale() {
        super("Zona Residenziale", 1836);
        aggiungiCosto(TipoRisorsa.DENARO, 100);
        aggiungiCosto(TipoRisorsa.LEGNO, 5);
    }
}

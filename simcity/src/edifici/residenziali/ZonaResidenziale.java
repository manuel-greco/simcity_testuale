package edifici.residenziali;

import risorse.TipoRisorsa;

public class ZonaResidenziale extends EdificioResidenziale {

    public ZonaResidenziale() {
        super("Zona Residenziale", 10);
        aggiungiCosto(TipoRisorsa.DENARO, 100);
    }
}
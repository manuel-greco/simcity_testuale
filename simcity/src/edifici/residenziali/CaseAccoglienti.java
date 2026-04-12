package edifici.residenziali;

import risorse.TipoRisorsa;

public class CaseAccoglienti extends EdificioResidenziale {
    /**
     * Costruttore della classe CaseAccoglienti.
     */
    public CaseAccoglienti() {
        super("Case Accoglienti", 1836);
        aggiungiCosto(TipoRisorsa.DENARO, 300);
        aggiungiCosto(TipoRisorsa.LEGNO, 5);
        aggiungiCosto(TipoRisorsa.METALLO, 5);
    }
}

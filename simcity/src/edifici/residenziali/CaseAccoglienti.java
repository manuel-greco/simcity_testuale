package edifici.residenziali;

import risorse.TipoRisorsa;

public class CaseAccoglienti extends EdificioResidenziale {

    public CaseAccoglienti() {
        super("Case Accoglienti", 25);
        aggiungiCosto(TipoRisorsa.DENARO, 175);
    }
}
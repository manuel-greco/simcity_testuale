package edifici.residenziali;

import risorse.TipoRisorsa;

/**
 * Classe concreta che rappresenta l'edificio "Case Accoglienti".
 * È un edificio residenziale più avanzato che ospita più abitanti rispetto alla Zona Residenziale.
 */
public class CaseAccoglienti extends EdificioResidenziale {

    /**
     * Costruttore di CaseAccoglienti.
     */
    public CaseAccoglienti() {
        super("Case Accoglienti", 10);
        aggiungiCosto(TipoRisorsa.DENARO, 500);
        aggiungiCosto(TipoRisorsa.LEGNO, 5);
        aggiungiCosto(TipoRisorsa.CHIODI, 3);
    }
}
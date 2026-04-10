package model;

public class CentroCommerciale extends Edificio {

    public CentroCommerciale() {
        super("Centro Commerciale", 180);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setSoldi(citta.getSoldi() + 20);
    }
}

package model;

public class Fabbrica extends Edificio {

    public Fabbrica() {
        super("Fabbrica", 200);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setSoldi(citta.getSoldi() + 20);
        citta.setInquinamento(citta.getInquinamento() + 2);

    }
}
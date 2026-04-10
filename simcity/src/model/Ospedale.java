package model;

public class Ospedale extends Edificio {

    public Ospedale() {
        super("Ospedale", 250);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setPopolazione(citta.getPopolazione() + 5);
    }
}

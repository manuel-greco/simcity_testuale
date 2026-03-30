package model;

public class Casa extends Edificio {

    public Casa() {
        super("Casa", 100);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setPopolazione(citta.getPopolazione() + 5);
    }
}

package model;

public class Scuola extends Edificio {

    public Scuola() {
        super("Scuola", 150);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setCrescitaGiornaliera(citta.getCrescitaGiornaliera() + 1);
    }
}

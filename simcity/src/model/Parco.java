package model;

public class Parco extends Edificio {

    public Parco() {
        super("Parco", 80);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setFelicita(citta.getFelicita() + 2);
        citta.setInquinamento(citta.getInquinamento() - 1);
    }
}

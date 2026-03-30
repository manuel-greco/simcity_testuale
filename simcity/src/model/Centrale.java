package model;

public class Centrale extends Edificio {

    public Centrale() {
        super("Centrale", 300);
    }

    @Override
    public void effetto(Citta citta) {
        citta.setEnergia(citta.getEnergia() + 30);
    }
}
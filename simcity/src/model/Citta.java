package model;

import java.util.ArrayList;

public class Citta {

    private int popolazione;
    private int soldi;
    private int energia;

    private ArrayList<Edificio> edifici;

    public Citta() {
        this.popolazione = 10;
        this.soldi = 500;
        this.energia = 100;
        this.edifici = new ArrayList<>();
    }

    public void aggiungiEdificio(Edificio e) {
        edifici.add(e);
        soldi -= e.getCosto();
    }

    public void simulaGiorno() {
        for (Edificio e : edifici) {
            e.effetto(this);
        }
        energia -= popolazione * 2;
    }

    // GETTER e SETTER
    public int getPopolazione() { return popolazione; }
    public void setPopolazione(int popolazione) { this.popolazione = popolazione; }

    public int getSoldi() { return soldi; }
    public void setSoldi(int soldi) { this.soldi = soldi; }

    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }

    public ArrayList<Edificio> getEdifici() {
        return edifici;
    }

    @Override
    public String toString() {
        return "\n===== STATO CITTÀ =====\n" +
                "Popolazione: " + popolazione + "\n" +
                "Soldi: " + soldi + "\n" +
                "Energia: " + energia + "\n" +
                "Edifici costruiti: " + edifici.size() + "\n";
    }
}

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
    public int getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        if (popolazione > 500) popolazione = 500;
        if (popolazione < 0) popolazione = 0;
        this.popolazione = popolazione;
    }

    public int getSoldi() {
        return soldi;
    }
    public void setSoldi(int soldi) {
        if (soldi < 0) soldi = 0;
        this.soldi = soldi;
    }

    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        if (energia < 0) energia = 0;
        this.energia = energia;
    }

    public ArrayList<Edificio> getEdifici() {
        return edifici;
    }

    @Override
    public String toString() {
        return "===== STATO CITTÀ =====\n" +
                "Popolazione: " + popolazione + "\n" +
                "Soldi: " + soldi + "\n" +
                "Energia: " + energia + "\n" +
                "Edifici costruiti: " + edifici.size() + "\n";
    }
}

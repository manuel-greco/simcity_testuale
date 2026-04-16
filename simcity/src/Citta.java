import edifici.commerciali.EdificioCommerciale;
import edifici.industriali.EdificioIndustriale;
import edifici.residenziali.EdificioResidenziale;
import risorse.Risorse;

import java.util.ArrayList;

public class Citta {
    private Risorse risorse;
    private ArrayList<EdificioResidenziale> edificiResidenziali;
    private ArrayList<EdificioIndustriale> edificiIndustriali;
    private ArrayList<EdificioCommerciale> edificiCommerciali;

    public Citta() {
        this.risorse = new Risorse();
        this.edificiResidenziali = new ArrayList<>();
        this.edificiIndustriali = new ArrayList<>();
        this.edificiCommerciali = new ArrayList<>();
    }

    /*

    public void aggiungiEdificio(Edificio e) {
        edifici.add(e);
        soldi -= e.getCosto();
    }

    public void simulaGiorno() {
        for (Edificio e : edifici) {
            e.effetto(this);
        }
        energia -= popolazione * 2;
        popolazione += crescitaGiornaliera;
        if (inquinamento > 70) {
            popolazione -= 3;
            felicita -= 2;
        }

        if (inquinamento > 90) {
            popolazione -= 5;
            felicita -= 5;
        }
        if (inquinamento > 70) {
            System.out.println("Inquinamento elevato! La popolazione soffre");
        }

        if (inquinamento > 90) {
            System.out.println("Livelli critici di inquinamento!");
        }

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

    public int getFelicita() {
        return felicita;
    }

    public void setFelicita(int f) {
        felicita = Math.max(0, Math.min(100, f));
    }

    public int getCrescitaGiornaliera() {
        return crescitaGiornaliera;
    }

    public void setCrescitaGiornaliera(int c) {
        crescitaGiornaliera = c;
    }

    public int getInquinamento() {
        return inquinamento;
    }

    public void setInquinamento(int inq) {
        if (inq < 0) inq = 0;
        if (inq > 100) inq = 100;
        this.inquinamento = inq;
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
     */
}

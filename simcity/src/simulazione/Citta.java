package simulazione;

import edifici.Edificio;
import edifici.commerciali.EdificioCommerciale;
import edifici.industriali.EdificioIndustriale;
import edifici.residenziali.EdificioResidenziale;

import java.util.ArrayList;

public class Citta {
    private int denaro;
    private int popolazione;
    private int felicita;
    private int inquinamento;
    private int energia;
    private int acqua;
    private ArrayList<EdificioResidenziale> edificiResidenziali;
    private ArrayList<EdificioIndustriale> edificiIndustriali;
    private ArrayList<EdificioCommerciale> edificiCommerciali;

    public Citta() {
        this.denaro = 2000;
        this.popolazione = 0;
        this.felicita = 50;
        this.inquinamento = 0;
        this.energia = 0;
        this.acqua = 0;
        this.edificiResidenziali = new ArrayList<>();
        this.edificiIndustriali = new ArrayList<>();
        this.edificiCommerciali = new ArrayList<>();
    }

    public void aggiungiEdificioResidenziale(EdificioResidenziale e) {
        if (denaro >= e.getCosto()) {
            edificiResidenziali.add(e);
            denaro -= e.getCosto();
            popolazione += e.getAbitanti();
        } else {
            throw new DenaroInsufficiente("Denaro Insufficiente!");
        }
    }

    public void aggiungiEdificioIndustriale(EdificioIndustriale e) {
        if (denaro >= e.getCosto()) {
            edificiIndustriali.add(e);
            denaro -= e.getCosto();
            inquinamento += e.getInquinamento();
            energia -= e.getConsumoEnergia();
        } else {
            throw new DenaroInsufficiente("Denaro Insufficiente!");
        }
    }

    public void aggiungiEdificioCommerciale(EdificioCommerciale ec) {
        if (denaro >= ec.getCosto()) {
            edificiCommerciali.add(ec);
            denaro -= ec.getCosto();
            felicita += ec.getFelicita();
        } else {
            throw new DenaroInsufficiente("Denaro Insufficiente!");
        }
    }

    public void mostraCitta() {
        System.out.println("\n============ Edifici Città ============");

        ordinaPerCosto(edificiResidenziali);
        System.out.println("\n--- Edifici Residenziali ---");
        if (edificiResidenziali.isEmpty()) {
            System.out.println("Nessun edificio residenziale");
        } else {
            for (EdificioResidenziale er : edificiResidenziali) {
                System.out.println("- " + er.toString());
            }
        }

        ordinaPerCosto(edificiIndustriali);
        System.out.println("\n--- Edifici Industriali ---");
        if (edificiIndustriali.isEmpty()) {
            System.out.println("Nessun edificio industriale");
        } else {
            for (EdificioIndustriale ei : edificiIndustriali) {
                System.out.println("- " + ei.toString());
            }
        }

        ordinaPerCosto(edificiCommerciali);
        System.out.println("\n--- Edifici Commerciali ---");
        if (edificiCommerciali.isEmpty()) {
            System.out.println("Nessun edificio commerciale");
        } else {
            for (EdificioCommerciale ec : edificiCommerciali) {
                System.out.println("- " + ec.toString());
            }
        }
    }

    public void controlliGiornata() {
        int guadagnoTotale = 0;
        for (EdificioCommerciale ec : edificiCommerciali) {
            guadagnoTotale += ec.getGuadagnoGiornaliero();
        }
        denaro += guadagnoTotale;


        if (inquinamento > 75) {
            throw new InquinamentoEccessivo("Inquinamento città eccessivo!");
        }

        if (felicita > 100) felicita = 100;

        if (felicita < 40) throw new FelicitaBassa("Felicità abitanti bassa!");

        if (energia < 0) throw new EnergiaInsufficiente("Energia Insufficiente!");
        if (acqua < 0) throw new EnergiaInsufficiente("Energia Insufficiente!");
    }

    // getter
    public int getDenaro() {
        return denaro;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public int getFelicita() {
        return felicita;
    }

    public int getInquinamento() {
        return inquinamento;
    }

    public int getEnergia() {
        return energia;
    }

    public int getAcqua() {
        return acqua;
    }

    public ArrayList<EdificioResidenziale> getEdificiResidenziali() {
        return edificiResidenziali;
    }

    public ArrayList<EdificioIndustriale> getEdificiIndustriali() {
        return edificiIndustriali;
    }

    public ArrayList<EdificioCommerciale> getEdificiCommerciali() {
        return edificiCommerciali;
    }

    // metodi privati
    private <T extends Edificio> void ordinaPerCosto(ArrayList<T> edifici) {
        for (int i = 0; i < edifici.size() - 1; i++) {
            for (int j = i + 1; j < edifici.size(); j++) {
                if (edifici.get(i).getCosto() > edifici.get(j).getCosto()) {
                    T scambio = edifici.get(i);
                    edifici.set(i, edifici.get(j));
                    edifici.set(j, scambio);
                }
            }
        }
    }
}
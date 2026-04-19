package simulazione;

import edifici.commerciali.*;
import edifici.industriali.*;
import edifici.residenziali.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulatore {
    Scanner sc = new Scanner(System.in);

    private Citta citta;
    public Simulatore() {
        citta = new Citta();
    }

    // metodi protected
    protected void menuPrincipale(){
        System.out.println("\n============ Menu Principale =============");
        System.out.println("0. Esci");
        System.out.println("1. Costruisci");
        System.out.println("2. Mostra città");
        System.out.println("3. Mostra statistiche città");
        System.out.println("4. Simula giorno");
        System.out.print("Inserisci la tua scelta: ");
    }

    protected void menuEdifici() {
        System.out.println("\n============== Menu Edifici ==============");
        System.out.println("1. Costruisci edificio residenziale");
        System.out.println("2. Costruisci edificio industriale");
        System.out.println("3. Costruisci edificio commerciale");
        System.out.print("Costruisci: ");
    }

    protected void opzioneCostruisci() {
        int scelta = 0;
        try {
            scelta = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Errore! Input non valido!");
            sc.nextLine();
        }
        switch (scelta) {
            case 1:
                menuEdificiResidenziali();
                try {
                    scelta = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Errore! Input non valido!");
                    sc.nextLine();
                }
                EdificioResidenziale er;
                switch (scelta) {
                    case 1:
                        er = new ZonaResidenziale();
                        break;
                    case 2:
                        er = new CaseAccoglienti();
                        break;
                    default:
                        System.out.println("Opzione non valida!");
                        return;
                }
                try {
                    citta.aggiungiEdificioResidenziale(er);
                } catch (DenaroInsufficiente e) {
                    System.out.println("Edificio non costruito! " + e);
                }
                break;
            case 2:
                menuEdificiIndustriali();
                try {
                    scelta = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Errore! Input non valido!");
                    sc.nextLine();
                }
                EdificioIndustriale ei;
                switch (scelta) {
                    case 1:
                        ei = new FabbricaPiccola();
                        break;
                    case 2:
                        ei = new FabbricaBase();
                        break;
                    default:
                        System.out.println("Opzione non valida!");
                        return;
                }
                try {
                    citta.aggiungiEdificioIndustriale(ei);
                } catch (DenaroInsufficiente e) {
                    System.out.println("Edificio non costruito! " + e);
                }
                break;
            case 3:
                menuEdificiCommerciali();
                try {
                    scelta = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Errore! Input non valido!");
                    sc.nextLine();
                }
                EdificioCommerciale ec;
                switch (scelta) {
                    case 1:
                        ec = new NegozioMaterialiDaCostruzione();
                        break;
                    case 2:
                        ec = new NegozioDiFerramenta();
                        break;
                    default:
                        System.out.println("Opzione non valida!");
                        return;
                }
                try {
                    citta.aggiungiEdificioCommerciale(ec);
                } catch (DenaroInsufficiente e) {
                    System.out.println("Edificio non costruito! " + e);
                }
                break;
        }
    }

    protected void mostraCitta() {
        citta.mostraCitta();
    }

    protected void opzioneStatistiche() {
        mostraStatisticheBase();
        System.out.println("0. Esci | 1. Statistiche avanzate");
        int scelta = -1;
        do {
            try {
                System.out.println("Scelta: ");
                scelta = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Errore! Input non valido!");
                sc.nextLine();
            }
        } while (scelta != 0 && scelta != 1);
        if (scelta == 0) return;
        mostraStatisticheAvanzate();
    }

    protected void simulaGiorno() {
        try {
            citta.controlliGiornata();
        } catch (InquinamentoEccessivo e) {
            System.out.println("Felicità abitanti a rischio! " + e);
        } catch (FelicitaBassa e) {
            System.out.println("Gli abitanti stanno scappando! " + e);
        } catch (EnergiaInsufficiente e) {
            System.out.println("Fabbriche a rischio! " + e);
        } catch (AcquaInsufficiente e) {
            System.out.println("Abitazioni a rischio! " + e);
        }
    }

    // metodi privati
    private void menuEdificiResidenziali() {
        System.out.println("_____----==] Edifici Residenziali [==----_____");
        System.out.println("1. Zona Residenziale (-300$, +20 ab.)");
        System.out.println("2. Case Accoglienti (-500$, +35 ab.)");
        System.out.print("Costruisci: ");
    }

    private void menuEdificiIndustriali() {
        System.out.println("_____----==] Edifici Industriali [==----_____");
        System.out.println("1. Fabbrica Piccola (-500$, +10 inq., +5 en.)");
        System.out.println("2. Fabbrica Base (-800$, +15 inq., +8 en.)");
        System.out.print("Costruisci: ");
    }

    private void menuEdificiCommerciali() {
        System.out.println("_____----==] Edifici Commerciali [==----_____");
        System.out.println("1. Neg. Materiali da Costruzione (-600$, +50$/d, +5 fel.)");
        System.out.println("2. Neg. Ferramenta (-700$, +60$/d, +8 fel.)");
        System.out.print("Costruisci: ");
    }

    private void mostraStatisticheBase() {
        System.out.println("\n========== Statistiche Base ==========");
        System.out.println("Denaro: " + citta.getDenaro());
        System.out.println("Popolazione: " + citta.getPopolazione());
        System.out.println("Felicità: " + citta.getFelicita() + "%");
        System.out.println("Inquinamento: " + citta.getInquinamento());
        System.out.println("Energia: " + citta.getEnergia());
        System.out.println("Acqua: " + citta.getAcqua());
    }

    private void mostraStatisticheAvanzate(){
        System.out.println("\n========== Statistiche Avanzate ==========");
    }
}

    /*
    private void mostraMenu(){
        System.out.println("===== SIM CITY =====");

        System.out.println("2. Visualizza città");

        System.out.println("4. Mostra edifici");
        System.out.println("5. Mostra statistiche avanzate");
        System.out.println("6. Ordina edifici per costo");
        System.out.println("7. Ordina edifici per tipo");
        System.out.println("8. Mostra qualità dell’aria");

    }

    private void ordinaPercosto(){
        ArrayList<Edificio> lista = citta.getEdifici();

        for (int i = 0; i < lista.size() -1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getCosto() > lista.get(j).getCosto()){
                    Edificio scambio = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, scambio);
                }

            }
        }
        System.out.println("Edifici ordinati per costo!");
    }

    private int valoreTipo(Edificio e) {
        if (e instanceof Casa) return 1;
        if (e instanceof Fabbrica) return 2;
        return 3;
    }

    private void ordinaPerTipo() {
        ArrayList<Edificio> lista = citta.getEdifici();

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (valoreTipo(lista.get(i)) > valoreTipo(lista.get(j))) {
                    Edificio temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        System.out.println("Edifici ordinati per tipo!");
    }

    private void mostraQualitaAria() {
        int inq = citta.getInquinamento();

        System.out.println("--- Qualità dell'aria ---");
        System.out.println("Inquinamento: " + inq + "/100");

        if (inq < 30) System.out.println("Aria pulita");
        else if (inq < 60) System.out.println("Qualità accettabile");
        else if (inq < 80) System.out.println("Aria inquinata");
        else System.out.println("Aria pericolosa!");
    }
     */
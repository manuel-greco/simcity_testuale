package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulatore {

    private Citta citta;
    private Scanner scanner;

    public Simulatore() {
        citta = new Citta();
        scanner = new Scanner(System.in);
    }

    public void avvia() {

        int scelta = -1;

        while (scelta != 0) {

            clear();
            mostraMenu();

            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input non valido!");
                continue;
            }

            switch (scelta) {
                case 1:
                    costruisciEdificio();
                    break;

                case 2:
                    System.out.println(citta);
                    break;

                case 3:
                    citta.simulaGiorno();
                    System.out.println("➡️ Giorno simulato!");
                    break;

                case 4:
                    mostraEdifici();
                    break;

                case 5:
                    mostraStatisticheAvanzate();
                    break;

                case 6:
                    ordinaPercosto();
                    break;

                case 7:
                    ordinaPerTipo();
                    break;

                case 0:
                    System.out.println("👋 Uscita dal gioco...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private void clear()  { for (int i = 0; i < 10; i++) System.out.println(); }

    private void mostraMenu(){
        System.out.println("===== SIM CITY =====");
        System.out.println("1. Costruisci edificio");
        System.out.println("2. Visualizza città");
        System.out.println("3. Simula giorno");
        System.out.println("4. Mostra edifici");
        System.out.println("5. Mostra statistiche avanzate");
        System.out.println("6. Ordina edifici per costo");
        System.out.println("7. Ordina edifici per tipo");
        System.out.println("0. Esci");
        System.out.println("Inserisci la tua scelta: ");
    }

    private void costruisciEdificio(){
        System.out.println("--- Costruisci Edificio ---");
        System.out.println("1. Costruisci casa (100$)");
        System.out.println("2. Costruisci Fabbrica (200$)");
        System.out.println("3. Costruisci Centrale (300$)");
        System.out.println("Inserisci la tua scelta: ");

        int scelta;

        try {
            scelta = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Input inserito non valido");
            return;
        }

        Edificio edificio = switch (scelta){
            case 1 -> new Casa();
            case 2 -> new Fabbrica();
            case 3 -> new Centrale();
            default -> null;
        };

        if (edificio == null){
            System.out.println("Scelta non valida!");
            return;
        }

        if (citta.getEnergia() < 10) {
            System.out.println("⚠Non hai abbastanza energia per costruire!");
            return;
        }

        if (citta.getEdifici().size() >= 50) {
            System.out.println("Hai raggiunto il numero massimo di edifici!");
            return;
        }

        if (citta.getSoldi() < edificio.getCosto()){
            System.out.println("Non hai abbastanza soldi");
            return;
        }
        citta.aggiungiEdificio(edificio);
        System.out.println("Hai costruito: "+edificio.getNome());
    }

    private void simulaGiorno(){
        citta.simulaGiorno();
        System.out.println("Giorno simulato!");

        if (citta.getEnergia() < 0){
            System.out.println("Energia insufficiente, diminuisce la popolazione!");
        }
    }

    private void mostraEdifici(){
        System.out.println("--- Edifici Costruiti ---");

        if (citta.getEdifici().isEmpty()){
            System.out.println("Nessun edificio presente!");
            return;
        }

        int i = 1;
        for (Edificio e : citta.getEdifici()){
            System.out.println(i +". " + e.getNome() + " Costo: " + e.getCosto() + i++);
        }
    }

    private void mostraStatisticheAvanzate(){
        System.out.println("--- Statistiche Avanzate ---");
        int caseCount = 0;
        int fabbricheCount = 0;
        int centraleCount = 0;

        for (Edificio e : citta.getEdifici()){
            if (e instanceof Casa) caseCount++;
            else if (e instanceof Fabbrica) fabbricheCount++;
            else if (e instanceof Centrale) centraleCount++;
        }

        System.out.println("Case: "+caseCount);
        System.out.println("Fabbriche: "+fabbricheCount);
        System.out.println("Centrali: "+centraleCount);

        String comune = "Nessuno";

        if (!citta.getEdifici().isEmpty()){
            if (caseCount >= fabbricheCount && caseCount >= centraleCount){
                comune = "Casa";
            } else if (fabbricheCount >= caseCount && fabbricheCount >= centraleCount) {
                comune = "Fabbrica";
            } else {
                comune = "Centrale";
            }
        }
        System.out.println("Edificio più comune: " + comune);
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



}
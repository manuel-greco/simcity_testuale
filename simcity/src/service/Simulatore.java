package service;

import model.*;
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

                case 0:
                    System.out.println("👋 Uscita dal gioco...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private void clear()  { for (int i = 0; i < 40; i++) System.out.println(); }

    private void mostraMenu(){
        System.out.println("===== SIM CITY =====");
        System.out.println("1. Costruisci edificio");
        System.out.println("2. Visualizza città");
        System.out.println("3. Simula giorno");
        System.out.println("4. Mostra edifici");
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
}
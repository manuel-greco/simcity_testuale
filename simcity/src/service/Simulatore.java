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

    private void mostraMenu() {
        System.out.println("\n===== SIM CITY =====");
        System.out.println("1. Costruisci edificio");
        System.out.println("2. Visualizza città");
        System.out.println("3. Simula giorno");
        System.out.println("4. Mostra edifici");
        System.out.println("0. Esci");
        System.out.print("Scelta: ");
    }

    private void costruisciEdificio() {
        System.out.println("\n--- COSTRUISCI EDIFICIO ---");
        System.out.println("1. Casa (100$)");
        System.out.println("2. Fabbrica (200$)");
        System.out.println("3. Centrale (300$)");
        System.out.print("Scelta: ");

        int scelta = 0;

        try {
            scelta = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input non valido!");
            return;
        }

        Edificio edificio = null;

        switch (scelta) {
            case 1: edificio = new Casa(); break;
            case 2: edificio = new Fabbrica(); break;
            case 3: edificio = new Centrale(); break;
            default:
                System.out.println("Scelta non valida!");
                return;
        }

        if (citta.getSoldi() < edificio.getCosto()) {
            System.out.println("❌ Non hai abbastanza soldi!");
            return;
        }

        citta.aggiungiEdificio(edificio);
        System.out.println("🏗️ Hai costruito: " + edificio.getNome());
    }

    private void mostraEdifici() {
        System.out.println("\n--- EDIFICI COSTRUITI ---");

        if (citta.getEdifici().isEmpty()) {
            System.out.println("Nessun edificio presente!");
            return;
        }

        int i = 1;
        for (Edificio e : citta.getEdifici()) {
            System.out.println(i + ". " + e.getNome());
            i++;
        }
    }
}
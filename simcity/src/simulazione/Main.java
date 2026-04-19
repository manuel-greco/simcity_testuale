package simulazione;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Simulatore s = new Simulatore();

        System.out.println("========== Benvenuto su SimCity ==========");
        int scelta = -1;
        while (scelta != 0) {
            s.menuPrincipale();
            try {
                scelta = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Errore! Input non valido!");
                sc.nextLine();
                continue;
            }
            switch (scelta) {
                case 0:
                    break;
                case 1:
                    s.menuEdifici();
                    s.opzioneCostruisci();
                    break;
            case 2:
                s.mostraCitta();
                break;
            case 3:
                s.opzioneStatistiche();
                break;
            case 4:
                s.simulaGiorno();
                break;
            default:
                System.out.println("Scelta non valida!");
                break;
            }
        }


    }
}
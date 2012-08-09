package projekti;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Lauta omaLauta = new Lauta();
        omaLauta.resetoiLauta();
        omaLauta.piirraLauta();
        Scanner lukija = new Scanner(System.in);
        String syote = lukija.nextLine();
        if (tarkista(syote) == true) {
            siirra(syote);
        }
    }

    private static boolean tarkista(String syote) {
        
        return true;
    }

    private static void siirra(String syote) {
        ;
    }
}

package projekti;

import java.util.Scanner;

public class Peli {

    public void Peli() {
        Lauta omaLauta = new Lauta();
        omaLauta.tyhjennaLauta();
        omaLauta.asetaNappulat();
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
    }
}

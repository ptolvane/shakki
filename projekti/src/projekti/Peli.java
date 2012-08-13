package projekti;

import java.util.Scanner;

public class Peli {

    /** Kyseisen pelin Lauta-olio */
    Lauta omaLauta;
    /** Pitää kirjaa montako siirtoa pelissä on tehty */
    int moneskoSiirto = 0;
    Scanner lukija = new Scanner(System.in);

    public Peli() {
        omaLauta = new Lauta();
        omaLauta.tyhjennaLauta();
        omaLauta.asetaNappulat();
        while (true) {
            siirto();
        }
    }

    /** Lukee pelaajan antaman syötteen ja jos kyseessä on komento,
     * suorittaa komennon.
     * Muutoin tarkistaa onko siirto laillinen ja tekee siirron */
    private void siirto() {
        String syote = lukija.nextLine();
        if (tarkistaKomento(syote) == true) {
            suoritaKomento(syote);
        } else if (tarkistaSiirto(syote) == true) {
            suoritaSiirto(syote);
        }
        omaLauta.piirraLauta();
        System.out.println(moneskoSiirto);
        moneskoSiirto++;
    }

    /** Tarkistaa, onko käyttäjän antama siirto laillinen
    @param siirto käyttäjän antama siirto
    @return       Onko siirto laillinen (true/false) */
    private static boolean tarkistaSiirto(String siirto) {
        return true;
    }

    private static boolean tarkistaKomento(String komento) {
        if (komento.equalsIgnoreCase("q") || komento.equalsIgnoreCase("l") || komento.equalsIgnoreCase("s")) {
            return true;
        } else {
            return false;
        }
    }

    /** Siirtää käyttäjän antaman siirron
    @param siirto käyttäjän antama syote */
    private static void suoritaSiirto(String siirto) {
    }

    /** Suorittaa käyttäjän antaman komennon
    @param komento käyttäjän antama syote */
    private static void suoritaKomento(String komento) {
        if (komento.equalsIgnoreCase("q")) {
            return;
        } else if (komento.equalsIgnoreCase("l")) {
        } else if (komento.equalsIgnoreCase("s")) {
        }
    }
}

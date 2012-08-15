package projekti;

import java.util.Scanner;

public class Peli {

    /** Kyseisen pelin Lauta-olio */
    Lauta omaLauta;
    /** Pitää kirjaa siitä montako siirtoa pelissä on tehty */
    int moneskoSiirto;
    /** Pitää kirjaa siitä kenen vuoro on */
    Pelaaja kenenVuoro;
    /** Lukee käyttäjän antaman syötteen */
    Scanner lukija;

    public Peli() {
        lukija = new Scanner(System.in);
        moneskoSiirto = 0;
    }

    /** Lukee pelaajan antaman syötteen ja jos kyseessä on komento,
     * suorittaa komennon.
     * Muutoin tarkistaa onko siirto laillinen ja tekee siirron */
    public void lueSyote() {
        while (true) {
            String syote = lukija.nextLine();
            if (tarkistaKomento(syote) == true) {
                suoritaKomento(syote);              // tämä ei selvästikään vielä toimi
            } else if (tarkistaSiirto(syote) == true) {
                kenenVuoro.teeSiirto(syote);
                break;
            }
        }
        omaLauta.piirraLauta();
        System.out.println(moneskoSiirto);
        moneskoSiirto++;
    }

    /** Tarkistaa onko käyttäjän antama siirto laillinen
     * @param siirto käyttäjän antama siirto
     * @return       Onko siirto laillinen (t/f)
     */
    private boolean tarkistaSiirto(String siirto) {
        return true;
    }

    /** Tarkistaa onko käyttäjän antama syöte komento
     * @param komento käyttäjän antama syöte
     * @return        Onko syöte komento (t/f)
     */
    private static boolean tarkistaKomento(String komento) {
        if (komento.equalsIgnoreCase("q") || komento.equalsIgnoreCase("l") || komento.equalsIgnoreCase("s")) {
            return true;
        } else {
            return false;
        }
    }

    /** Suorittaa käyttäjän antaman komennon.
    @param komento käyttäjän antama syote */
    private static void suoritaKomento(String komento) {
        if (komento.equalsIgnoreCase("q")) {
            System.exit(0);
        } else if (komento.equalsIgnoreCase("l")) {
        } else if (komento.equalsIgnoreCase("s")) {
        } else {
            return;
        }
    }

    /** Aloittaa kahden pelaajan shakkipelin */
    void aloitaPeli() {
        omaLauta = new Lauta();
        omaLauta.tyhjennaLauta();
        omaLauta.asetaNappulat();
        omaLauta.piirraLauta();
        Pelaaja musta = new Pelaaja("musta", omaLauta);
        Pelaaja valkoinen = new Pelaaja("valkoinen", omaLauta);
        kenenVuoro = valkoinen;
        valkoinen.sunVuoro(this, musta);
    }
}

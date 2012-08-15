package projekti;

import java.util.Scanner;

public class Peli {

    /** Kyseisen pelin Lauta-olio */
    Lauta omaLauta;
    /** Pitää kirjaa siitä montako siirtoa pelissä on tehty */
    int moneskoSiirto = 0;
    /** Pitää kirjaa siitä kenen vuoro on */
    Pelaaja kenenVuoro;
    /** Lukee käyttäjän antaman syötteen */
    Scanner lukija = new Scanner(System.in);

    public Peli() {
    }

    /** Lukee pelaajan antaman syötteen ja jos kyseessä on komento,
     * suorittaa komennon.
     * Muutoin tarkistaa onko siirto laillinen ja tekee siirron */
    public void lueSyote() {
        String syote = lukija.nextLine();
        if (tarkistaKomento(syote) == true) {
            suoritaKomento(syote);
        } else if (tarkistaSiirto(syote) == true) {
            kenenVuoro.siirra();
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

    /** Suorittaa käyttäjän antaman komennon
    @param komento käyttäjän antama syote */
    private static void suoritaKomento(String komento) {
        if (komento.equalsIgnoreCase("q")) {
        } else if (komento.equalsIgnoreCase("l")) {
        } else if (komento.equalsIgnoreCase("s")) {
        }
    }

    /** Aloittaa kahden pelaajan shakkipelin */
    void pelaa() {
        omaLauta = new Lauta();
        omaLauta.tyhjennaLauta();
        omaLauta.asetaNappulat();
        omaLauta.piirraLauta();
        Pelaaja musta = new Pelaaja("musta");
        Pelaaja valkoinen = new Pelaaja("valkoinen");
        valkoinen.sunVuoro(this, musta);
    }
}

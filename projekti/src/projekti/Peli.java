package projekti;

import java.util.Scanner;

/** Pelaa shakkipeliä */
public class Peli {

    /** Kyseisen pelin Lauta-olio */
    Lauta pelilauta;
    /** Kyseisen pelin Piirtaja-olio */
    Piirtaja piirtaja;
    /** Kyseisen pelin Tarkistaja-olio */
    Tarkistaja tarkistaja;
    /** Pitää kirjaa siitä montako siirtoa pelissä on tehty */
    int moneskoSiirto;
    /** Pitää kirjaa siitä kenen vuoro on */
    char kummanVuoro;
    /** Lukee käyttäjän antaman syötteen */
    Scanner lukija;
    /** Pelin graafinen piirtäjä */
    GraafinenPiirtaja graafinenPiirtaja;

    /** Konstruktori luo Scanner-olion, Lauta-olion, Tarkistaja-olion, Piirtaja-olion ja GraafinenPiirtaja-olion ja asettaa siirtolaskurin nollaan.
     */
    public Peli() {
        lukija = new Scanner(System.in);
        moneskoSiirto = 0;
        pelilauta = new Lauta();
        tarkistaja = new Tarkistaja(pelilauta, this);
        piirtaja = new Piirtaja(pelilauta);
        graafinenPiirtaja = new GraafinenPiirtaja(pelilauta);
        kummanVuoro = 'v';
    }

    /** Muuntaa käyttäjältä luetun String-muotoisen syötteen int-taulukoksi, josta siirto on helpommin luettavissa.
     * @param siirto käyttäjän antama syöte
     * @return       Siirto nelipaikkaisena int-taulukkona
     */
    protected int[] muunnaSiirto(String siirto) {
        String[] jaettuSiirto = siirto.split(" ", 2);
        int[] muunnettuSiirto = {0, 0, 0, 0};
        muunnettuSiirto[0] = Character.getNumericValue(jaettuSiirto[0].charAt(0)) - 10;
        muunnettuSiirto[1] = Character.getNumericValue(jaettuSiirto[0].charAt(1)) - 1;
        muunnettuSiirto[2] = Character.getNumericValue(jaettuSiirto[1].charAt(0)) - 10;
        muunnettuSiirto[3] = Character.getNumericValue(jaettuSiirto[1].charAt(1)) - 1;
        return muunnettuSiirto;
    }

    /** Tarkistaa onko käyttäjän antama syöte komento
     * @param komento käyttäjän antama syöte
     * @return        Onko syöte komento (true/false)
     */
    protected static boolean tarkistaKomento(String komento) {
        if (komento.equalsIgnoreCase("q")) {
            return true;
        } else {
            return false;
        }
    }

    /** Suorittaa käyttäjän antaman komennon
    @param komento käyttäjän antama komento */
    protected static void suoritaKomento(String komento) {
        if (komento.equalsIgnoreCase("q")) {
            System.exit(0);
        } else {
            return;
        }
    }

    /** Suorittaa käyttäjän antaman siirron
    @param siirto käyttäjän antama syote */
    protected void teeSiirto(String siirto) {
        String[] jaettuSiirto = siirto.split(" ", 2);
        char sijoitettava = pelilauta.getRuutu(Character.getNumericValue(jaettuSiirto[0].charAt(1)) - 1, Character.getNumericValue(jaettuSiirto[0].charAt(0)) - 10);
        pelilauta.setRuutu(Character.getNumericValue(jaettuSiirto[0].charAt(1)) - 1, Character.getNumericValue(jaettuSiirto[0].charAt(0)) - 10, '\u0000');
        pelilauta.setRuutu(Character.getNumericValue(jaettuSiirto[1].charAt(1)) - 1, Character.getNumericValue(jaettuSiirto[1].charAt(0)) - 10, sijoitettava);
    }

    public char getVuoro(){
        return kummanVuoro;
    }

    public void setVuoro(char vuoro){
        if (vuoro =='v' || vuoro =='m'){
            kummanVuoro = vuoro;
        }
    }

    /** Aloittaa kahden pelaajan shakkipelin */
    public void pelaa() {
        while (true) {
            piirtaja.piirraLauta();
//            graafinenPiirtaja.piirraLauta();
            pelilauta.siivoaKaksoisaskeltaulukko();
            String syote = lukija.nextLine();
            if (tarkistaKomento(syote) == true) {
                suoritaKomento(syote);              // tämä ei selvästikään vielä toimi
            } else if (tarkistaja.tarkistaSiirto(muunnaSiirto(syote)) == true) {
                System.out.println("tehdään siirto");
                moneskoSiirto++;
                teeSiirto(syote);
                if (kummanVuoro == 'v') {
                    kummanVuoro = 'm';
                } else if (kummanVuoro == 'm') {
                    kummanVuoro = 'v';
                } else {
                    System.out.println("ei ole kummankaan vuoro");
                }
            }
        }
    }
}

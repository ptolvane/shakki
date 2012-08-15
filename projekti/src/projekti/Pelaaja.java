package projekti;

public class Pelaaja {

    /** Pelilauta, jolla pelaaja pelaa */
    Lauta omaLauta;
    /** Pelaajan nimi */
    String nimi;

    public Pelaaja(String nimi, Lauta omaLauta) {
        this.nimi = nimi;
        this.omaLauta = omaLauta;
    }

    /** Metodin avulla Pelaaja-oliota pyydetään
     * pelaamaan vuoro ja siirtämään vuoro seuraavalle.
     * @param tamaPeli kyseinen peli
     * @param seuraava seuraava pelaaja */
    void sunVuoro(Peli tamaPeli, Pelaaja seuraava) {
        pyydaSiirto(tamaPeli);
        seuraava.sunVuoro(tamaPeli, this);
    }

    /** Pyytää Peli-oliolta validin siirron */
    private void pyydaSiirto(Peli tamaPeli) {
        tamaPeli.lueSyote();
    }

    /** Siirtää käyttäjän antaman siirron
    @param siirto käyttäjän antama syote */
    public void teeSiirto(String siirto) {
        String[] jaettuSiirto = siirto.split(" ", 2);
        System.out.println(Character.getNumericValue(jaettuSiirto[0].charAt(0))-10);
        System.out.println(Character.getNumericValue(jaettuSiirto[0].charAt(1))-10);
        omaLauta.setRuutu(Character.getNumericValue(jaettuSiirto[0].charAt(1))-1, Character.getNumericValue(jaettuSiirto[0].charAt(0))-10, '\u0000');
        omaLauta.setRuutu(Character.getNumericValue(jaettuSiirto[1].charAt(1))-1, Character.getNumericValue(jaettuSiirto[1].charAt(0))-10, 'P');
    }
}

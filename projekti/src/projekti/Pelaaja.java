
package projekti;

public class Pelaaja {

    /** Pelaajan nimi */
    String nimi;

    public Pelaaja(String nimi){
        this.nimi = nimi;
    }

    /** Metodin avulla Pelaaja-oliota pyydetään
     * pelaamaan vuoro ja siirtämään vuoro seuraavalle.
     * @param tamaPeli kyseinen peli
     * @param seuraava seuraava pelaaja */
    void sunVuoro(Peli tamaPeli, Pelaaja seuraava){
        pyydaSiirto(tamaPeli);
        seuraava.sunVuoro(tamaPeli, this);
    }

    /** Pyytää Peli-oliolta validin siirron */
    private void pyydaSiirto(Peli tamaPeli){
        tamaPeli.lueSyote();
    }

    /** Siirtää käyttäjän antaman siirron
    @param siirto käyttäjän antama syote */
    public void teeSiirto(String siirto) {
    }

}

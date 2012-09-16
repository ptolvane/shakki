package projekti;

/** Tarkistaa annetun siirron oikeellisuutta */
public class Tarkistaja {

    /** Lauta-olio, jolla tehtäviä siirtoja kyseinen Tarkistaja-olio tarkistaa */
    Lauta pelilauta;
    /** Tarkistajaan liittyvä Peli-olio */
    Peli peli;

    /** Konstruktori asettaa pelin ja pelilaudan
     * @param pelilauta pelin pelilauta
     * @param peli      pelattava peli
     */
    Tarkistaja(Lauta pelilauta, Peli peli) {
        this.pelilauta = pelilauta;
        this.peli = peli;
    }

    /** Tarkistaa onko käyttäjän antama siirto laillinen
     * @param siirto käyttäjän antama siirto
     * @return       Onko siirto laillinen (true/false)
     */
    public boolean tarkistaSiirto(int[] siirto) {
        if (siirtaakoOmaaNappulaa(siirto) && pysyykoLaudalla(siirto) && liikkuukoOikein(siirto)
                && !siirtyykoSamaanPaikkaan(siirto) && !lyokoOmaaNappulaa(siirto)) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa yrittääkö pelaaja siirtää vuorossa olevan puolen nappulaa
     * @param siirto käyttäjän antama siirto
     * @return       siirtääkö vuorossa olevaa nappulaa (true/false)
     */
    protected boolean siirtaakoOmaaNappulaa(int[] siirto) {
        if ((peli.kummanVuoro == 'm' && Character.isLowerCase(pelilauta.getRuutu(siirto[1], siirto[0])))
                || (peli.kummanVuoro == 'v' && Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0])))) {
            return true;
        } else {
            return false;
        }
    }

    /** Tunnistaa nappulan tyypin ja tarkistaa sille kuuluvan metodin avulla onko siirto nappulalle kuuluvan siirtosääntöjen mukainen
     * @param siirto käyttäjän antama siirto
     * @return       onko siirto sallittu (true/false)
     */
    protected boolean liikkuukoOikein(int[] siirto) {
        char nappula = pelilauta.getRuutu(siirto[1], siirto[0]);
        if (nappula == 'T' || nappula == 't') {
            return tarkistaTorni(siirto);
        } else if (nappula == 'R' || nappula == 'r') {
            return tarkistaRatsu(siirto);
        } else if (nappula == 'L' || nappula == 'l') {
            return tarkistaLahetti(siirto);
        } else if (nappula == 'D' || nappula == 'd') {
            return tarkistaDaami(siirto);
        } else if (nappula == 'K' || nappula == 'k') {
            return tarkistaKuningas(siirto);
        } else if (nappula == 'P' || nappula == 'p') {
            return tarkistaMoukka(siirto);
        } else {
            System.out.println("nyt meni pieleen, yritit siirtää nappulaa: " + nappula);
            return false;
        }
    }

    /** Tarkistaa onko kyseessä lyönti eli onko nappulaa ruudussa, johon liikutaan
     * @param jaettuSiirto siirto String-taulukkona
     * @return             onko lyönti
     */
    protected boolean onkoLyonti(int[] siirto) {
        if (pelilauta.getRuutu(siirto[3], siirto[2]) != '\u0000') {
            return true;
        } else {
            return false;
        }
    }

    // jäi kesken
    protected boolean onkoTornitus(int[] siirto) {
        if (siirto[0] == siirto[2]
                && pelilauta.getRuutu(siirto[1], siirto[0]) == pelilauta.onkoRuutuunTultuKaksoisaskeleella[1][0]) {
            return true;
        } else {
            return false;
        }
    }

    // jäi kesken
    protected boolean hyppaakoNappulanYli(int[] siirto) {
        if (siirto[0] != siirto[2] && siirto[1] != siirto[3]) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa yritetäänkö siirrolla siirtyä samaan paikkaan, ts yritetään olla siirtämättä
     * @param siirto käyttäjän antama siirto
     * @return       yritetäänkö siirtää lähtöpaikkaan (true/false)
     */
    protected boolean siirtyykoSamaanPaikkaan(int[] siirto) {
        if (siirto[0] == siirto[2] && siirto[1] == siirto[3]) {
            System.out.println("Yritit siirtää nappulan lähtöruutuun");
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa pysyykö nappula laudalla, vai yritetäänkö sillä liikkua ulos laudalta
     * @param siirto käyttäjän antama siirto
     * @return       pysyykö laudalla (true/false)
     */
    protected boolean pysyykoLaudalla(int[] siirto) {
        if (siirto[0] < 8 && siirto[0] >= 0 && siirto[1] >= 0 && siirto[1] < 8 && siirto[2] >= 0
                && siirto[2] < 8 && siirto[3] >= 0 && siirto[3] < 8) {
            return true;
        } else {
            System.out.println("Nappula ei pysy laudalla");
            return false;
        }
    }

    /** Tarkistaa yritetäänkö siirrolla lyödä omaa nappulaa
     * @param siirto käyttäjän antama siirto
     * @return       lyödäänkö omaa nappulaa (true/false)
     */
    protected boolean lyokoOmaaNappulaa(int[] siirto) {
        if ((Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0]))
                && Character.isUpperCase(pelilauta.getRuutu(siirto[3], siirto[2])))
                || (Character.isLowerCase(pelilauta.getRuutu(siirto[1], siirto[0]))
                && Character.isLowerCase(pelilauta.getRuutu(siirto[3], siirto[2])))) {
            System.out.println("Yritit lyödä oman nappulasi");
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa onko siirto moukan siirtosääntöjen mukainen
     * @param siirto käyttäjän antama siirto
     * @return       onko siirtosääntöjen mukainen (true/false)
     */
    protected boolean tarkistaMoukka(int[] siirto) {
        if (!liikkuukoMoukkaOikeaanSuuntaan(siirto)) {
            System.out.println("Yritit liikkua väärään suuntaan");
            return false;
        } else if (siirto[0] == siirto[2] && ((Math.abs(siirto[3] - siirto[1]) == 1 || onkoMoukanKaksoisaskel(siirto)))) {
            return true;
        } else if (Math.abs(siirto[2] - siirto[0]) == 1 && Math.abs(siirto[3] - siirto[1]) == 1 && (onkoMoukanLyonti(siirto) || onkoMoukanOhestalyonti(siirto))) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa onko siirrettävä nappula valkea
     * @param siirto käyttäjän antama siirto
     * @return       onko valkea (true/false)
     */
    protected boolean onkoValkea(int[] siirto) {
        if (Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0]))) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko moukka oikeaan suuntaan
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean liikkuukoMoukkaOikeaanSuuntaan(int[] siirto) {
        if (Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0])) && siirto[3] - siirto[1] > 0) {
            return true;
        }
        if (Character.isLowerCase(pelilauta.getRuutu(siirto[1], siirto[0])) && siirto[3] - siirto[1] < 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko moukka kaksi askelta lähtöpaikastaan eli onko kyseessä moukan kaksoisaskel. Jos kyseessä on kaksoisaskel, metodi merkitsee ruudun onkoRuutuunTultuKaksoisAskeleella-matriisiin odottelemaan ohestalyöntiä.
     * @param siirto käyttäjän antama siirto
     * @return       onko kaksoisaskel (true/false)
     */
    protected boolean onkoMoukanKaksoisaskel(int[] siirto) {
        if (Math.abs(siirto[3] - siirto[1]) == 2 && ((Character.isLowerCase(pelilauta.getRuutu(siirto[1], siirto[0])) && siirto[1] == 6) || (Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0]))) && siirto[1] == 1)) {
            pelilauta.onkoRuutuunTultuKaksoisaskeleella[siirto[3]][siirto[2]] = pelilauta.getRuutu(siirto[1], siirto[0]);
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa ollaanko annetussa siirrossa lyömässä nappulaa
     * @param siirto käyttäjän antama siirto
     * @return       onko lyönti (true/false)
     */
    protected boolean onkoMoukanLyonti(int[] siirto) {
        if (pelilauta.getRuutu(siirto[3], siirto[2]) != '\u0000') {
            return true;
        } else {
            System.out.println("Et voi lyödä tyhjää");
            return false;
        }
    }

    /** Tarkistaa onko annettu siirto moukan ohestalyönti
     * @param siirto käyttäjän antama siirto
     * @return       onko ohestalyönti (true/false)
     */
    protected boolean onkoMoukanOhestalyonti(int[] siirto) {
        if (onkoValkea(siirto) && pelilauta.onkoRuutuunTultuKaksoisaskeleella[siirto[3] + 1][siirto[2]] == 'P') {
            pelilauta.setRuutu(siirto[3] + 1, siirto[2], '\u0000');
            return true;
        } else if (!onkoValkea(siirto) && pelilauta.onkoRuutuunTultuKaksoisaskeleella[siirto[3] - 1][siirto[2]] == 'p') {
            pelilauta.setRuutu(siirto[3] - 1, siirto[2], '\u0000');
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa onko moukka korottumassa
     * @param siirto käyttäjän antama siirto
     * @return       onko korottumassa (true/false)
     */
    protected boolean onkoMoukkaKorottumassa(int[] siirto) {
        if ((Character.isLowerCase(pelilauta.getRuutu(siirto[1], siirto[0])) && siirto[3] == 0) || (Character.isUpperCase(pelilauta.getRuutu(siirto[1], siirto[0]))) && siirto[3] == 7) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko torni vain suoraan tai sivulle
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean tarkistaTorni(int[] siirto) {
        if (siirto[0] == siirto[2] || siirto[1] == siirto[3]) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko ratsu oikein
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean tarkistaRatsu(int[] siirto) {
        if ((Math.abs(siirto[2] - siirto[0]) == 1 && Math.abs(siirto[3] - siirto[1]) == 2)
                || (Math.abs(siirto[2] - siirto[0]) == 2 && Math.abs(siirto[3] - siirto[1]) == 1)) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko lähetti vain vinottain
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean tarkistaLahetti(int[] siirto) {
        if (Math.abs(siirto[2] - siirto[0]) == Math.abs(siirto[3] - siirto[1])) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko kuningatar kuten torni tai lähetti
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean tarkistaDaami(int[] siirto) {
        if (tarkistaTorni(siirto) || tarkistaLahetti(siirto)) {
            return true;
        } else {
            return false;
        }
    }

    /** Tarkistaa liikkuuko kuningas alle kaksi ruutua mihin hyvänsä suuntaan
     * @param siirto käyttäjän antama siirto
     * @return       liikkuuko (true/false)
     */
    protected boolean tarkistaKuningas(int[] siirto) {
        if (Math.abs(siirto[2] - siirto[0]) < 2 && Math.abs(siirto[3] - siirto[1]) < 2) {
            return true;
        } else {
            return false;
        }
    }
}

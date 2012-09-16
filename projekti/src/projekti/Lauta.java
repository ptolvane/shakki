package projekti;

/** Hallinnoi 8x8 shakkilautaa ja nappuloita */
public class Lauta {

    /** Kaksiulotteinen char-tyypin 8x8 taulukko, johon tallennetaan nappuloiden sijanti shakkilaudalla */
    char[][] nappulat;
    /** Onko kuningas liikkunut {valkea, musta}*/
    boolean[] onkoKuningasLiikkunut;
    char[][] onkoRuutuunTultuKaksoisaskeleella;

    /** Konstruktori alustaa laudan */
    public Lauta() {
        nappulat = new char[8][8];
        onkoKuningasLiikkunut = new boolean[2];
        onkoRuutuunTultuKaksoisaskeleella = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (nappulat[i][j] == 'T' || nappulat[i][j] == 't' || nappulat[i][j] =='K' || nappulat[i][j]=='k') {
                    onkoRuutuunTultuKaksoisaskeleella[i][j] = nappulat[i][j];
                } else {
                    onkoRuutuunTultuKaksoisaskeleella[i][j] = '\u0000';
                }
            }
        }
        tyhjennaLauta();
        asetaNappulat();
    }

    /** Tyhjentää kaksoisaskel-taulukon */
    public void siivoaKaksoisaskeltaulukko() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (onkoRuutuunTultuKaksoisaskeleella[i][j] != getRuutu(i, j)) {
                    onkoRuutuunTultuKaksoisaskeleella[i][j] = '\u0000';
                }
            }
        }
    }

    /** Tyhjentää nappulat-taulukon */
    private void tyhjennaLauta() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nappulat[i][j] = '\u0000';
            }
        }
    }

    public void setRuutu(int x, int y, char nappula) {
        nappulat[x][y] = nappula;
    }

    public char getRuutu(int x, int y) {
        return nappulat[x][y];
    }

    /** Asettaa nappulat aloitusasemiin nappulat-taulukkoon */
    protected void asetaNappulat() {
        for (int i = 0; i < 8; i++) {
            nappulat[1][i] = 'P';
        }
        nappulat[0][0] = 'T';
        nappulat[0][1] = 'R';
        nappulat[0][2] = 'L';
        nappulat[0][3] = 'K';
        nappulat[0][4] = 'D';
        nappulat[0][5] = 'L';
        nappulat[0][6] = 'R';
        nappulat[0][7] = 'T';
        nappulat[7][0] = 't';
        nappulat[7][1] = 'r';
        nappulat[7][2] = 'l';
        nappulat[7][3] = 'k';
        nappulat[7][4] = 'd';
        nappulat[7][5] = 'l';
        nappulat[7][6] = 'r';
        nappulat[7][7] = 't';
        for (int i = 0; i < 8; i++) {
            nappulat[6][i] = 'p';
        }
    }
}

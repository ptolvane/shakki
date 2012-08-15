package projekti;

public class Lauta {

    /** Kaksiulotteinen char-tyypin 8x8 taulukko, johon tallennetaan nappuloiden sijanti shakkilaudalla */
    char[][] nappulat;

    public Lauta(){
        nappulat = new char[8][8];
    }

    /** Piirtää 8x8 shakkilaudan nappuloineen tekstinä */
    public void piirraLauta() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("\n-----------------");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (nappulat[i][j] != '\u0000') { // jos ruudussa on nappula, piirrä se
                    System.out.print(nappulat[i][j]);
                } else if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    System.out.print(" "); // ellei nappulaa, joka toiseen valkea ruutu
                } else {
                    System.out.print("."); // loppuihin musta ruutu
                }
            }
            System.out.print("| " + (i + 1));
        }
        System.out.println("\n-----------------");
        System.out.println(" a b c d e f g h");
    }

    /** Tyhjentää nappulat-taulukon */
    public void tyhjennaLauta() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nappulat[i][j] = '\u0000';
            }
        }
    }

    public char[][] getNappulat(){
        return nappulat;
    }

    public char getRuutu(int x, int y) {
        return nappulat[x][y];
    }

    /** Asettaa nappulat aloitusasemiin nappulat-taulukkoon */
    public void asetaNappulat() {
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

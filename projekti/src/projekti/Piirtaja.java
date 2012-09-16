package projekti;

/** Piirtää 8x8 shakkilaudan nappuloineen tekstinä */
public class Piirtaja {

    Lauta pelilauta;

    /** Konstruktori asettaa piirtäjälle Lauta-olion
    @param pelilauta piirrettävä pelilauta*/
    public Piirtaja(Lauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    /** Piirtää pelilaudan tekstinä */
    public void piirraLauta() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("\n-----------------");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (pelilauta.nappulat[i][j] != '\u0000') { // jos ruudussa on nappula, piirrä se
                    System.out.print(pelilauta.nappulat[i][j]);
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
}

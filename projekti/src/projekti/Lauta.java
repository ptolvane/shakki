package projekti;

public class Lauta {

    char[][] nappulat = new char[8][8];

    void piirraLauta() {
        for (int i = 7; i >= 0; i--) {
            System.out.println("\n-----------------");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (nappulat[i][j] != '\u0000') {
                    System.out.print(nappulat[i][j]);
                } else if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("| " + (i+1));
        }
        System.out.println("\n-----------------");
        System.out.println(" a b c d e f g h");
    }

    void resetoiLauta() {
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

package projekti;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pekka
 */
public class LautaTest {

    Lauta omaLauta;

    public LautaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        omaLauta = new Lauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void onkoTyhjennettyLautaTyhja() {
        omaLauta.tyhjennaLauta();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals('\u0000', omaLauta.getRuutu(i, j));
                {
                }
            }
        }
    }

    @Test
    public void onkoNappuloitaOikeaMaara() {
        char[] oikeatNappulat = {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 't', 't', 'r', 'r', 'l', 'l', 'k', 'd', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'T', 'T', 'R', 'R', 'L', 'L', 'K', 'D', '\u0000'};
        Arrays.sort(oikeatNappulat);
        omaLauta.asetaNappulat();
        char[] laudanNappulat = {'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        int indeksi = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (omaLauta.getRuutu(i, j) != '\u0000') {
                    laudanNappulat[indeksi] = omaLauta.getRuutu(i, j);
                    indeksi++;
                }
            }
        }
        Arrays.sort(laudanNappulat);
        assertArrayEquals(oikeatNappulat, laudanNappulat);
    }
}

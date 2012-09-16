/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

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
public class TarkistajaTest {

    Tarkistaja tarkistaja;
    Peli peli;
    Lauta pelilauta;

    public TarkistajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        pelilauta = new Lauta();
        peli = new Peli();
        tarkistaja = new Tarkistaja(pelilauta, peli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void omanNappulanSiirto() {
        peli.setVuoro('v');
        pelilauta.setRuutu(5, 4, 'P');
        int[] siirto = {4, 5, 9, 9};
        assertTrue(tarkistaja.siirtaakoOmaaNappulaa(siirto));
    }

    @Test
    public void toisenNappulanSiirto() {
        peli.setVuoro('m');
        pelilauta.setRuutu(5, 4, 'P');
        int[] siirto = {4, 5, 9, 9};
        assertFalse(tarkistaja.siirtaakoOmaaNappulaa(siirto));
    }

    @Test
    public void onhanNappulanPaalleLiikkuminenLyonti() {
        pelilauta.setRuutu(5, 4, 'P');
        int[] siirto = {9, 9, 4, 5};
        assertTrue(tarkistaja.onkoLyonti(siirto));
    }

    @Test
    public void eihanTyhjanPaalleLiikkuminenOleLyonti() {
        pelilauta.setRuutu(5, 4, '\u0000');
        int[] siirto = {9, 9, 4, 5};
        assertFalse(tarkistaja.onkoLyonti(siirto));
    }

    @Test
    public void siirtyyhanSamaanPaikkaan() {
        int[] siirto = {4, 5, 4, 5};
        assertTrue(tarkistaja.siirtyykoSamaanPaikkaan(siirto));
    }

    @Test
    public void eihanSiirrySamaanPaikkaan() {
        int[] siirto = {4, 5, 5, 4};
        assertFalse(tarkistaja.siirtyykoSamaanPaikkaan(siirto));
    }

    @Test
    public void negatiivinenEiPysyLaudalla() {
        int[] siirto = {0, 0, 0, -1};
        assertFalse(tarkistaja.pysyykoLaudalla(siirto));
    }

    @Test
    public void yhdeksanEiPysyLaudalla() {
        int[] siirto = {0, 0, 9, 8};
        assertFalse(tarkistaja.pysyykoLaudalla(siirto));
    }
}

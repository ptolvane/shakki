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

    @Test
    public void lyokoOmaaNappulaa() {
        pelilauta.setRuutu(6, 5, 'P');
        pelilauta.setRuutu(5, 4, 'P');
        int[] siirto = {5, 6, 4, 5};
        assertTrue(tarkistaja.lyokoOmaaNappulaa(siirto));
    }

    @Test
    public void liikkuuhanValkeaMoukkaVääräänSuuntaan() {
        pelilauta.setRuutu(6, 5, 'P');
        int[] siirto = {5, 6, 5, 4};
        assertFalse(tarkistaja.lyokoOmaaNappulaa(siirto));
    }

    @Test
    public void liikkuuhanMustaMoukkaVääräänSuuntaan() {
        pelilauta.setRuutu(6, 5, 'p');
        int[] siirto = {5, 6, 5, 4};
        assertFalse(tarkistaja.lyokoOmaaNappulaa(siirto));
    }

    @Test
    public void onkoValkea() {
        pelilauta.setRuutu(6, 5, 'P');
        int[] siirto = {5, 6, 9, 9};
        assertTrue(tarkistaja.onkoValkea(siirto));
    }

    @Test
    public void onkoMusta() {
        pelilauta.setRuutu(6, 5, 'p');
        int[] siirto = {5, 6, 9, 9};
        assertFalse(tarkistaja.onkoValkea(siirto));
    }

    @Test
    public void onhanMoukanKaksoisaskel() {
        pelilauta.setRuutu(1, 5, 'P');
        int[] siirto = {5, 1, 5, 3};
        assertTrue(tarkistaja.onkoMoukanKaksoisaskel(siirto));
    }

    @Test
    public void eihanOleMoukanKaksoisaskel() {
        pelilauta.setRuutu(6, 1, 'P');
        int[] siirto = {1, 6, 4, 6};
        assertFalse(tarkistaja.onkoMoukanKaksoisaskel(siirto));
    }

    @Test
    public void onkoMoukanLyonti() {
        pelilauta.setRuutu(6, 5, 'P');
        int[] siirto = {9, 9, 5, 6};
        assertTrue(tarkistaja.onkoMoukanLyonti(siirto));
    }

    @Test
    public void eihanOleMoukanOhestalyonti() {
        pelilauta.setRuutu(6, 5, 'P');
        int[] siirto = {6, 5, 5, 5};
        assertFalse(tarkistaja.onkoMoukanOhestalyonti(siirto));
    }

    @Test
    public void kayhanTorninTarkistus() {
        int[] siirto = {5, 6, 5, 8};
        assertTrue(tarkistaja.tarkistaTorni(siirto));
    }

    @Test
    public void eihanKayTorninSiirroksi() {
        int[] siirto = {5, 6, 6, 7};
        assertFalse(tarkistaja.tarkistaTorni(siirto));
    }

    @Test
    public void eihanKayRatsunSiirroksi() {
        int[] siirto = {5, 6, 6, 7};
        assertFalse(tarkistaja.tarkistaRatsu(siirto));
    }

    @Test
    public void kayhanRatsunSiirroksi() {
        int[] siirto = {5, 6, 7, 7};
        assertTrue(tarkistaja.tarkistaRatsu(siirto));
    }

    @Test
    public void eihanKayLahetinSiirroksi() {
        int[] siirto = {5, 6, 5, 7};
        assertFalse(tarkistaja.tarkistaLahetti(siirto));
    }

    @Test
    public void kayhanLahetinSiirroksi() {
        int[] siirto = {5, 6, 6, 7};
        assertTrue(tarkistaja.tarkistaLahetti(siirto));
    }

    @Test
    public void eihanKayDaaminSiirroksi() {
        int[] siirto = {5, 6, 6, 8};
        assertFalse(tarkistaja.tarkistaDaami(siirto));
    }

    @Test
    public void kayhanDaaminSiirroksi() {
        int[] siirto = {2, 3, 7, 8};
        assertTrue(tarkistaja.tarkistaDaami(siirto));
    }

    @Test
    public void eihanKayKuninkaanSiirroksi() {
        int[] siirto = {5, 6, 5, 8};
        assertFalse(tarkistaja.tarkistaKuningas(siirto));
    }

    @Test
    public void kayhanKuninkaanSiirroksi() {
        int[] siirto = {5, 3, 4, 4};
        assertTrue(tarkistaja.tarkistaKuningas(siirto));
    }
}

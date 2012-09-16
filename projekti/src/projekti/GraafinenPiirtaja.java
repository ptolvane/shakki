package projekti;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.*;

/** Piirtää 8x8 shakkilaudan nappuloineen graafisesti (joskaan ei toimi) */
public class GraafinenPiirtaja extends JPanel implements MouseListener {

    JFrame ikkuna;
    Lauta pelilauta;
    JPanel ruudukko[][] = new JPanel[8][8];
    HashMap<Character, JLabel> kartta;

    public GraafinenPiirtaja(Lauta pelilauta) {
        this.pelilauta = pelilauta;
        ikkuna = new JFrame();
        ikkuna.setSize(600, 600);
        ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ikkuna.setLayout(new GridLayout(8, 8, 0, 0));
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                ruudukko[i][j] = new JPanel();
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    ruudukko[i][j].setBackground(Color.black);
                } else {
                    ruudukko[i][j].setBackground(Color.white);
                }
                ikkuna.add(ruudukko[i][j]);
            }
        }
        JLabel P = new JLabel(new ImageIcon("ikonit/mm.png"));
        JLabel p = new JLabel(new ImageIcon("ikonit/vm.png"));
        JLabel T = new JLabel(new ImageIcon("ikonit/mt.png"));
        JLabel R = new JLabel(new ImageIcon("ikonit/mr.png"));
        JLabel L = new JLabel(new ImageIcon("ikonit/ml.png"));
        JLabel D = new JLabel(new ImageIcon("ikonit/md.png"));
        JLabel K = new JLabel(new ImageIcon("ikonit/mk.png"));
        JLabel t = new JLabel(new ImageIcon("ikonit/vt.png"));
        JLabel r = new JLabel(new ImageIcon("ikonit/vr.png"));
        JLabel l = new JLabel(new ImageIcon("ikonit/vl.png"));
        JLabel d = new JLabel(new ImageIcon("ikonit/vd.png"));
        JLabel k = new JLabel(new ImageIcon("ikonit/vk.png"));
        kartta = new HashMap<Character, JLabel>();
        kartta.put('P', P);
        kartta.put('T', T);
        kartta.put('R', R);
        kartta.put('L', L);
        kartta.put('D', D);
        kartta.put('K', K);
        kartta.put('k', k);
        kartta.put('d', d);
        kartta.put('l', l);
        kartta.put('t', t);
        kartta.put('p', p);
        kartta.put('r', r);
    }

    public void piirraLauta() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pelilauta.nappulat[i][j] != '\u0000') {
                    ruudukko[i][j].add(kartta.get(pelilauta.nappulat[i][j]));
                }
            }
        }
        ikkuna.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        int x = getX();
        int y = getY();
    }

    public void mouseReleased(MouseEvent e) {
        int x = getX();
        int y = getY();
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

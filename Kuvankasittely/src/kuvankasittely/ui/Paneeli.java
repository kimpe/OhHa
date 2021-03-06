package kuvankasittely.ui;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import kuvankasittely.domain.*;

/**
 * Paneeli kuvien piirtämistä varten.
 * 
 * @author      kimpe
 * @version     6.1
 * @since       2013-10-16
 */

public class Paneeli extends JPanel {
    
    /**
     * Luokan sisäinen esitysmuoto kuvalle.
     */    
    
    private BufferedImage puskuroituKuva;
    
    /**
     * Luo uuden, taustaväriltään valkoisen paneelin.
     */    
    
    public Paneeli() {
        super.setBackground(Color.WHITE);
    }

    /**
     * Palauttaa piirrettävän kuvan.
     * 
     * @return Paneeliin liittyvä kuva.
     */    
    
    public BufferedImage getKuva() {
        return puskuroituKuva;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) { 
         super.paintComponent(graphics);
         graphics.drawImage(puskuroituKuva, 0, 0, null);
    }
 
    /**
     * Asettaa piirrettävän kuvan.
     * 
     * @param kuva Piirrettävä kuva.
     */    
    
    public void setKuva(Kuva kuva) {
        this.puskuroituKuva = kuva.getPuskuroituKuva();
    }
        
}
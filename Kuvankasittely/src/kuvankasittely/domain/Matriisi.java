package kuvankasittely.domain;

public class Matriisi {
    
    private int rivienMaara;
    private int sarakkeidenMaara;
    private int[][] alkiot;
    
    public Matriisi(int rivienMaara, int sarakkeidenMaara) {
        if (rivienMaara > 0 && sarakkeidenMaara > 0) {
            this.rivienMaara = rivienMaara;
            this.sarakkeidenMaara = sarakkeidenMaara;
            this.alkiot = new int[rivienMaara][sarakkeidenMaara];
        }
    }
    
    public Matriisi(Matriisi alkuperainen) {
        this( alkuperainen.getRivienMaara(), alkuperainen.getSarakkeidenMaara() );
        for (int rivi = 0; rivi < rivienMaara; rivi++) {
            for (int sarake = 0; sarake < sarakkeidenMaara; sarake++) {
                this.setAlkio(rivi, sarake, alkuperainen.getAlkio(rivi, sarake) );
            }
        }
    }
    
    public boolean setAlkio(int rivi, int sarake, int arvo) {
        try {
            if (arvo < 0) {
                alkiot[rivi][sarake] = 0;
            } else if (255 < arvo) {
                alkiot[rivi][sarake] = 255;
            } else {
                alkiot[rivi][sarake] = arvo;
            }
            return true;
        } catch (IndexOutOfBoundsException poikkeus) {
            return false;
        }
    }
    
    public boolean setAlkiot(int arvo) {
        for (int rivi = 0; rivi < rivienMaara; rivi++) {
            for (int sarake = 0; sarake < sarakkeidenMaara; sarake++) {
                if ( !setAlkio(rivi, sarake, arvo) ) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getAlkio(int rivi, int sarake) {
        int alkio;
        try {
            return alkiot[rivi][sarake];
        } catch (IndexOutOfBoundsException poikkeus) {
            return -1;
        }
    }
    
    public int[][] getAlkiot() {
        return alkiot;
    }
    
    public int getRivienMaara() {
        return rivienMaara;
    }
    
    public int getSarakkeidenMaara() {
        return sarakkeidenMaara;
    }
    
    public void kaannaVasenOikea() {
        for (int rivi = 0; rivi < rivienMaara; rivi++) {
            for (int sarake = 0; sarake < (int) Math.floor(sarakkeidenMaara/2.0); sarake++) {
                int kopio = getAlkio(rivi, sarake);
                setAlkio(rivi, sarake, getAlkio(rivi, sarakkeidenMaara - 1 - sarake) );
                setAlkio(rivi, sarakkeidenMaara - 1 - sarake, kopio);
            }
        }
    }
    
    public void kaannaYlosAlas() {
        for (int sarake = 0; sarake < sarakkeidenMaara; sarake++) {
            for (int rivi = 0; rivi < (int) Math.floor(rivienMaara/2.0); rivi++) {
                int kopio = getAlkio(rivi, sarake);
                setAlkio(rivi, sarake, getAlkio(rivienMaara - 1 - rivi, sarake) );
                setAlkio(rivienMaara - 1 - rivi, sarake, kopio);
            }
        }
    }
    
    public void kierra180Astetta() {
        kaannaVasenOikea();
        kaannaYlosAlas();
    }
    
}
package beans;

import java.io.Serializable;

/**
 *
 * @author MOi
 */
public class Tags implements Serializable{

    public static void add(Tags t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private long id_tag;
    private String libelle;

    public Tags() {
    }

    /**
     * @return the id_tag
     */
    public long getId_tag() {
        return id_tag;
    }

    /**
     * @param id_tag the id_tag to set
     */
    public void setId_tag(long id_tag) {
        this.id_tag = id_tag;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
}

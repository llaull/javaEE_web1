package beans;
import java.io.Serializable;

/**
 * un bean doit implementé serializable
 * @author Arkesys
 */
public class Categorie implements Serializable{
    
    private long id_categorie;
    private String libelle;

    public Categorie() {}
    

    /**
     * @return the id_categorie
     */
    public long getId_categorie() {
        return id_categorie;
    }

    /**
     * @param id_categorie the id_categorie to set
     */
    public void setId_categorie(long id_categorie) {
        this.id_categorie = id_categorie;
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

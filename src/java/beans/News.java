
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MOi
 */
public class News implements Serializable{

    private int id;
    private String titre;
    private String txt;
    private Categorie categorie;
    
    private List<Tags> newsTags;

    public News() {
        categorie = new Categorie();
        newsTags = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the txt
     */
    public String getTxt() {
        return txt;
    }

    /**
     * @param txt the txt to set
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }

    /**
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the newsTags
     */
    public List<Tags> getNewsTags() {
        return newsTags;
    }

    /**
     * @param newsTags the newsTags to set
     */
    public void setNewsTags(List<Tags> newsTags) {
        this.newsTags = newsTags;
    }

}

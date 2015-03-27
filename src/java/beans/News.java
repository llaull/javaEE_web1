
package beans;

import java.io.Serializable;

/**
 *
 * @author MOi
 */
public class News implements Serializable{

    private int id;
    private String titre;
    private String txt;

    public News() {
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

    
   
    
}

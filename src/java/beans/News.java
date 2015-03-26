
package beans;

import java.io.Serializable;

/**
 *
 * @author MOi
 */
public class News implements Serializable{

    private long id_news;
    private String titre;
    private String legende;

    public News() {
    }

    
    /**
     * @return the id_news
     */
    public long getId_news() {
        return id_news;
    }

    /**
     * @param id_news the id_news to set
     */
    public void setId_news(long id_news) {
        this.id_news = id_news;
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
     * @return the legende
     */
    public String getLegende() {
        return legende;
    }

    /**
     * @param legende the legende to set
     */
    public void setLegende(String legende) {
        this.legende = legende;
    }
    
}

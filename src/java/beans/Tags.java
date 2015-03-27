package beans;

import java.io.Serializable;

/**
 *
 * @author MOi
 */
public class Tags implements Serializable{

    private int id;
    private String value;

    public Tags() {
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
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    
    
    
}

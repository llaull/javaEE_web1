package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moi
 */
public class DataManager {
    
    private String dbURL = "";
    private String dbUserName = "";
    private String dbPassword = "";

    public DataManager() {}

    /**
     * connexion
     * @return 
     */
    public Connection getConnection(){
        Connection conn = null;
        
        try {
            
            conn = DriverManager.getConnection(getDbURL(),getDbUserName(),getDbPassword());
            
        } catch (SQLException e) {
            
            System.out.println("connection impossible :" + e.getMessage());
        }
        
        return conn;
    }
    
    /**
     * 
     * @param conn 
     */
    public void closeConnection(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("blbl" + toString());
            }
            
        }
        
    }
    
    
    /**
     * @return the dbURL
     */
    public String getDbURL() {
        return dbURL;
    }

    /**
     * @param dbURL the dbURL to set
     */
    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    /**
     * @return the dbUserName
     */
    public String getDbUserName() {
        return dbUserName;
    }

    /**
     * @param dbUserName the dbUserName to set
     */
    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    /**
     * @return the dbPassword
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * @param dbPassword the dbPassword to set
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    
}

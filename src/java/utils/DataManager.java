package utils;

import java.sql.Connection;

/**
 *
 * @author Moi
 */
public class DataManager {
    
    private String dbURL = "";
    private String dbUserName = "";
    private String dbPassword = "";

    public DataManager() {}

        
//    public Connection getConnection(){
//        
//        return conn;
//    }
    
    public  void closeConnection(Connection conn){
        
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

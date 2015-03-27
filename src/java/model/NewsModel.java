package model;

import beans.Categorie;
import beans.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arkesys
 */
public class NewsModel {
    
     public static List<News> getNews(Connection con){

	String sql = "SELECT * FROM news";

	List<News> News = new ArrayList<>();

	try {

		PreparedStatement stmt = con.prepareStatement(sql);

		try{
			ResultSet rs = stmt.executeQuery();

			try{

				while (rs.next()){

					News n = new News();                                        
					n.setId(rs.getInt("id"));
					n.setTitre(rs.getString("titre"));

					News.add(n); //ajout à l'arraylist

				}

			} finally{rs.close();}

		} finally{stmt.close();}

	} catch(SQLException ex){
            
            System.out.println("e" + ex);

	}
        
        return News;

    }
    
}

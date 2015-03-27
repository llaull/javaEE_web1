package model;

import beans.Tags;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moi
 */
public class TagsModel {
    
     public static List<Tags> getTags(Connection con){

	String sql = "SELECT * FROM tags";

	List<Tags> Tags = new ArrayList<>();

	try {

		PreparedStatement stmt = con.prepareStatement(sql);

		try{
			ResultSet rs = stmt.executeQuery();

			try{

				while (rs.next()){

					Tags t = new Tags();                                        
					t.setId(rs.getInt("id"));
					t.setValue(rs.getString("value"));

					Tags.add(t); //ajout à l'arraylist

				}

			} finally{rs.close();}

		} finally{stmt.close();}

	} catch(SQLException ex){
            
            System.out.println("e" + ex);

	}
        
        return Tags;

    }
}

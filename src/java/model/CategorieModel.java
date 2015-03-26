/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import beans.Categorie;
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
public class CategorieModel {
    
    public static List<Categorie> getCategories(Connection con){

	String sql = "select * form categorie";

	List<Categorie> categories = new ArrayList<>();

	try {

		PreparedStatement stmt = con.prepareStatement(sql);

		try{
			ResultSet rs = stmt.executeQuery();

			try{

				while (rs.next()){

					Categorie cat = new Categorie();                                        
					cat.setId_categorie(rs.getInt("Id_categorie"));
					cat.setLibelle(rs.getString("libelle"));

					categories.add(cat); //ajout à l'arraylist

				}

			} finally{rs.close();}

		} finally{stmt.close();}

	} catch(SQLException ex){
            
            System.out.println("e" + ex);

	}
        
        return categories;

    }
    
}

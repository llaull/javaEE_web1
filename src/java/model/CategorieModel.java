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
    
    /**
     * SELECT
     * @param con
     * @param cat 
     */
     public static void getCategorieByid(Connection con, Categorie cat){
         
         String sql = "SELECT * FROM categories where id_categorie=?";
         
         try {
             
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setLong(1, cat.getId_categorie());
             System.out.println("categorie selectionner " + cat.getId_categorie());
             try {
                 ResultSet rs = stmt.executeQuery();
                 
                 try {
                     
                     while (rs.next()) {
                         
                         cat.setLibelle(rs.getString("libelle"));
                         
                     }
                     
                 } finally{rs.close();}
                 
             }finally{stmt.close();}
             
         } catch (SQLException e) {
             System.out.println("ex " + e);
         }
     
     }
    
     /**
      * UPDATE
      * @param con
      * @param cat 
      */
    public static void modifyCategorie(Connection con, Categorie cat){
         
         String sql = "update categories set libelle=? WHERE id_categorie=?";
         
         try {
             
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, cat.getLibelle());
             stmt.setLong(2, cat.getId_categorie());
             stmt.executeQuery();
             
         } catch (SQLException e) {
             System.out.println("ex " + e);
         }
     
     }     
    
    /**
     * INSERT
     * @param con
     * @param cat 
     */
    public static void insertCategorie(Connection con, Categorie cat){
         
         String sql = "insert into categories (libelle) values (?)";
         
         try {
             
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, cat.getLibelle());
             stmt.executeUpdate(sql);
             
         } catch (SQLException e) {
             System.out.println("ex " + e);
         }
     
     }

    /***
     * delete
     * @param con
     * @param cat 
     */
    public static void deleteCategorie(Connection con, Categorie cat){
         
         String sql = "delete FROM categories WHERE id_categorie=?";
         
         try {
             
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setLong(1, cat.getId_categorie());
             stmt.executeUpdate(sql);
             
         } catch (SQLException e) {
             System.out.println("ex " + e);
         }
     
     }
    
    /**
     * SELECT fetch
     * @param con
     * @return 
     */
    public static List<Categorie> getCategories(Connection con){

	String sql = "SELECT * FROM categories";

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

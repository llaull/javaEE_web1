package model;

import beans.News;
import beans.Tags;
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

    /**
     * SELECT
     *
     * @param con
     * @param cat
     */
    public static void getNewsTags(Connection con, News n) {

        String sql = "SELECT tags.id, tags.value FROM tags INNER JOIN news_tag ON news_tag.tag_ID = tags.id WHERE news_tag.news_ID=?";

        //List<Tags> listeTags = new ArrayList<>();
        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, n.getId());
            System.out.println("News selectionner " + n.getId());
            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {
                        
                        Tags tag = new Tags();
                        
                        tag.setId(rs.getInt("id"));
                        tag.setValue(rs.getString("value"));
                        
                        n.getNewsTags().add(tag);
                        
                    }

                } finally {
                    rs.close();
                }

            } finally {
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }
    
    /**
     * SELECT
     *
     * @param con
     * @param cat
     */
    public static void getNewsByid(Connection con, News n) {

        String sql = "SELECT n.id, n.titre, n.txt, c.value AS nameCat, c.id AS idCat, (select GROUP_CONCAT(value) FROM news_tag INNER JOIN tags as t on t.id = news_tag.tag_ID where news_tag.news_ID = n.id) FROM news AS n INNER JOIN categories AS c ON n.categorie_ID = c.id WHERE n.id=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, n.getId());
            System.out.println("News selectionner " + n.getId());
            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {

                        n.setTitre(rs.getString("titre"));
                        n.setTxt(rs.getString("txt"));
                        n.getCategorie().setId(rs.getInt("idCat"));
                        n.getCategorie().setValue(rs.getString("nameCat"));

                    }

                } finally {
                    rs.close();
                }

            } finally {
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }

    /**
     * UPDATE
     *
     * @param con
     * @param t
     */
    public static void modify(Connection con, News n) {

        String sql = "UPDATE news SET titre=?, txt=?, categorie_ID=? WHERE id=?";
       

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, n.getTitre());
            stmt.setString(2, n.getTxt());
            stmt.setInt(3, n.getCategorie().getId());
            stmt.setInt(4, n.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }

    /**
     * INSERT
     *
     * @param con
     * @param cat
     */
    public static void insert(Connection con, News n) {

        String sql = "insert into news (titre,txt,categorie_ID) values (?,?,?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, n.getTitre());
            stmt.setString(2, n.getTxt());
            stmt.setInt(3, n.getCategorie().getId());
            System.out.println("ajout -> " + n.getTitre());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }

    /**
     * *
     * delete
     *
     * @param con
     * @param t
     */
    public static void delete(Connection con, News n) {

        String sql = "DELETE FROM news WHERE id=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setLong(1, n.getId());
            stmt.executeUpdate();
            System.out.println("del -> " + n.getId());

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }

    public static List<News> getNews(Connection con) {

        String sql = "SELECT n.id, n.titre, n.txt, c.value AS nameCat, c.id AS idCat, (select GROUP_CONCAT(value) FROM news_tag INNER JOIN tags as t on t.id = news_tag.tag_ID where news_tag.news_ID = n.id) AS tags FROM news AS n INNER JOIN categories AS c ON n.categorie_ID = c.id";

        List<News> News = new ArrayList<>();

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {

                        News n = new News();
                        n.setId(rs.getInt("id"));
                        n.setTitre(rs.getString("titre"));
                        n.getCategorie().setValue(rs.getString("nameCat"));
                        n.setNewsTagsString(rs.getString("tags"));

                        News.add(n); //ajout à l'arraylist

                    }

                } finally {
                    rs.close();
                }

            } finally {
                stmt.close();
            }

        } catch (SQLException ex) {

            System.out.println("e" + ex);

        }

        return News;

    }

    public static void updateNewsTags(Connection con, News n) {
        
        String sql = "DELETE FROM news_tag WHERE news_ID=?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, n.getId());
            System.out.println("je del " + n.getId());
            
            try {
                
                stmt.executeUpdate();
                
            } finally{ stmt.close(); }
            
        } catch (SQLException e) {
            System.out.println("e => " + e);
            
        }
        
        String sql1 = "INSERT INTO news_tag (tag_ID, news_ID) VALUES (?, ?)";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql1);
            stmt.setInt(2, n.getId());
            
            try {
                
                for (int i = 0; i < n.getNewsTags().size(); i++) {
                    
                    stmt.setInt(1, n.getNewsTags().get(i).getId());
                    stmt.executeUpdate();
                    System.out.println("->" + sql1);
                    
                }
                
            } finally{ stmt.close(); }
            
        } catch (SQLException e) {
            System.out.println("e => " + e);
            
        }
    }


}

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
    public static void getNewsByid(Connection con, News n) {

        String sql = "SELECT n.id, n.titre, n.txt, c.value, c.id AS idCat FROM news AS n INNER JOIN categories AS c ON n.categorie_ID = c.id WHERE n.id=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, n.getId());
            System.out.println("News selectionner " + n.getId());
            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {

                        n.setTitre(rs.getString("titre"));
                        n.getCategorie().setId(rs.getInt("idCat"));

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
    public static void modify(Connection con, Tags t) {

        //String sql = "update categories set value=? WHERE id=?";
        String sql = "UPDATE tags SET value=? WHERE id=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, t.getValue());
            stmt.setLong(2, t.getId());
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

        String sql = "SELECT * FROM news";

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


}

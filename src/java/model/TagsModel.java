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

    /**
     * SELECT
     *
     * @param con
     * @param cat
     */
    public static void getTagsByid(Connection con, Tags t, String table) {

        String sql = "SELECT n.id, n.titre, n.txt, c.value FROM news AS n LEFT JOIN categories AS c ON n.categorie_ID = c.id;";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, t.getId());
            System.out.println("Tags selectionner " + t.getId());
            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {

                        t.setValue(rs.getString("value"));

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
    public static void insert(Connection con, Tags t) {

        String sql = "insert into tags (value) values (?)";
         //String sql = "INSERT INTO categories (value) VALUES ('coucou')";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, t.getValue());
            System.out.println("ajout -> " + t.getValue());
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
    public static void delete(Connection con, Tags t) {

        String sql = "DELETE FROM tags WHERE id=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setLong(1, t.getId());
            stmt.executeUpdate();
            System.out.println("del -> " + t.getId());

        } catch (SQLException e) {
            System.out.println("ex " + e);
        }

    }

    /**
     *
     * @param con
     * @return
     */
    public static List<Tags> getTags(Connection con) {

        String sql = "SELECT * FROM tags";

        List<Tags> Tags = new ArrayList<>();

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            try {
                ResultSet rs = stmt.executeQuery();

                try {

                    while (rs.next()) {

                        Tags t = new Tags();
                        t.setId(rs.getInt("id"));
                        t.setValue(rs.getString("value"));

                        Tags.add(t); //ajout à l'arraylist

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

        return Tags;

    }
}

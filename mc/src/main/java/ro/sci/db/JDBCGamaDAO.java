package ro.sci.db;

import ro.sci.dao.GamaDAO;
import ro.sci.meniu.Gama;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Skipy on 5/8/2017.
 */
public class JDBCGamaDAO implements GamaDAO {

    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCGamaDAO(String host, String port, String dbName, String userName, String pass) {
        this.host = host;
        this.userName = userName;
        this.pass = pass;
        this.port = port;
        this.dbName = dbName;
    }

    @Override
    public Gama getGama(int idGama) {
        String sql = "select id_gama, gama from gama where id_gama =" + idGama;
        Gama result = null;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                result = extractGama(rs);
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting gama.", ex);
        }
        return result;
    }

    @Override
    public Gama getIdGama(int idProdus) {
        String sql = "select id_gama, gama from gama where id_gama = (select id_gama from produse where id_produs = " + idProdus +")";
        Gama result = null;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                result = extractGama(rs);
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting gama from if produs.", ex);
        }
        return result;
    }


    @Override
    public Collection<Gama> getAll() {
        return null;
    }



    protected Connection newConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

            String url = new StringBuilder()
                    .append("jdbc:oracle:thin:@")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append(":")
                    .append(dbName).toString();

            Connection result = DriverManager.getConnection(url, userName, pass);
            result.setAutoCommit(false);

            return result;
        } catch (Exception ex) {
            throw new RuntimeException("Error getting DB connection", ex);
        }
    }

    private Gama extractGama(ResultSet rs) throws SQLException {
        Gama gama = new Gama();
        gama.setIdGama(rs.getInt("id_gama"));
        gama.setGama(rs.getString("gama"));
        return gama;
    }

}

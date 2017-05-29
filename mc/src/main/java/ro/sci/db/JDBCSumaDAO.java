package ro.sci.db;

import ro.sci.dao.SumaDAO;
import ro.sci.meniu.Suma;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Skipy on 5/13/2017.
 */

public class JDBCSumaDAO implements SumaDAO {
    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCSumaDAO(String host, String port, String dbName, String userName, String pass) {
        this.host = host;
        this.userName = userName;
        this.pass = pass;
        this.port = port;
        this.dbName = dbName;  }

    @Override
    public Suma getSuma(String idComenzi) {
        String sql = "select nvl(sum(pret_total),0) as suma from COMANDA_FIN_VW where id_comenzi =" + idComenzi;
        Suma result = null;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
             while (rs.next()) {
                result = extractSuma(rs);
             }
             connection.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("Error getting gama.", ex);
        }
        return result;
    }

    @Override
    public Collection<Suma> getAll() {
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

    private Suma extractSuma(ResultSet rs) throws SQLException {
        Suma suma = new Suma();
        suma.setSuma(rs.getString("suma"));
        return suma;
    }
}

package ro.sci.db;

import ro.sci.dao.ComandaDAO;
import ro.sci.meniu.Comanda;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */
public class JDBCComandaDAO implements ComandaDAO {
    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCComandaDAO(String host, String port, String dbName, String userName, String pass) {
        this.host = host;
        this.userName = userName;
        this.pass = pass;
        this.port = port;
        this.dbName = dbName;
    }

    @Override
    public Comanda getIdComanda(int aOrB, int idTable) {
       if (String.valueOf(aOrB).equals(String.valueOf(1)))
            {
            String sql = "select max(id_comenzi)+1 as id_comanda from comenzi";
            Comanda result = null;
            try (   Connection connection = newConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql))
                    {
                    while (rs.next())
                        {
                            result = extractIDComand(rs);
                        }
                        connection.commit();
                    } catch (SQLException ex)
                {
                    throw new RuntimeException("Error getting idComanda.", ex);
                }
                return result;
            } else {
                    String sql = "select id_comenzi as id_comanda from comenzi where masa_nr = '" + idTable + "' and data_fin is null";
                    Comanda result = null;
                    try (Connection connection = newConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql))
                    {
                    while (rs.next())
                    {
                        result = extractIDComand(rs);
                    }
                    connection.commit();
                    } catch (SQLException ex) {
            throw new RuntimeException("Error getting idComanda.", ex);
        }
        return result;}
    }

    @Override
    public Comanda countComenziDeschise(int idTable) {
        String sql = "select count(*) as cowntc from comenzi where masa_nr = '" + idTable + "' and data_fin is null";
        Comanda result = null;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                result = countComanda(rs);
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting CountCom.", ex);
        }
        return result;
    }

    @Override
    public void anulComanda(String idComenzi, int idTable) {
        String sql = "delete from comenzi_d where id_comenzi = " + idComenzi;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            connection.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("err deleting produs from comada_d", ex);
        }
        String sql2 = "delete from comenzi where id_comenzi = " + idComenzi + " and masa_nr =" + idTable;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql2)) {
            connection.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("err deleting forom comanda", ex);
        }
    }

    @Override
    public void finshComanda(String idComenzi, int idTable) {
        String sql = "update comenzi set data_fin = sysdate where id_comenzi = " + idComenzi+" and masa_nr = " + idTable;
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            connection.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("err updating comenzi", ex);
        }
    }


    @Override
    public Collection<Comanda> getAll() {
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

    private Comanda extractIDComand(ResultSet rs) throws SQLException {
        Comanda comanda = new Comanda();
        comanda.setIdComanda(rs.getInt("id_comanda"));
        return comanda;
    }

    private Comanda countComanda(ResultSet rs) throws SQLException {
        Comanda comanda = new Comanda();
        comanda.setIdComanda(rs.getInt("cowntc"));
        return comanda;
    }

}

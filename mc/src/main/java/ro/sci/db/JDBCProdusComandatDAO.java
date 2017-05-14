package ro.sci.db;

import ro.sci.dao.ProdusComandatDAO;
import ro.sci.meniu.ProdusComandat;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Skipy on 5/8/2017.
 */
public class JDBCProdusComandatDAO implements ProdusComandatDAO {
    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCProdusComandatDAO(String host, String port, String dbName, String userName, String pass) {
        this.host = host;
        this.userName = userName;
        this.pass = pass;
        this.port = port;
        this.dbName = dbName;
    }

    @Override
    public Collection<ProdusComandat> listAll(String idComenzi) {
        String sql = "select rownum as nrcrt, cfv.* from COMANDA_FIN_VW cfv where cfv.id_comenzi =" + idComenzi;
        Collection<ProdusComandat> result = new LinkedList<>();
        try (Connection connection = newConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                result.add(extractProduseComandate(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting products comade.", ex);
        }
        return result;
    }

    @Override
    public Collection<ProdusComandat> getAll() {
        return null;
    }


    @Override
    public Collection<ProdusComandat> getProduse(String gama) {
        return null;
    }

    @Override
    public void insertProdus(int idProdus) {
    }

    private ProdusComandat extractProduseComandate(ResultSet rs) throws SQLException {
        ProdusComandat produsComandat = new ProdusComandat();
        produsComandat.setNrCrt(rs.getInt("nrcrt"));
        produsComandat.setIdProdus(rs.getInt("id_produs"));
        produsComandat.setNumeProdus(rs.getString("nume_produs"));
        produsComandat.setDescriere(rs.getString("descriere"));
        produsComandat.setGama(rs.getString("gama"));
        produsComandat.setUnitateMasura(rs.getString("unm"));
        produsComandat.setBuc(rs.getInt("buc_produse"));
        produsComandat.setCant(rs.getInt("cant"));
        produsComandat.setPret(rs.getFloat("pret"));
        produsComandat.setPretTotal(rs.getFloat("pret_total"));
        produsComandat.setIdGama(rs.getInt("id_gama"));
        return produsComandat;
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
}

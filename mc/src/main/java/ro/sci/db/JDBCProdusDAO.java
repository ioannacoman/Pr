package ro.sci.db;


import ro.sci.dao.ProdusDAO;
import ro.sci.meniu.Produs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


public class JDBCProdusDAO implements ProdusDAO {
	//private static final Logger LOGGER = LoggerFactory.getLogger(JDBCProdusDAO.class);

	private String host;
	private String port;
	private String dbName;
	private String userName;
	private String pass;

	public JDBCProdusDAO(String host, String port, String dbName, String userName, String pass) {
		this.host = host;
		this.userName = userName;
		this.pass = pass;
		this.port = port;
		this.dbName = dbName;
	}

	@Override
	public Collection<Produs> getAll() {
		Collection<Produs> result = new LinkedList<>();
		try (Connection connection = newConnection();
				ResultSet rs = connection.createStatement()
				.executeQuery("select rownum as nrcrt, pr.id_produs as id_produs, pr.nume_produs as nume_produs, pr.descriere as descriere, g.gama as gama, pr.um as unm, pr.cant as cant, pp.pret as pret from produse pr, pr_pret pp, gama g where pr.id_gama = g.id_gama and pr.id_produs = pp.id_produs")) {

			while (rs.next()) {
				result.add(extractProduse(rs));
			}
			connection.commit();
		} catch (SQLException ex) {

			throw new RuntimeException("Error getting products.", ex);
		}

		return result;
	}

	@Override
	public Produs findById(int idProdus) {
		return null;
	}

	@Override
	public Produs update(Produs model) {
		return null;
	}

	@Override
	public boolean delete(Produs model) {
		return false;
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

			Connection result = DriverManager.getConnection(url,userName,pass);
			result.setAutoCommit(false);

			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Error getting DB connection", ex);
		}

	}

	private Produs extractProduse(ResultSet rs) throws SQLException {
		Produs produs = new Produs();
		produs.setNrCrt(rs.getInt("nrcrt"));
		produs.setIdProdus(rs.getInt("id_produs"));
		produs.setNumeProdus(rs.getString("nume_produs"));
		produs.setDescriere(rs.getString("descriere"));
		produs.setIdGama(rs.getString("gama"));
		produs.setUnitateMasura(rs.getString("unm"));
		produs.setCant(rs.getInt("cant"));
		produs.setPret(rs.getFloat("pret"));
		return produs;
	}

	@Override
	public Collection<Produs> searchByName(String query) {
		return null;
	}
}
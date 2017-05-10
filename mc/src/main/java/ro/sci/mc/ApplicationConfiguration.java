package ro.sci.mc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.sci.dao.GamaDAO;
import ro.sci.dao.ProdusComandatDAO;
import ro.sci.dao.ProdusDAO;
import ro.sci.db.JDBCGamaDAO;
import ro.sci.db.JDBCProdusComandatDAO;
import ro.sci.db.JDBCProdusDAO;
import ro.sci.services.GamaService;
import ro.sci.services.ProdusComandatService;
import ro.sci.services.ProdusService;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Value("${db.host}")
    private String dbHost;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.user}")
    private String dbUser;


    @Value("${db.name}")
    private String dbName;

    @Value("${db.port}")
    private String port;

    @Bean
    public ProdusDAO produsDAO() {
        return new JDBCProdusDAO(dbHost, port, dbName, dbUser , dbPassword);
    }
    @Bean
    public GamaDAO gamaDAO() {
        return new JDBCGamaDAO(dbHost, port, dbName, dbUser , dbPassword);
    }
    @Bean
    public ProdusComandatDAO produsComandatDAO() {
        return new JDBCProdusComandatDAO(dbHost, port, dbName, dbUser , dbPassword);
    }

 	@Bean
	public DataSource dataSource() {

        String url = new StringBuilder()
                .append("jdbc:oracle:thin:@")
                .append(dbHost)
                .append(":")
                .append(port)
                .append(":")
                .append(dbName).toString();

        return  new SingleConnectionDataSource(url, false);
    }
    @Bean
    public ProdusService produsService() {
        ProdusService mc = new ProdusService();
        mc.setDao(produsDAO());
        return mc;
    }
    @Bean
    public GamaService gamaService() {
        GamaService mc = new GamaService();
        mc.setGamaDAO(gamaDAO());
        return mc;
    }

    @Bean
    public ProdusComandatService produsComandatService() {
        ProdusComandatService mc = new ProdusComandatService();
        mc.setProdusComandatDAO(produsComandatDAO());
        return mc;
    }

}

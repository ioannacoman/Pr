package ro.sci.mc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.sci.dao.*;
import ro.sci.db.*;
import ro.sci.services.*;

import javax.sql.DataSource;
/**
 * Created by Skipy on 5/12/2017.
 */
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
    public ProdusComandatDAO produsComandatDAO() { return new JDBCProdusComandatDAO(dbHost, port, dbName, dbUser , dbPassword); }
    @Bean
    public ComandaDAO comandaDAO() { return new JDBCComandaDAO(dbHost, port, dbName, dbUser , dbPassword); }
    @Bean
    public SumaDAO sumaDAO() { return new JDBCSumaDAO(dbHost, port, dbName, dbUser , dbPassword); }


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
    @Bean
    public ComandaService comandaService() {
        ComandaService mc = new ComandaService();
        mc.setComandaDAO(comandaDAO());
        return mc;
    }
    @Bean
    public SumaService sumaService() {
        SumaService mc = new SumaService();
        mc.setSumaDAO(sumaDAO());
        return mc;
    }

}

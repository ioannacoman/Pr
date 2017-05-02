package ro.sci.mc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.sci.dao.ProdusDAO;
import ro.sci.db.JDBCProdusDAO;
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
    public ProdusDAO employeeDAO() {
        return new JDBCProdusDAO(dbHost, port, dbName, dbUser , dbPassword);
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

        mc.setDao(employeeDAO());
        return mc;
    }

}

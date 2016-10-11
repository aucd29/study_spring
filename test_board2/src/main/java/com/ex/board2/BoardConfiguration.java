package com.ex.board2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ex.board2.db.BoardDao;

@Configuration
public class BoardConfiguration {
	@Bean //(destroyMethod="close")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.211.55.11:1521:xe");
        dataSource.setUsername("aucd29");
        dataSource.setPassword("aucd29");
        
        return dataSource;
    }
     
    @Bean
    public BoardDao getBoardDao() {
        return new BoardDao(getDataSource());
    }
}

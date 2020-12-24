package com.care.root.file.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = "com.care.root.file.service")
public class FileConfigdb {

	@Bean
	public DriverManagerDataSource memberDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("c##geonmo");
		ds.setPassword("1234");
		return ds;
	}
	@Bean
	public SqlSessionFactory memberSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(memberDataSource());
		return ssf.getObject();
	}
	@Bean
	public SqlSession memberSqlSession() throws Exception {
		return new SqlSessionTemplate(memberSqlSessionFactory());
	}
	
}

package com.care.root.member.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = "com.care.root.member.dao")
public class MemberConfig {
	public DriverManagerDataSource memberDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("c##jsp");
		ds.setPassword("1234");
		return ds;
	}
	public SqlSessionFactory memberSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(memberDataSource());
		return ssf.getObject();
	}
	public SqlSession memberSqlSession() throws Exception {
		return new SqlSessionTemplate(memberSqlSessionFactory());
	}
	
}
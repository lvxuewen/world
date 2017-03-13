package cn.lv.web;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.chainsaw.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println(dataSource.getConnection());
		
	}
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		DataSource dataSource=(DataSource) ctx.getBean("dataSource");
		ResultSet rs= dataSource.getConnection().prepareStatement("select * from user").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("username"));
		}
		
	}
}

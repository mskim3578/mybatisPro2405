package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnection {
	private static SqlSessionFactory sqlmap;
	private MybatisConnection() {}
	static {
		Reader reader  = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlmap = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("config ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}//end static
	
	public static SqlSession  getConnection() {
		return sqlmap.openSession();
	}
	
	public static void main(String[] args) {
		SqlSession session = getConnection();
		System.out.println(session);
	}}

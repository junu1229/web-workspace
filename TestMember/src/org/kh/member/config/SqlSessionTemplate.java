package org.kh.member.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSqlSession() {

		SqlSession session = null;

		// 해당 리소스 경로(xml파일) 작성

		String resource = "/mybatis-config.xml";

		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return session; // 생성된 SqlSession 리턴

	}

}
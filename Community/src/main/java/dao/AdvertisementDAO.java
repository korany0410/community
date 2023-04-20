package dao;

import org.apache.ibatis.session.SqlSession;

public class AdvertisementDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}

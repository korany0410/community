package dao;

import org.apache.ibatis.session.SqlSession;

public class User_CommentDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}

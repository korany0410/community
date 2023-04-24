package dao;

import org.apache.ibatis.session.SqlSession;

import vo.PostVO;

public class PostDAO {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert_data(PostVO vo) {
		
		int res = sqlSession.insert("post.insert", vo);
		
		return res;
	}

}

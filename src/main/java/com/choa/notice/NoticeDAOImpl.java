package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

@Repository()
//NoticeDAO noticeDAO=new NoticeDAO();
public class NoticeDAOImpl implements BoardDAO{
	
	@Inject
	//만들어진 객체를 주입시켜주세요
	//private DataSource dataSource;//이거 대신 아랫꺼 사용하겟다.
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";
	
	//final 상수처리
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	public int boardCount() throws Exception{
		int count=sqlSession.selectOne(NAMESPACE+"count");
		return count;
		
	}
	
	
	public int noticeHit(int num) throws Exception {
		return sqlSession.update(NAMESPACE+"hit", num);
	}
	// view
	@Override
	public BoardDTO boardView(int num) throws Exception{
		//sqlSession.selectOne(아이디이름, 넘겨줄값);
		//NoticeMapper에 있는 아이디가 view인것
		// Mapper에 설정된 리턴 T=resultType="com.choa.notice.NoticeDTO"
		BoardDTO boardDTO=sqlSession.selectOne(NAMESPACE+"view", num);
		return boardDTO;
	}

	// list
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		List<BoardDTO> ar=sqlSession.selectList(NAMESPACE+"list", rowMaker);
		return ar;
	}

	// write
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
		
	}

	// update
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"update", boardDTO);
	}

	// delete
	@Override
	public int boardDelete(int num) throws SQLException {
		return sqlSession.insert(NAMESPACE+"delete", num);
	}	
}
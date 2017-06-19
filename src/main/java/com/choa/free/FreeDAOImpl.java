package com.choa.free;


import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.RowMaker;

@Repository()
public class FreeDAOImpl implements BoardDAO{
	@Inject
	//만들어진 객체를 주입시켜주세요
	//private DataSource dataSource;
	private SqlSession sqlSession;
	private static final String NAMESPACE="FreeboardMapper.";
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	public int boardCount() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"count");
		
	}
	
	
	public int qnaHit(int num) throws Exception {
		return sqlSession.update(NAMESPACE+"hit",num);
	}
	// view
	@Override
	public BoardDTO boardView(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"view",num);
	}

	// list
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list",rowMaker);
	}

	// write
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"write",boardDTO);
	}

	// update
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update",boardDTO);
	}

	// delete
	@Override
	public int boardDelete(int num) throws SQLException {
		return sqlSession.delete(NAMESPACE+"delete");
	}


}

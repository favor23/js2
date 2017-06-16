package com.choa.free;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

@Repository()
public class FreeDAOImpl implements BoardDAO{
	@Inject
	//만들어진 객체를 주입시켜주세요
	private DataSource dataSource;
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	@Override
	public int boardCount() throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		
		String sql = "select nvl(count(num),0) from qna";
		
		
			st = con.prepareStatement(sql);
			
			rs=st.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			DBConnector.disConnect(rs, st, con);
		
		return count;
		
	}
	
	
	public int qnaHit(int num) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "update qna set hit = hit+1 where num=?";
		
		
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			
			result = st.executeUpdate();
	
			DBConnector.disConnect(st, con);
		
		
		return result;
	}
	// view
	@Override
	public BoardDTO boardView(int num) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		FreeDTO freeDTO = null;
		ResultSet rs = null;
		
		String sql = "select * from qna where num=?";
		
		
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			rs = st.executeQuery();
			if(rs.next()) {
				freeDTO = new FreeDTO();
				freeDTO.setNum(rs.getInt("num"));
				freeDTO.setWriter(rs.getString("writer"));
				freeDTO.setTitle(rs.getString("title"));
				freeDTO.setContents(rs.getString("contents"));
				freeDTO.setReg_date(rs.getDate("reg_date"));
				freeDTO.setHit(rs.getInt("hit"));
			}
			DBConnector.disConnect(rs, st, con);
		
		return freeDTO;
	}

	// list
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		ResultSet rs = null;
		FreeDTO freeDTO = null;
		String sql = "select * from " + "(select N.*, rownum R from " + "(select * from qna "
					+"order by num desc)N) " 
				+ "where R between ? and ?";
		st = con.prepareStatement(sql);	
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());

		rs = st.executeQuery();
		while (rs.next()) {
			freeDTO = new FreeDTO();
			freeDTO.setNum(rs.getInt("num"));
			freeDTO.setWriter(rs.getString("writer"));
			freeDTO.setTitle(rs.getString("title"));
			freeDTO.setContents(rs.getString("contents"));
			freeDTO.setReg_date(rs.getDate("reg_date"));
			freeDTO.setHit(rs.getInt("hit"));

			ar.add(freeDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

	// write
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		ResultSet rs = null;

		String sql = "insert into qna values(qna_seq.nextval,?,?,?,sysdate,0)";

		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());

		result = st.executeUpdate();
		st.close();

		sql = "select max(num) from qna";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();

		rs.next();
		result = rs.getInt(1);

		DBConnector.disConnect(st, con);

		return result;
	}

	// update
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "update qna set title=?,contents=? where num=?";

		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());

		result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;
	}

	// delete
	@Override
	public int boardDelete(int num) throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "delete qna where num=?";

		st = con.prepareStatement(sql);
		st.setInt(1, num);

		result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;
	}


}

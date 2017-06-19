package com.choa.free;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

@Service
public class FreeSeviceImpl implements BoardService{

	@Inject
	private FreeDAOImpl freeDAO;

	
	public int boardCount() throws Exception{
		return freeDAO.boardCount();		
	}
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker=new PageMaker(curPage, 30);
		return freeDAO.boardList(pageMaker.getRowMaker());
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return freeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return freeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return freeDAO.boardDelete(num);
	}
}

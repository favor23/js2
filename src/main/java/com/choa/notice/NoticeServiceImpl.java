package com.choa.notice;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

@Service
//NoticeService noticeService=new NoticeService();
public class NoticeServiceImpl implements BoardService{

	@Inject
	//@Resource(name="noticeDAO")
	private NoticeDAOImpl noticeDAO;
	
	/*//Constructor
	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO=noticeDAO;
	}		*/

	public int boardCount() throws Exception{
		return noticeDAO.boardCount();
	}
	
	//view
	@Override
	public BoardDTO boardView(int num) throws Exception{
		return noticeDAO.boardView(num);
	}
	
	//List
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		
		int result=noticeDAO.boardCount();
		PageMaker pageMaker=new PageMaker(curPage);
		return noticeDAO.boardList(pageMaker.getRowMaker());
	}
	
	//write
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception{
		noticeDAO.noticeHit(boardDTO.getNum());
		return noticeDAO.boardWrite(boardDTO);
	}
	
	//update
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.boardUpdate(boardDTO);
	}
	
	//Delete
	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
}

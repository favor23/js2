package com.choa.notice;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;






public class NoticeDAOImplTest extends MyAbstractTest{
	@Inject
	private NoticeDAOImpl dao;
	
	@Test
	public void connectonTest() throws Exception{
		/*BoardDTO boardDTO=dao.boardView(29);
		System.out.println(boardDTO.getTitle());
		assertNotNull(boardDTO);*/
		
		/*NoticeDTO noticeDTO=new NoticeDTO();
		noticeDTO.setNum(29);
		noticeDTO.setWriter("choa");
		noticeDTO.setTitle("test");
		noticeDTO.setContents("싸인회");
		int result=dao.boardUpdate(noticeDTO);
		System.out.println(result);
		assertEquals(1, result);*/
		
		/*int result=dao.boardDelete(29);
		System.out.println(result);
		assertEquals(1, result);*/
		
		
	}
}
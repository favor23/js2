package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.util.PageMaker;




public class NoticeDAOImplTest extends MyAbstractTest{
	
	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Test
	public void test() throws Exception {
		PageMaker pageMaker=new PageMaker(1, 10);
		
		List<NoticeDTO> ar=noticeDAO.noticeList(pageMaker.getRowMaker());
		assertEquals(0, ar.size());
		
		/*NoticeDTO noticeDTO=noticeDAO.noticeView(999);
		System.out.println(noticeDTO.getTitle());
		assertNotNull(noticeDTO);*/
	}
	
	//@Test
	public void test2()throws Exception{
		int result=noticeDAO.noticeDelete(8);
		assertEquals(1, result);
	}
}
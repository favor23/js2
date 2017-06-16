package com.choa.notice;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;




public class NoticeDAOTest extends MyAbstractTest{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		NoticeDTO noticeDTO=noticeDAO.noticeView(999);
		System.out.println(noticeDTO.getTitle());
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void test2()throws Exception{
		int result=noticeDAO.noticeDelete(8);
		assertEquals(1, result);
	}
}
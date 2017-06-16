package com.choa.js2;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;


@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Inject //인젝트는 type으로 찾는다
	private NoticeServiceImpl noticeService;
	
	
	@RequestMapping(value="noticeList")
	public String noticeList(Model model,@RequestParam(defaultValue="1") Integer curPage) throws Exception{
		
		List<BoardDTO> ar=noticeService.boardList(curPage);
		model.addAttribute("list",ar);
		model.addAttribute("board","notice");
		
		return "board/boardList";
	}


	@RequestMapping(value="noticeView")
	public void noticeView(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO=(NoticeDTO) noticeService.boardView(num);
		model.addAttribute("dto",noticeDTO);
	}
	
	@RequestMapping(value="noticeWrite")
	public void noticeWrite(NoticeDTO noticeDTO){
		
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO,Model model,RedirectAttributes rd) throws Exception{
		int result=noticeService.boardWrite(noticeDTO);
		String message="FAIL";
		if(result>0){
			message="SUCCESS";			
		}
		
		//주소창에 남지않는다
		rd.addFlashAttribute("message", message);
		
		
		//model.addAttribute("message",message);
		
		return "redirect:/notice/noticeList";
		//return "redirect:noticeList?curPage=2";
		/*this.noticeList(model, 1);
		return "notice/noticeList";*/
	}
	
	@RequestMapping(value="noticeUpdate")
	public void noticeUpdate(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO=(NoticeDTO) noticeService.boardView(num);
		model.addAttribute("dto",noticeDTO);
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO,Model model) throws Exception{
		int result=noticeService.boardUpdate(noticeDTO);
		this.noticeView(noticeDTO.getNum(), model);
		return "notice/noticeView";
	}
	
	@RequestMapping(value="noticeDelete")
	public String noticeDelete(Integer num,Model model,RedirectAttributes rd) throws Exception{
		int result=noticeService.boardDelete(num);
		String message="FAIL";
		if(result>0){
			message="SUCCESS";			
		}
		rd.addAttribute("message", message);
		
		return "redirect:/notice/noticeList";
	}	
}

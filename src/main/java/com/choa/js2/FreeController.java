package com.choa.js2;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.free.FreeDTO;
import com.choa.free.FreeSeviceImpl;
import com.choa.notice.NoticeDTO;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;

@Controller
@RequestMapping(value="/free/**")
public class FreeController {
	
	@Inject
	private FreeSeviceImpl freeService;
	
	@RequestMapping(value="freeList", method=RequestMethod.GET)
	public String boardList(Model model,@RequestParam(defaultValue="1") Integer curPage) throws Exception{

		PageMaker pageMaker=new PageMaker(curPage);
		int totalCount=freeService.boardCount();
		MakePage makePage=pageMaker.getMakePage(totalCount);
		model.addAttribute("list",freeService.boardList(curPage));
		model.addAttribute("board","free");
		model.addAttribute("makePage", makePage);		
		return "free/freeList";		
	}
	
	@RequestMapping(value="freeVeiw", method=RequestMethod.GET)
	public void freeVeiw(Integer num,Model model) throws Exception{		
		model.addAttribute("dto",(FreeDTO)freeService.boardView(num));		
	}	

	@RequestMapping(value="freeWrite",method=RequestMethod.GET)
	public String freeWrite_form(){
		return "free/freeWrite";
	}
	
	@RequestMapping(value="freeWrite", method=RequestMethod.POST)
	public String freeWrite(FreeDTO freeDTO,Model model,RedirectAttributes rd) throws Exception{
		int result=freeService.boardWrite(freeDTO);
		String message="FAIL";
		if(result>0){
			message="SUCCESS";			
		}		
		//주소창에 남지않는다
		rd.addFlashAttribute("message", message);		
		return "redirect:/free/freeList";
	}
	
	@RequestMapping(value="freeUpdate", method=RequestMethod.GET)
	public String freeUpdate_form(Integer num,Model model) throws Exception{
		FreeDTO freeDTO=(FreeDTO) freeService.boardView(num);
		model.addAttribute("dto",freeDTO);
		return "free/freeUpdate";		
	}
	
	@RequestMapping(value="freeUpdate", method=RequestMethod.POST)
	public String freeUpdate(){
		return "free/freeList";
	}
	
	
	
	
}

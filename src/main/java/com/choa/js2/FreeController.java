package com.choa.js2;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.free.FreeSeviceImpl;

@Controller
@RequestMapping(value="/free/**")
public class FreeController {
	
	@Inject
	private FreeSeviceImpl freeSevice;
	
	@RequestMapping(value="freeList", method=RequestMethod.GET)
	public String boardList(Model model,@RequestParam(defaultValue="1") Integer curPage) throws Exception{

		//List<BoardDTO> ar=freeService.boardList(curPage);
		model.addAttribute("list",freeSevice.boardList(curPage));
		model.addAttribute("board","free");
		
		return "board/boardList";		
	}
	
	@RequestMapping(value="freeVeiw", method=RequestMethod.GET)
	public void freeVeiw(){}
	
	@RequestMapping(value="freeWrite",method=RequestMethod.GET)
	public void freeWrite_form(){}
	
	@RequestMapping(value="freeWrite", method=RequestMethod.POST)
	public void freeWrite(){}
	
	@RequestMapping(value="freeUpdate", method=RequestMethod.GET)
	public void freeUpdate_form(){}
	
	@RequestMapping(value="freeUpdate", method=RequestMethod.POST)
	public void freeUpdate(){}
	
	
	
	
}

package com.choa.js2;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choa.free.FreeSevice;

@Controller
@RequestMapping(value="/free/**")
public class FreeController {
	
	@Inject
	private FreeSevice freeSevice;
	
	@RequestMapping(value="freeList", method=RequestMethod.GET)
	public void freeList(){}
	
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

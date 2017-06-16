package com.choa.free;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class FreeSevice {

	@Inject
	private FreeDAO freeDAO;
	
}

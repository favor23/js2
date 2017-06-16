package com.choa.free;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository()
public class FreeDAO {
	@Inject
	//만들어진 객체를 주입시켜주세요
	private DataSource dataSource;
}

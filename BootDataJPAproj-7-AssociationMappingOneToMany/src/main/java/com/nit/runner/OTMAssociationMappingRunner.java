package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.service.IOTOMAssociationMgmtService;

@Component
public class OTMAssociationMappingRunner implements CommandLineRunner {

	@Autowired
    private IOTOMAssociationMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Uncomment one method at a time to set
//		service.saveDataUsingParent();
		
	//	service.saveDataUsingChild();
		
	service.loadDataUsingParent();
		
		
		
	}

}

package com.freeway.test;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.freeway.entity.SlEngineResult;
import com.freeway.service.EngineResultService;

public class TestEngineResult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		EngineResultService engineresultService = new EngineResultService();
//		//engineresultService.queryForCondition(10, params);
//		List<SlEngineResult> engines  = new ArrayList<SlEngineResult>();
//		engines = engineresultService.getAll();
//		System.out.println(engines.size());
//		
		ApplicationContext context = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/dorado-home/app-context.xml");
		EngineResultService engineresultService=null;
		    
		    
	    //context= new ClassPathXmlApplicationContext("app-context.xml");  
		engineresultService=context.getBean(EngineResultService.class);
		    
		   
		DataSource dataSource=(DataSource) context.getBean(DataSource.class);
		System.out.println(dataSource);
		 
		List<SlEngineResult> engines  = new ArrayList<SlEngineResult>();
		engines = engineresultService.getAll();
		   
		System.out.println(engines.size());  
		    
		 
		  
		    
		    

	}

}

package generator.main;



import java.io.IOException;

import org.apache.logging.log4j.Logger;


import constants.Constants;
import entities.Project;
import generator.util.LogBuilder;

//logger.info("this is info");
//logger.error("this is error");
//logger.warn("this is warn");
//logger.fatal("this is fatal");
public class Main {
	
	
	public static void main(String[] args)  {
		
		 
		
		System.out.println("***Reading properties*********");
		if(args.length!=0) {
		
			Constants.readProp(args[0]);
		}else {
			throw new RuntimeException("Next time use correct argument!!! Bye!!!");
		}
		Constants.setLogger(LogBuilder.build(Constants.getSourcePath()));
		Logger logger=Constants.getLogger();
		logger.info("HELLO!!!!! Logger is here!!! See the properties bellow ");
		
		
		
			
		try {
			Project project=Project.getProject(args[0]);
			project.writeResults();
		} catch (IOException e) {
			logger.debug(e);
		}
		
}
		
		

}

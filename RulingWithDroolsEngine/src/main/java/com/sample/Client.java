package com.sample;

import java.io.File;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Client {
	
	public static final double MIN_AVERAGE_BALANCE = 0;
	public static final double MAX_AVERAGE_BALANCE = 6000;
	
	public static final double MIN_INCOME = 0;
	public static final double MAX_INCOME = 1000;
	
	public static final double MIN_LENDING = 0;
	public static final double MAX_LENDING = 30000;
	
	public static final double MIN_INVESTMENTS = 0;
	public static final double MAX_INVESTMENTS = 15000;

	public static void main(String[] args) throws JAXBException {
		 
  
    	Accounts accounts = new Accounts();
    	Random r = new Random();
    	
    	JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		
		accounts = (Accounts) jaxbUnmarshaller.unmarshal( new File("src/main/resources/files/inputFile.xml") );
	
    	
    	long startTime = System.currentTimeMillis();
    
    	
    	for (Account account: accounts.getAccounts()) {
    	ConditionActivator conditionInstance = new ConditionActivator();
    	conditionInstance.execute(account);
    	}
    	
   
    	File outputFile = new File("src/main/resources/files/outputFile.xml");
		jaxbMarshaller.marshal(accounts, outputFile);
    	
    	long endTime = System.currentTimeMillis();
    	System.out.println(endTime - startTime);
    		
	 }
	
		 
	}



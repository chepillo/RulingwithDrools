package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;


public class DiscountCalculator {
	private KieSession kSession;
	private FactHandle ruleHandle;

	
	public void execute(Customer customer){
		 if (null == kSession) {
			// load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");
	        	 kSession.fireAllRules();
	        	 
//	        	 System.out.println("discount: " + fact.getDiscount());
        	
		 }
		 
	}
	
	
	
	
	
		 
}

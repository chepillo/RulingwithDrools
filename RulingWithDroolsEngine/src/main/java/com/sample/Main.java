package com.sample;

public class Main {

	public static void main(String[] args) {
		
		//create fact
	   	 Customer fact = new Customer();
	   	 fact.setMaritalStatus("married");
	   	 fact.setDrivingStatus("good");
	   	 fact.setAccountAge(8);
	   	 fact.setDiscount(0);
	   	 
		 DiscountCalculator instanceDiscount = new DiscountCalculator();
		
		 Long timeIni =  System.currentTimeMillis();
		 for(int i=0;i<3000;i++)
		 {
			instanceDiscount.execute(fact);
		 }
		 Long timeFin = System.currentTimeMillis();
		 System.out.println(timeFin - timeIni);
	}

}

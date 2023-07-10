package fetch_data;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FectchDataTutorial {
	
	JsonPath js=new JsonPath(BodyDefination.getBody());
	int sum=0;
	
	@Test (priority = 1)
	public void printCoursesNo()
	{
	
	int size = js.getInt("courses.size()");
	System.out.println(size);
	System.out.println("==============================TC 1========================");
	}
	
	
	@Test  (priority = 2)
	public void fetchPurchaseAmmount() 
	{
		
	String PurchaseAmmt = js.getString("dashboard.purchaseAmount");	
		
	System.out.println(PurchaseAmmt);
	System.out.println("==============================TC 2========================");

	}
	
	
	@Test  (priority = 3)
	public void printFirstCourceTitle()
	{
		String title = js.getString("courses[0].title");
		System.out.println(title);
		System.out.println("==============================TC 3========================");

	}
	
	
	@Test  (priority = 4)
	public void PrintAllTitleAndPrice()
	{
		
		
	  int size = js.getInt("courses.size()");
	  for(int i=0;i<size;i++)
	  {
		 String titles = js.getString("courses["+i+"].title");  
		 int prices = js.getInt("courses["+i+"].price");
		 System.out.println(titles+"  :  "+prices);

	  }
		System.out.println("==============================TC 4========================");

	}
	
	
	  @Test  (priority = 5)
	 public void printCopiesOfRPA()
	 {
	  int size = js.getInt("courses.size()");  
		  
	  for (int i=0;i<size;i++) 
	  {
		 String mytitle = js.getString("courses["+i+"].title"); 
		 if (mytitle.equalsIgnoreCase("rpa") ) {
			
			 String mycopies = js.getString("courses["+i+"].copies"); 
              System.out.println(mycopies);
		}
		  
	  }
		System.out.println("==============================TC 5========================");
	 }
	  
	  @Test  (priority = 6)
	  public void varifySumofAllCourcePriceWithPurchasAmmount()
	  
	  {
		  
		int size = js.getInt("courses.size()");  
		for(int i=0;i<size;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			
			sum=sum+price*copies;
			
			
		}
		  System.out.println("All courses Sum is :"+sum);
			int purch_Ammt = js.getInt("dashboard.purchaseAmount");
			 System.out.println("All purch_Ammt Sum is :"+purch_Ammt);
			Assert.assertEquals(sum, purch_Ammt ,"Values are not mathcing TC is Failed");
		
		System.out.println("==============================TC 6========================");
  
	  }
	  
		
	}
	
	
	
	


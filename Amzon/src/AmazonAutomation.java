import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //Navigate to Amazon Website
		driver.get("http://www.amazon.in");			
		
				driver.manage().window().maximize();
				//search for Refrigerators
		        driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']")).sendKeys("Refrigerator");
		        driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']")).sendKeys(Keys.ENTER);
		        
		        //no.of refrigerators in one page
		        int size=driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal")).size();
		        System.out.println("Refrigerators in one page: "+size);
		 		 System.out.println();

		        
		        for(int i=0;i<size;i++)
		        {
		        	String str=driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal")).get(i).getText();
		        	//find the specific refrigerator
		        	if(str.contains("Samsung 198 L 4"))
		        	{
		        		//print product name
		        	System.out.println("Product Name: "+str);
			 		 System.out.println();

			        String price=driver.findElements(By.cssSelector(".a-price-whole")).get(i).getText();
			        //print product price
			        System.out.println("Product Price:"+price);
			 		 System.out.println();
			 		 driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal")).get(i).click();	
			 		 //go to another child window
			        Set<String> ids=driver.getWindowHandles();
					 Iterator<String> it=ids.iterator();
					 String parentId=it.next();
					 String childId=it.next();
					 driver.switchTo().window(childId);
					 //actual product price
					 String price1=driver.findElement(By.cssSelector(".a-size-medium.a-color-price.priceBlockBuyingPriceString")).getText();
					 //compare product price and home page price
					 if(price.contains(price1))
					 {
						 System.out.println("Price are Matching!!");
				 		 System.out.println();

					 }
					 break;
		        	}
		        }        
		    //compare capacity of product with other products      
		  int size2=driver.findElements(By.cssSelector(".comparison_other_attribute_row")).size();
		  for(int i=0;i<size2;i++)
		  {
			  String capacity=driver.findElements(By.cssSelector(".comparison_other_attribute_row")).get(i).getText();
			  if(capacity.contains("Capacity:"))
			  {
				  System.out.println(capacity);
			 		 System.out.println();

				  break;
			  }
		  }
		    //compare item weight of product with other products      

		  int size3=driver.findElements(By.cssSelector(".comparison_other_attribute_row")).size();
		  for(int k=0;k<size3;k++)
		  {
		 	 String weight=driver.findElements(By.cssSelector(".comparison_other_attribute_row")).get(k).getText();
		 	 if(weight.contains("Item Weight:"))
		 	 {
		 		 System.out.print(weight);
		 		 System.out.println();
		 		 break;
		 	 }
		  }

}
}
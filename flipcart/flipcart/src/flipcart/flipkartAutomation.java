package flipcart;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class flipkartAutomation{
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	  //Navigate to flipkart Website

  driver.get("http://www.flipkart.com/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.className("_2doB4z")).click();
  Actions act = new Actions(driver);
  //search for refrigerators
 driver.findElement(By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("Refrigerator");
  driver.findElement(By.xpath("//*[@id=\'container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys(Keys.ENTER);
  //check no.of refrigerators in one page
 int size=driver.findElements(By.cssSelector("._4rR01T")).size();
 System.out.println("Refrigerators in one page: "+size);
 System.out.println();
 for(int i=0;i<size;i++)
 {
	
	 String str=driver.findElements(By.cssSelector("._4rR01T")).get(i).getText();
	 //check specific refrigerator available or not 
	 if(str.contains("SAMSUNG 198 L "))
	 {
		 //print product name
 		 System.out.println("Product Name: "+str);
 		 System.out.println();

		 String  price=driver.findElements(By.cssSelector("._30jeq3._1_WHN1")).get(i).getText();
		 //print product price
		 System.out.println("Product Price:"+price);
		 System.out.println();

		 driver.findElements(By.cssSelector("._4rR01T")).get(i).click();
		 //go for another child window
		 Set<String> ids=driver.getWindowHandles();
		 Iterator<String> it=ids.iterator();
		 String parentId=it.next();
		 String childId=it.next();
		 driver.switchTo().window(childId);
		 String price1=driver.findElement(By.cssSelector("._30jeq3._16Jk6d")).getText();
		 //check price matching 
		 if(price.contains(price1))
		 {
			 System.out.println("Price are Matching!!");
			 System.out.println();

		 }
		 break;
	 }
 }
 
 driver.findElement(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/span/label/div")).click();
 driver.findElement(By.xpath("//*[@id=\'container\']/div/div[4]/div/a")).sendKeys(Keys.ENTER);

 
driver.findElement(By.cssSelector(".RguR9P")).click();
WebDriverWait d=new WebDriverWait(driver,10);
d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[4]")));
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[4]")).click();

driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[1]")).click();
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]")).click();


driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[1]")).click();
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[17]")).click();

driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[1]")).click();
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[3]")).click();

driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div[1]")).click();
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div[27]")).click();

driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[3]/div[1]")).click();
driver.findElement(By.xpath("//*[@id=\'fk-compare-page\']/div/div/div/div[1]/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[3]")).click();

//compare capacity of product with another products 

int size1=driver.findElements(By.cssSelector(".row.CQXY4c._3T4CNT")).size();
 for(int j=0;j<size1;j++)
	 
 {
	 String capacity=driver.findElements(By.cssSelector(".row.CQXY4c._3T4CNT")).get(j).getText();
	 if(capacity.contains("Capacity"))
	 {
		 System.out.print(capacity);
		 System.out.println();
		 break;

	 }
 }
//compare weight of product with another products 

 int size2=driver.findElements(By.cssSelector(".row.CQXY4c._3T4CNT")).size();
 for(int k=0;k<size2;k++)
 {
	 String weight=driver.findElements(By.cssSelector(".row.CQXY4c._3T4CNT")).get(k).getText();
	 if(weight.contains("Weight"))
	 {
		 System.out.print(weight);
		 System.out.println();
		 break;
	 }
 }
 

 
}
}
package Selenium.Automation_StandAlone;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.*;
public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("deepranjal@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pranjal@123");
		driver.findElement(By.name("login")).click();
		List<WebElement> allLink = driver.findElements(By.cssSelector(".mb-3"));
		allLink.stream().filter(product->product.getText().equals("ZARA COAT 3"));
		Thread.sleep(1000);
		WebElement w=allLink.stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		w.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait waitforelemnt = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitforelemnt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role]")));
		driver.findElement(By.xpath("(//button/i[@class='fa fa-shopping-cart'])[1]")).click();	
		waitforelemnt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, "c://downloads");
		List<WebElement> fromCart=	driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean a=	fromCart.stream().anyMatch(Cart->Cart.getText().equals("ZARA COAT 3"));
		Assert.assertTrue(a);
        System.out.println(w+"yes");
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions mouse = new Actions(driver);
		mouse.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		waitforelemnt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
	String as=	driver.findElement(By.xpath("(//section[@class='ta-results list-group ng-star-inserted']//button)[2]")).getText();	
		driver.findElement(By.xpath("(//section[@class='ta-results list-group ng-star-inserted']//button)[2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
//		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
//		ArrayList <WebElement> ab=(ArrayList<WebElement>) driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
//		//Iterator<WebElement> s= ab.iterator();
//		for(int i=0;i<ab.size();i++)
//		{
//			if(ab.get(i).getText().equalsIgnoreCase("India"))
//			{
//				ab.get(i).click();
//			}
//		}
	}

}

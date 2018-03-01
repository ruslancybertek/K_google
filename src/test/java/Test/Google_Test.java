package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_Test {
	WebDriver driver;
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("kia"+Keys.ENTER);
		driver.findElement(By.xpath("//a[@href='http://www.kia.com/us/en/home']")).click();
		driver.findElement(By.xpath("//div[@class='slick-slide slick-active'][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='title' and contains(text(),'2018 Sorento')]")).click();
		WebElement price=driver.findElement(By.className("chapter-header-value"));
		String SorentoPrice=price.getText().replace("*", "");
		System.out.println("Kia Sorento price is: " + SorentoPrice);
		String actual=driver.getTitle();
		String expected="Sorento";
		Assert.assertTrue(actual.contains(expected));
		
				
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
		
	}

}

package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/hari/Downloads/chromedriver");
		WebDriver drv = new ChromeDriver();

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drv.manage().window().maximize();

		drv.get("https://nunzioweb.com/iframes-example.htm");

		int iFrameSize = drv.findElements(By.tagName("iframe")).size();
		System.out.println("iFrame size: "+ iFrameSize);
		
		drv.switchTo().frame(0); // switching to first frame
		drv.findElement(By.xpath("//*[@id=\"mep_0\"]/div/div[3]/div[3]/button")).click();  // mute 
		
		Thread.sleep(20000);
		
		
		drv.switchTo().defaultContent();   // it comes out 1st frame 
		drv.switchTo().frame(2); // switching to third frame
		
		drv.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/span/a")).click(); // auto scroll on/off button - click
		
		Thread.sleep(20000);
		
		drv.switchTo().defaultContent(); // coming out of the frame 3
		drv.switchTo().frame(0); // switching to first frame
		
		drv.findElement(By.xpath("//*[@id=\"mep_0\"]/div/div[3]/div[3]/button")).click(); //unmutes
		
		drv.close();
		drv.quit();

	}

}

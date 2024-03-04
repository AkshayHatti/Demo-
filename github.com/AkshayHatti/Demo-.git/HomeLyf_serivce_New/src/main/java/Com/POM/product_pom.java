package Com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class product_pom {

	
	AndroidDriver driver;
	public product_pom(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath=("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"))
			private WebElement product;
	
	
//	//click on "+" sign and wait for the element to b clockable
//	WebElement plusSign=waitForElementToBeClickable(driver, By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"),10);
//	plusSign.click();
//	
//	
	
	
	
	public WebElement clickpro() throws InterruptedException {
		 Thread.sleep(3000);
		product.click();
		
		return product;
	}



	}

	


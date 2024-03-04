package Com.POM;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class register_pom {
	AndroidDriver driver;
	public register_pom(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility=("Register"))
	private WebElement register;
	
	@AndroidFindBy(xpath=("(//android.widget.EditText)[1]"))
	private WebElement name;
	
	@AndroidFindBy(xpath=("(//android.widget.EditText)[2]"))
	private WebElement email;
	
	@AndroidFindBy(xpath=("(//android.widget.EditText)[3]"))
	private WebElement pd;
	
	//@AndroidFindBy(xpath=("(//android.widget.Button[@content-desc=\"Sign Up\"]"))
	
	
	//@AndroidFindBy(xpath=("(//android.widget.Button)[4]"))
	@AndroidFindBy(accessibility=("Sign Up"))
	private WebElement signupbtn;
//	=waitForElementTobeClickable(driver,)
//	WebElement signup=waitForElementTobeClickable(driver,)

	
	public WebElement btn() {
		register.click();
	
		return register;
			
	}
	public void verifyname(String name1) {
		name.click();
name.sendKeys(name1);		
	}
	
//	
//	public WebElement getName() {
//		return name;
//	}
//	
	public void verifyemail(String email1) {
		email.click();
	email.sendKeys(email1);
		
	}
	public void verifypass(String pass) {
		pd.click();
		pd.sendKeys(pass);
	}
	
	public WebElement verifyregister() {
		
		signupbtn.click();
		return signupbtn;
	
	}
}

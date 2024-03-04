package testclass;

import java.time.Duration;

import org.testng.annotations.Test;

import com.utility.BaseClass;

import Com.POM.product_pom;
import Com.POM.signIn_page;

public class signIn_test  extends BaseClass{
	
	
	
	//@Test(priority =0)
public void verifytest() throws InterruptedException {
		signIn_page sp=new signIn_page(driver);
		
		sp.entermail("amit@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.hideKeyboard();
		
		sp.enterpass("Amit");	
		
		driver.hideKeyboard();
		
		sp.signinclick();
		
		Thread.sleep(3000);
		
}
	
	
//	@Test(priority =1)
	public void verifyproduct() throws InterruptedException {
		
		product_pom pro =new product_pom(driver);
		pro.clickpro();
		
		
	}
	
}

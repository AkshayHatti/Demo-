package testclass;

import java.io.IOException;

import org.testng.annotations.Test;

public class executionText   extends registerTest{
	
	
	

	@Test(priority =0)
	public void test_001() throws InterruptedException, IOException {
		registerTest rg=new registerTest();
		rg.validverifytest();
	}
}

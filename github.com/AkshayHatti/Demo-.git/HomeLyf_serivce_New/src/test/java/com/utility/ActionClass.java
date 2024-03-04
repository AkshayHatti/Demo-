package com.utility;


	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

	public class ActionClass  extends BaseClass{
		
		AndroidDriver driver;
		
		public void AndroidActions(AndroidDriver driver) {
			
			this.driver=driver;
		}
		

		public void longPressAction(WebElement ele)  {
			
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
					"duration",2000));
		}
		public void scrollToEndAction() {
			boolean canScrollMore;
			do {
				canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
						"left",100,"top",100,"width",200,"height",200,
						"direction", "down","percent",3.0));
			}while(canScrollMore);
		}
		
		public void swipeAction(WebElement ele , String direction) {
			
			((JavascriptExecutor)driver).executeScript("mobile : swipeGeture", ImmutableMap.of(
					"elementId",((RemoteWebElement)ele).getId(),
							"direction","left","percent",0.75));
		}

	//sendkeys 
		public static void custom_Sendkeys(WebElement element, String value, String fieldname) {
			try {
				element.sendKeys(value);
				System.out.println(fieldname+" = Value successfully send = "+value);
			}catch(Exception e) {
				System.out.println("Unable to send value"+e);
			}
		}

		
		
		// click
		public static void custom_Click(WebElement element,String fieldname )
		{
			try {
				
				element.click();
				System.out.println("clicked Successfully :"+fieldname);
				
			}catch(Exception e) {
				System.out.println("Unable to click"+e);
			}
			
		}
				
	 public static void scrollByvisibleOfElement (WebDriver driver ,WebElement ele) {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", ele);
	 }
	 
	 public static void click(WebDriver ldriver, WebElement locatorName) {
		 Actions act = new Actions(ldriver);
		 act.moveToElement(locatorName).click().build().perform();
		 
	 }
	 
	 public static boolean findElement (WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag =true;
			
		}catch (Exception e) {
			//System.out.println("Location not found: "+locatorName);
			flag =false;
			
		}finally {
			if(flag) {
				System.out.println("Successfully Found element at");
				
			}else {
				System.out.println("Unable to locate  element at");
			}}
		return flag;
		}
	 

	 public static boolean  isSelected(WebDriver ldriver , WebElement ele) {
		 boolean flag = false;
	 flag =findElement (ldriver ,ele);
	 if(flag) {
		 flag =ele.isSelected();
		 if(flag) {
			 System.out.println("The element is Selected");
		 }else {
			 System.out.println("The element is not Selected");
		 }
	 }else {
		 System.out.println("Not selected");
		 
	 }
	return flag;
	 }
	 
	public static boolean isEnabled(WebDriver ldriver ,WebElement ele) {
	boolean flag =false;
	flag=findElement(ldriver ,ele);
	if (flag) {
		flag=ele.isEnabled();
		if (flag) {
			System.out.println("THe element is Enabled");
		}else {
			System.out.println("The element is not  Enable");
		}
	}else { 
		System.out.println("Not Enabled");
		}
	return flag;
		}

	//Type text at location
	//@param locatorName
	//@param text
		//@return - true/false
	//@throws Throwable

	public static boolean type (WebElement ele , String text) {
		
		boolean flag =false;
		try {
			flag =ele.isDisplayed();
			ele.clear();
			
			ele.sendKeys(text);
			//logger.info("Entered text :"+text);
			flag =true;
		} catch (Exception e) {
			System.out.println("Location Not FOund");
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("SUccessfully entered value");
			}else {
				System.out.println("Unable to enter value");
				
			}}
			return flag;
		}
		
			public static boolean selectBySendkeys(WebElement ele, String value){
				boolean flag = false;
				try {
					ele.sendKeys(value);
					flag =true;
					return true;
				}catch (Exception e) {
					return false;
				} finally {
					if (flag) {
						System.out.println("Select value from DropDown");
					}else {
						System.out.println("Not selected value from the DropDown");
						
					}
				}
			}
		/**
		 * select value from DropDown byusing selectBYIndex
		 * @param locator : Action to be performed on element (Get if from   
		 *   repository)
		 *   @param index : Index of value with to select from dropdown list
		 *   @param locatorName : Meaningful name to the element (Ex.Year Dropdown ,Listbox etc..)
		 *   

		 */
				
	public static boolean selectByIndex(WebElement element ,int index) {
		boolean flag =false;
		try {
			Select s =new  Select(element);
			s.selectByIndex(index);
			flag =true;
			return true;
		}catch (Exception e) {
			return false;
		}
		finally {
			if(flag) {
				System.out.println("Option selected by Index");
			}else {
				System.out.println("Option not selected by Index");
				
			}
		}
	}

	/**
	 * select value from DD by using value
	 * @param locator : Action to be performed on element (Get it from  repository)
	 * 
	 * @param value : Value wish to select from dropdown list.
	 * 
	 * @paramlocatorName : Meaningful name to hte element (ex.year Dropdown  ,Listbox etc...
	 * 
	 * 
	 
	 */

	public static boolean selectByValue(WebElement element ,String value) {
		boolean flag =false;
		try {
			Select s = new Select (element);
			s.deselectByValue(value);
			flag = true;
			return true;
		}
		catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by Value");
			}else {
				System.out.println("Option not selected by value");
				
			}
			
		}
	}
	
	
	/**
	 * select value from DD by using selectByvisibleText
	 * @param locator : Action to be performed on element (Get it from  repository)
	 * 
	 * @param value : Value wish to select from dropdown list.
	 * 
	 * @param  visibletext :VisibleText with to select from dropdown list
	 * 
	 * 
	 
	 */
	public static boolean selectByVisibleText(WebElement ele ,String visibletext) {
		boolean flag =false;
		try {
			Select s = new Select (ele);
			s.deselectByValue(visibletext);
			flag = true;
			return true;
		}
		catch (Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Option selected by VisibleText");
			}else {
				System.out.println("Option not selected by VisibleText");
				
	}
		}
		
		
//	public static boolean mouseHoverByJavaScript(WebElement locator) {
//		boolean flag = false;
//		try {
//			WebElement mo =locator;
//			String javaScript ="var evObj = document"
//		}
//	}
//	}


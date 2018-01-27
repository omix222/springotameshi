package com.example.takahashi.springotamashi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.DEFINED_PORT )
@AutoConfigureMockMvc
public class HelloControllerTest {

	private WebDriver driver;
	private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.gecko.driver", "exe/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
 
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
    @Test
    public void testController() throws Exception {
        driver.get("http://localhost:8080/");
    	try {
    	      assertEquals("電卓アプリ", driver.findElement(By.xpath("/html/body/h1")).getText());
    	    } catch (Error e) {
    	      verificationErrors.append(e.toString());
    	    }
    }
}
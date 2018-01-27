package com.example.takahashi.springotamashi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriverBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.DEFINED_PORT )
@AutoConfigureMockMvc
//@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
public class HelloControllerTest {

//    @Autowired
//    private MockMvc mvc;
	//@Autowired
	private WebDriver driver;
	private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

//    @Value("${local.server.port}")
//	int port;
// 
//	@Value("${server.context-path}")
//	String context;
 
	
 
	//Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "seleniumtest", Long.toString(System.currentTimeMillis()));
 
	//@SneakyThrows(IOException.class)
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.gecko.driver", "exe/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Files.createDirectories(tempDir);
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.download.dir", tempDir.toString());
//		profile.setPreference("browser.download.useDownloadDir", true);
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/html, text/plain, application/vnd.ms-excel, text/csv, application/zip, text/comma-separated-values, application/octet-stream");
//		driver = new FirefoxDriver();
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
//
//        String text = driver.findElement(By.id("h1id")).getText();
//        assertThat(text, is("電卓アプリ"));
    	try {
    	      assertEquals("電卓アプリ", driver.findElement(By.xpath("/html/body/h1")).getText());
    	    } catch (Error e) {
    	      verificationErrors.append(e.toString());
    	    }
    }
//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("text/html;charset=UTF-8"))
//                .andExpect((ResultMatcher) xpath("/html/body/h1").string("電卓アプリ"))
//                .andExpect((ResultMatcher) xpath("/html/body/from/input[2]").string("計算"));
//    }
}
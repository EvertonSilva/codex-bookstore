package br.com.codexbookstore.control;

import br.com.codexbookstore.testHelpers.BookHtmlForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppControllerTestSuite {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer errors = new StringBuffer();

    public AppControllerTestSuite() {
        System.setProperty("webdriver.gecko.driver", "/home/everton/Applications/geckodriver");
    }

    @Before
    public void setUp() {
        // setup things to tests
        baseUrl = "http://localhost:8080/codex-bookstore";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testShowCorrectFields() {
        driver.get(baseUrl + "/books/new");
        WebElement el = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_TITLE));
        assertEquals("input", el.getTagName());
    }

}

package br.com.codexbookstore.control;

import br.com.codexbookstore.testHelpers.BookHtmlForm;
import br.com.codexbookstore.testHelpers.CodexHomePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AppControllerTestSuite {
    private WebDriver driver;
    private String baseUrl;

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
    public void testVisitNewBookPage() throws Exception {
        driver.get(baseUrl);
        WebElement linkToNewBook = driver.findElement(By.linkText(CodexHomePage.LOC_LNK_NEW_BOOK));
        linkToNewBook.click();
        assertEquals(BookHtmlForm.LOC_PAGE_TITLE, driver.getTitle());
    }

    @Test
    public void testSaveBook() throws Exception {
        driver.get(baseUrl);
        WebElement linkToNewBook = driver.findElement(By.linkText(CodexHomePage.LOC_LNK_NEW_BOOK));
        linkToNewBook.click();
        fillNewBookForm();

        WebElement submitBtn = driver.findElement(By.cssSelector(BookHtmlForm.LOC_BTN_BOOK_SAVE));
        submitBtn.click();

        assertEquals(baseUrl + "/books/list?operation=retrieve", driver.getCurrentUrl());
    }

    private void fillNewBookForm() {
        // get form elements
        WebElement bookTitle = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_TITLE));
        WebElement authorSelectTag = driver.findElement(By.cssSelector(BookHtmlForm.LOC_SET_BOOK_AUTHOR));
        WebElement categorySelectTag = driver.findElement(By.cssSelector(BookHtmlForm.LOC_SET_BOOK_CATEGORY));
        WebElement publisherSelectTag = driver.findElement(By.cssSelector(BookHtmlForm.LOC_SET_BOOK_PUBLISHER));
        WebElement bookEdition = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_EDITION));
        WebElement bookYear = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_YEAR));
        WebElement bookPages = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_PAGES_NUM));
        WebElement bookSynposis = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_SYNOPSIS));
        WebElement bookHeight = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_HEIGHT));
        WebElement bookWidth = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_WIDTH));
        WebElement bookWeight = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_WEIGTH));
        WebElement bookDepth = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_DEPTH));
        WebElement bookISBN = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_ISBN));
        WebElement bookBarcode = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_BARCODE));
        WebElement priceGroupSelectTag = driver.findElement(By.cssSelector(BookHtmlForm.LOC_SET_BOOK_PRICE_GROUP));
        WebElement bookSalesMinValue = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_SALES_MIN_NUM));
        WebElement bookSalesPeriod = driver.findElement(By.cssSelector(BookHtmlForm.LOC_TXT_BOOK_SALES_PERIOD));
        WebElement salesPeriogSelecTag = driver.findElement(By.cssSelector(BookHtmlForm.LOC_SET_BOOK_SALES_PERIOD_UNIT));

        // fill inputs
        bookTitle.sendKeys("Notes from undergroud");
        Select authorSelect = new Select(authorSelectTag);
        authorSelect.selectByValue("1");
        Select categorySelect = new Select(categorySelectTag);
        categorySelect.selectByValue("2");
        Select publisherSelect = new Select(publisherSelectTag);
        publisherSelect.selectByValue("1");
        bookEdition.sendKeys("1st edition");
        bookYear.sendKeys("2000");
        bookPages.sendKeys("152");
        bookSynposis.sendKeys("Lorem ipsum dolor sit amet");
        bookHeight.sendKeys("21");
        bookWidth.sendKeys("14");
        bookDepth.sendKeys("5");
        bookWeight.sendKeys("80");
        bookISBN.sendKeys("978-85-7326-185-1");
        bookBarcode.sendKeys("0123456789");
        Select priceGroupSelect = new Select(priceGroupSelectTag);
        priceGroupSelect.selectByValue("1");
        bookSalesMinValue.sendKeys("5");
        bookSalesPeriod.sendKeys("1");
        Select periodUnitSelect = new Select(salesPeriogSelecTag);
        periodUnitSelect.selectByValue("month");
    }

    private boolean validatePresence(String element) {
        try {
            driver.findElement(By.cssSelector(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

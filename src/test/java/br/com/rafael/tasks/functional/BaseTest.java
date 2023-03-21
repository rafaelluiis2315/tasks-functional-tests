package br.com.rafael.tasks.functional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BaseTest {

    protected static WebDriver driver;
    protected static final String URL_BASE = "http://localhost:8001/tasks";
    protected static final String CAMINHO_DRIVER = "src/test/java/resource/chromedriver/chromedriver-109.0.5414";

    @BeforeClass
    public static void StartTestClass() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
    }

}
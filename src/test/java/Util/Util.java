package Util;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class  Util {

    public static void ClickElementById(@NotNull WebDriver driver, String id){
        driver.findElement(By.id(id)).click();
    }

    public static void ClickElementByPath(@NotNull WebDriver driver, String path){
        driver.findElement(By.xpath(path)).click();
    }

    public static void WriteInElementById(@NotNull WebDriver driver, String id, String text){

        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public static void AssertElementById(@NotNull WebDriver driver, String id, String ExpectedValue){

        String FoundValue = driver.findElement(By.id(id)).getText();
        Assert.assertEquals(ExpectedValue, FoundValue);
    }
}

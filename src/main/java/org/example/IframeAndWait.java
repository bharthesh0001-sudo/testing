package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeAndWait {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
/*
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr"));


        WebElement textbas=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce"));

        textbas.clear();
        textbas.sendKeys("hello bharthesh ----iframe with wait");

        driver.switchTo().defaultContent();


 */

        driver.switchTo().frame(0);
        WebElement image=driver.findElement(By.xpath("//img"));
        image.click();
        driver.switchTo().defaultContent();
        driver.switchTo().alert().accept();
        System.out.println("alret handled succefully");




        System.out.println("done succesfsully");
        driver.quit();
    }

}

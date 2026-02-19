package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicDropdown {


    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("India");


       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> suggestion= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
        for (WebElement option:suggestion){
            String text=option.getText();
            if(text.equals("india")){
                option.click();
            }
        }



      driver.quit();
    }
}

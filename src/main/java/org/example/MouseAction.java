package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement image = driver.findElement(By.xpath("(//img)[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(image).perform();

        System.out.println("Mouse Hover Performed");

        driver.quit();
    }
}


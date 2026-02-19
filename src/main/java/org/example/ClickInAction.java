package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickInAction {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        try { Thread.sleep(2000); }
        catch (Exception e) {}
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
        Alert alert=driver.switchTo().alert();

        //print
        System.out.println("alert mag:"+alert.getText());
       //clik ok
        alert.accept();
        driver.quit();


    }
}

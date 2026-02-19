package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentwindow=driver.getWindowHandle();
        System.out.println("parent_window:"+parentwindow);
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allwindows=driver.getWindowHandles();

        for (String windo:allwindows){

            if (!windo.equals(parentwindow)){
                driver.switchTo().window(windo);
                break;
            }
        }

        String text=driver.findElement(By.tagName("h3")).getText();
        System.out.println("new window text:"+text);


        driver.close();
     driver.switchTo().window(parentwindow);
        System.out.println("back to parent window:"+driver.getTitle());
        driver.quit();

    }
}

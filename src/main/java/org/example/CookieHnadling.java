package org.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookieHnadling {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
      /*  Set<Cookie> cookies=driver.manage().getCookies();
        int count=cookies.size();
        System.out.println("all cookies count..="+count);

        //for (Cookie cookie:cookies){
       //     System.out.println("name....."+cookie.getName());
       //     System.out.println("value...."+cookie.getValue());
      //  }



       */

        Cookie sessioncookies=new Cookie("bharthesh","28372837899");
        driver.manage().addCookie(sessioncookies);


        driver.navigate().refresh();

          driver.quit();

    }
}

package ForGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Pinterest {

    public static void main(String[] args) {
        /////////////////////////////// CHROME PINTEREST //////////////////////////////////////

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pinterest.ru/");


        String s = driver.findElement(By.cssSelector("body > div:nth-child(1) > div > div > div > div > div > div:nth-child(4) > div > div:nth-child(1) > div._0._54._2u._2l._2o._8o._az > button > div"))
                .getText();
        System.out.println(s);

        driver.findElement(By.cssSelector("body > div:nth-child(1) > div > div > div > div > div > div:nth-child(4) > div > div:nth-child(1) > div._0._54._2u._2l._2o._8o._az > button > div")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("bestnastos@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("pp1234PP");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex){
            System.out.println("InterruptedException");
        }
        driver.quit();
    }
}

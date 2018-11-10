package ForGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_VK {

    public static void main(String[] args) {
        /////////////////////////////// FIREFOX VK //////////////////////////////////////


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\HOME\\Documents\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        WebDriver d = new FirefoxDriver();
        d.get("https://vk.com/");

        d.findElement(By.xpath("//*[@id=\"index_email\"]")).sendKeys("anastasia.m2010@gmail.com");
        d.findElement(By.xpath("//*[@id=\"index_pass\"]")).sendKeys("vv1234VV");

        d.findElement(By.xpath("//*[@id=\"index_login_button\"]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex){
            System.out.println("InterruptedException");
        }
        d.quit();

    }
}

package ForGit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToFrame {
    public static void main(String[] args) {

        //Открываем браузер
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\HOME\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //открываем сайт
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        WebDriverWait waiting = new WebDriverWait(driver, 15);
        WebElement frame = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("singleframe")));

        //переключаемся на фрейм так: driver.switchTo().frame(frame); или так:
        WebDriver.TargetLocator remoteTargetLocator = driver.switchTo();
        remoteTargetLocator.frame(frame);

        //заполняем поле
        WebDriverWait waiting1 = new WebDriverWait(driver, 15);
        WebElement field = waiting1.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("body > section > div > div > div > input[type=\"text\"]")));
        field.sendKeys("hi");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();

    }
}

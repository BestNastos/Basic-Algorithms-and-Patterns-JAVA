package ForGit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Amazon_BookShopping {

    public static void main(String[] args) {

        //открываем браузер
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\HOME\\Documents\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        WebDriver dr = new FirefoxDriver();
        dr.manage().window().maximize();

        //открываем сайт
        dr.get("https://www.amazon.in");

        //находим раздел Категория
        WebElement ElemCategory = dr.findElement(By.cssSelector("#nav-link-shopall > span:nth-child(2)"));
        Actions action = new Actions(dr);
        action.moveToElement(ElemCategory).perform();
        WebDriverWait wait = new WebDriverWait(dr, 15);

        //открываем раздел Книги
        WebElement ElemBooks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.nav-hasPanel:nth-child(16) > span:nth-child(1)")));
        action.moveToElement(ElemBooks);
        action.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //находим раздел Художественной литературы
        WebElement ElemFiction = dr.findElement(By.linkText("Fiction Books"));
        ElemFiction.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //Печатаем в поиске John Grisham и кликаем
        WebElement ElemSearchField = dr.findElement(By.id("twotabsearchtextbox"));
        ElemSearchField.sendKeys("John Grisham");
        WebElement ElemSearchButton = dr.findElement(By.className("nav-input"));
        ElemSearchButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //выбираем книгу The Firm
        WebElement ElemBookName = dr.findElement(By.partialLinkText("The Firm"));
        ElemBookName.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //перемещаемся между вкладками
        Set<String> tabs = dr.getWindowHandles();
        String tab1 = dr.getWindowHandle();
        tabs.remove(tab1);
        String nextTab = tabs.iterator().next();
        if (nextTab != tab1) dr.switchTo().window(tabs.iterator().next());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //добавляем товар в корзину и переходим в нее

        WebElement ElemAddToCart = dr.findElement(By.cssSelector("#add-to-cart-button"));
        ElemAddToCart.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        WebElement ElemCart = dr.findElement(By.xpath("//*[@id=\"hlb-view-cart-announce\"]"));
        ElemCart.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        // удаляем товар из корзины

        WebElement ElemDelete = dr.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[4]/div/div[2]/div[3]/form/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input"));
        ElemDelete.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //прокрутить вниз до конца
        JavascriptExecutor scroll = (JavascriptExecutor) dr;
        scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        //вернуться на главную
        WebElement ElemMainPage = dr.findElement(By.xpath("/html/body/div[1]/div[5]/div[5]/div[3]/a/div"));
        ElemMainPage.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }

        dr.close();
        dr.quit();
    }
}

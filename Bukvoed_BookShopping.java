package ForGit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Bukvoed_BookShopping {


    public static void main(String[] args) {
//                  POSITIVE TESTING
//        Тест-кейс
//        Номер: №1
//        Название: Удаление товара из корзины.
//        Шаги:
//        1. Открыть браузер Google Chrome;
//        2. Зайти на вебсайт bukvoed.ru;
//        3. Ввести в строку поиска имя любого автора;
//        4. Нажать кнопку поиска;
//        5. Выбрать из результатов поиска любую книгу и кликнуть на нее;
//        6. На странице книги в открывшейся вкладке нашать "Купить";
//        7. Перейти в корзину;
//        8. Удалить книгу из корзины.
//        Ожидаемый результат: вывод на экран сообщения "Ваша корзина пуста.".

        //opening browser
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\HOME\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //opening website
        driver.navigate().to("https://www.bookvoed.ru/");
        WebDriverWait waitPageOpen = new WebDriverWait(driver, 10);

        //searching book by the name of an author
        WebElement searchField = waitPageOpen.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id=\"gtm_search_input\"]")));
        searchField.sendKeys("Александр Дюма");
        WebElement searchButton = driver
                .findElement(By.xpath("/html/body/div[2]/div[1]/div[5]/div/div/div/div[2]/form/div/div/div[1]/input"));
        searchButton.click();
        WebDriverWait waitSearchPerform = new WebDriverWait(driver, 10);

        //clicking on the book
        WebElement bookName = waitSearchPerform.until(ExpectedConditions
                .visibilityOfElementLocated(By.partialLinkText("Граф Монте-Кристо")));
        bookName.click();

        //switching tabs
        Set<String> tabs = driver.getWindowHandles();
        String oldTab = driver.getWindowHandle();
        tabs.remove(oldTab);
        String newTab = tabs.iterator().next();
        if (newTab != oldTab) driver.switchTo().window(newTab);

        //cliking Buy

        WebDriverWait waitBookLoad = new WebDriverWait(driver, 10);
        WebElement buyButton = waitBookLoad.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".P2")));
        buyButton.click();

        //going to Cart
        WebDriverWait waitBuyButton = new WebDriverWait(driver, 20);


        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement cart = waitBuyButton.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("topcartpopup")));
                cart.click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }

        //clicking Complete Purchase
        WebDriverWait waitCartLoad = new WebDriverWait(driver, 20);
        WebElement completePurchase = waitCartLoad.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#gtm_button_top_cart_popup_check_order > span.jp")));
        completePurchase.click();

        //Deleting book from the cart
        WebDriverWait waitPurchase = new WebDriverWait(driver, 10);
        WebElement deleteBookFromCart = waitPurchase.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("kdb")));
        deleteBookFromCart.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();

    }
}

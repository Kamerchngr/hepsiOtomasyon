import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;



public class BaseTest {

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAMER\\Selenium\\ChromeDriver\\chromedriver.exe");

    }
    public Logger log= LogManager.getLogger(getClass().getName());


    @Test
    public void ilk_form() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement tık=driver.findElement(By.xpath("//span[@title='Giriş Yap']"));
        tık.click();
        log.info("Giriş yap ekranı açıldı");
        Thread.sleep(5000);

        WebElement login= driver.findElement(By.cssSelector(".sf-OldMyAccount-32BWo>ul>:first-of-type>:first-of-type"));
        login.click();

        Thread.sleep(5000);

        WebElement email = driver.findElement(By.xpath("//input[@id='txtUserName']"));
        email.sendKeys("kamerchngr@gmail.com");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("K12345678");

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[@id='btnLogin']"));
        button.click();
        log.info("Giriş Başarılı");
    Thread.sleep(3000);

        WebElement search_box = driver.findElement(By.cssSelector("input[class=desktopOldAutosuggestTheme-input]"));
        search_box.sendKeys("samsung");
        Thread.sleep(2000);
        search_box.sendKeys(Keys.ENTER);

        Thread.sleep(2000);


        WebElement alert = driver.findElement(By.cssSelector("div[class=category-suggestion-title]"));
        System.out.println(alert.getText());

        String myAlert = "samsung ile ilgili +10.000 ürün bulduk.";


        Assert.assertTrue(alert.getText().contains("samsung"));
        System.out.println("Samsung için sonuç bulundu!");
        log.info("Samsung ile ilgili sonuç bulundu");

        Thread.sleep(2000);

        WebElement ftr = driver.findElement(By.xpath("//label[@for='category-2147483642']"));
        ftr.click();
        Thread.sleep(2000);


        WebElement ftr2 = driver.findElement(By.xpath("//label[@for='category-2147483642_371965']"));
        ftr2.click();
        Thread.sleep(2000);


        try {
            Thread.sleep(3000);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,6000)");
        } catch (Exception e) {
            e.printStackTrace();

        }

        Thread.sleep(2000);
        WebElement syf2 = driver.findElement(By.xpath("//a[@href='//www.hepsiburada.com/ara?kategori=2147483642_371965&q=samsung&sayfa=2']"));
        ;
        syf2.click();
        Thread.sleep(2000);


        WebElement alert2 = driver.findElement(By.xpath("//header[@class='container title-wrapper for-suggestion']"));
        System.out.println(alert2.getText());


        String myAlert2 = "samsung ile ilgili 230 ürün bulduk.";


        Assert.assertTrue(alert2.getText().contains("samsung"));
        System.out.println("Samsung ile ilgili 2.sayfa açıldı!");

        Thread.sleep(2000);


        WebElement rndm = driver.findElement(By.xpath("//ul[@class='product-list results-container do-flex list']"));
        int num = rndm.findElements(By.tagName("li")).size();

        Random r = new Random();
        List<WebElement> list = rndm.findElements(By.tagName("li"));
        list.get(r.nextInt(num)).click();

        Thread.sleep(3000);

        WebElement like = driver.findElement(By.xpath("//div[@class='customerAccount-Like-2wPzH']"));
        like.click();

        Thread.sleep(3000);


        WebElement alert3= driver.findElement(By.xpath("//div[@class='hb-toast-content-holder']"));
        System.out.println(alert3.getText());
        Thread.sleep(2000);

        WebElement tık2=driver.findElement(By.xpath("//a[@title='Hesabım'][1]"));
        tık2.click();

        Thread.sleep(3000);
        WebElement bgn=driver.findElement(By.cssSelector(".sf-OldMyAccount-32BWo>ul>li>a[title=Beğendiklerim]"));
        bgn.click();

   Thread.sleep(5000);



        WebElement alert4 = driver.findElement(By.cssSelector("div[class=my-list-summary-info]"));
       System.out.println(alert4.getText());


        Thread.sleep(3000);

        WebElement spt=driver.findElement(By.cssSelector(".product-list>div>ul>div:first-of-type>div:first-of-type"));
        spt.click();
        Thread.sleep(5000);

        WebElement btn=driver.findElement(By.cssSelector("button[id=addToCart]"));
        btn.click();

   Thread.sleep(3000);


        WebElement alert5= driver.findElement(By.xpath("//span[@class='checkoutui-SalesFrontCash-XeG2a']"));
        System.out.println(alert5.getText());


        Thread.sleep(3000);


        WebElement spt_git=driver.findElement(By.xpath("//button[text()='Sepete git']"));
        spt_git.click();

        Thread.sleep(3000);

        WebElement kaldır=driver.findElement(By.xpath("//a[@aria-label='Ürünü Kaldır']"));
        kaldır.click();

        Thread.sleep(3000);


        WebElement alert6= driver.findElement(By.xpath("//span[text()='Ürün sepetinizden silinmiştir']"));
        System.out.println(alert6.getText());
        log.info("Sepete eklenen ürün silindi");

        Thread.sleep(3000);

       // WebElement sile_tıkla= driver.findElement(By.xpath("//button[@class='sc-AxjAm iDSyON sflButton_2fKbY']"));
        //sile_tıkla.click();



    }
}
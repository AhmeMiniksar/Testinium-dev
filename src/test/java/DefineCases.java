import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class DefineCases extends RW_File implements Case1,Case2,Case3,Case4,Case5,Case6,Case7 {

    WebDriver driver = new ChromeDriver();
    RW_File dosyaClass = new RW_File();
    WebDriverWait wait = new WebDriverWait(driver,30);

    public void case1Method() {

        //Case1
        //www.trendyol.com sitesi açılır.
        driver.get("https://www.trendyol.com/");
    }

    public void case2Method() {

        //Case2
        //Ana sayfanın açıldığı kontrol edilir.
        //driver.get("https://www.trendyol.com/");
        String expectedMainPageTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        String mainPageTitle = driver.getTitle();
        System.out.println("--------------------------------------------------------");
        System.out.println("Anasayfa baslik : ");
        System.out.println(mainPageTitle);
        Assert.assertEquals(mainPageTitle,expectedMainPageTitle);
        //Siteye login olunur.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/a")));
        driver.findElement(By.xpath("/html/body/div[8]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"accountBtn\"]/div[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        // ! Login olurken kullanıcı adı ve şifre bilgisini csv veya benzeri bir dosyadan okumalıdır. 
        //mail : adfagfgafsgasgasf@gmail.com
        //pasw : test123test
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("adfagfgafsgasgasf@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test123test");
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-root\"]/div/div/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div[1]")).click();
    }

    public void case3Method() {

        //Case3
        //Login işlemi kontrol edilir.
        String value = driver.getTitle();
        System.out.println("--------------------------------------------------------");
        System.out.println("Login olduktan sonra baslik : ");
        System.out.println(value);
        System.out.println("--------------------------------------------------------");
        String Expected = "Erkek Giyim, Erkek Kıyafetleri, Erkek Modası | Trendyol";
        Assert.assertEquals(value,Expected);
        System.out.println("Amasayfa login basarili.");
    }

    public void case4Method() {

        //Case4
        //Arama kutucuğuna bilgisayar kelimesi girilir.  
        driver.findElement(By.xpath("//*[@id=\"auto-complete-app\"]/div/div/input")).sendKeys("bilgisayar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"auto-complete-app\"]/div/div[2]/div/a[1]")));
        driver.findElement(By.xpath("//*[@id=\"auto-complete-app\"]/div/div[2]/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/a/div[3]/div[1]")).click();
    }

    public void case5Method() {

        //Case5
        //Seçilen ürünün ürün bilgisi(ürün adı) ve tutar bilgisi text dosyasına
        //yazdırılır. 
        String productText = driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/h1/div")).getText();
        System.out.println("--------------------------------------------------------");
        System.out.println("Urun detay : ");
        System.out.println(productText);
        //Ürün tutarı
        String productTax = driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/span[2]")).getText();
        System.out.println("Urun fiyat : " + productTax);
        System.out.println("--------------------------------------------------------");
        //urun bilgisi ve degeri bir stringe kaydedildi.
        loglar = productText + productTax;
    }

    public void case6Method() {

        //Case6
        //Seçilen ürün sepete eklenir.  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[2]/div[1]/button[1]/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[2]/div[1]/button[1]/div[1]")).click();
    }

    public void case7Method() {

        //Case7
        //Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu   karşılaştırılır.
        driver.findElement(By.xpath("//*[@id=\"myBasketListItem\"]/div[1]")).click();
        //Sepet tutarı
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basketAside\"]/div/div[1]/dl/dd[4]")));
        String productTax2 = driver.findElement(By.xpath("//*[@id=\"basketAside\"]/div/div[1]/dl/dd[4]")).getText();
        System.out.println("Sepetteki urun fiyat : " + productTax2);
        //Fiyat doğruluğu karşılaştırılır.
        //Sepette zaten 1 den fazla aynı üründen varsa test burada fail olur.
        String productTax = driver.findElement(By.xpath("//*[@id=\"basketAside\"]/div/div[1]/dl/dd[1]")).getText();
        Assert.assertEquals(productTax,productTax2);
        System.out.println("--------------------------------------------------------");
        System.out.println("Urun fiyati es deger.");
    }

    public void case8Method() {

        //Case8
        //Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")).click();
    }

    public void case9Method() {

        //Case9
        //Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basketNoProductPage\"]/div[2]/div/div[1]")));
        String bosSepet = driver.findElement(By.xpath("//*[@id=\"basketNoProductPage\"]/div[2]/div/div[1]")).getText();
        String beklenenBosSepetText = "Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(bosSepet,beklenenBosSepetText);
        System.out.println("--------------------------------------------------------");
        System.out.println("Sepet bos.");
    }

    public void case10Method() throws IOException {

        //log dosyası olusurmak ve basmak
        String productTax = driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/span[2]")).getText();
        String productText = driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/h1/div")).getText();
        loglar = productText + "  Fiyat : " +productTax;
        System.out.println(loglar);

        dosyaClass.fileWrite();

    }
}

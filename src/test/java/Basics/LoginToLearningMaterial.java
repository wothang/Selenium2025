package Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginToLearningMaterial  {

   WebDriver driver;
   @BeforeTest
    public void launchBrowser(){
        driver= new ChromeDriver();
    }

    @Test
   public void startBrowser() throws InterruptedException {

       driver.get("https://gray-island-0bd788c1e.2.azurestaticapps.net/#overview");
       driver.manage().window().maximize();
       Thread.sleep(2000);
   }
   @Test (dependsOnMethods = "startBrowser")
   public void verifyHomePageISDisplayed() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"overview-hero\"]/h2")).isDisplayed();
       Thread.sleep(2000);

   }

    @Test (dependsOnMethods = "verifyHomePageISDisplayed")
    public void clickLearningMaterial() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-btn-practice\"]")).click();
        Thread.sleep(2000);

    }

    @Test (dependsOnMethods = "clickLearningMaterial")
    public void VerifyLoginScreenDispalyed() throws InterruptedException {
        String Login = driver.findElement(By.xpath("//*[@id=\"login-heading\"]/span")).getText();
        Assert.assertEquals(Login,"Access Learning Materials");
        System.out.println("The printed text is : " +Login);
        Thread.sleep(2000);

    }

    @Test (dependsOnMethods = "VerifyLoginScreenDispalyed")
    public void EnterUsername() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("zungu739@gmail.com");
        Thread.sleep(2000);

    }


    @Test (dependsOnMethods = "EnterUsername")
    public void EnterPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("Shaun@123");
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "EnterPassword")
    public void clickLoginButton() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
       Thread.sleep(8000);
    }

    @Test(dependsOnMethods = "clickLoginButton")
    public void VerifyPracticeTabDisplayed() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"practice-heading\"]")).isDisplayed();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "VerifyPracticeTabDisplayed")
    public void VerifyLogoutButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"logout-button\"]")).isDisplayed();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "VerifyLogoutButton")
    public void ClickWebAutomationTab() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"tab-btn-web\"]/span[2]")).click();
       Thread.sleep(2000);
    }


    @Test(dependsOnMethods = "ClickWebAutomationTab")
    public void SelectDevice() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"deviceType\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"deviceType\"]/option[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"brand\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"brand\"]/option[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"inventory-form-grid\"]/div[4]/div/label[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"color\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"color\"]/option[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys("2");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("45 Ndosi Avenue");
        Thread.sleep(2000);

    }


    @Test(dependsOnMethods = "SelectDevice")
    public void ClickPurschaseDevice() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"purchase-device-btn\"]")).click();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "ClickPurschaseDevice")
    public void VerifyFormReset() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"inventory-form-grid\"]")).isDisplayed();
       Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "VerifyFormReset")
    public void ClickLogoutButton() throws InterruptedException {
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.HOME);
        Thread.sleep(1000);

        WebElement logoutBtn = driver.findElement(By.id("logout-button"));
        logoutBtn.click();
        Thread.sleep(3000);
    }
    @Test(dependsOnMethods = "ClickLogoutButton")
    public void VerifyLogout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-heading\"]/span")).isDisplayed();
        Thread.sleep(2000);
    }



    @AfterTest
     public void closeBrowser(){
       driver.quit();
     }


}

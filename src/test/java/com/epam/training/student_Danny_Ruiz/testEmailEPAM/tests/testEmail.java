package com.epam.training.student_Danny_Ruiz.testEmailEPAM.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;


public class testEmail {

    private WebDriver driver;

    By buttonSingIn = By.xpath("//nav[@class='auxiliary-actions']//a[contains(text(),'Sign in')]");
    By user = By.id("i0116");
    By password = By.name("passwd");
    By nextButton = By.id("idSIButton9");
    By singInButtom = By.xpath("//input[@value='Sign in']");
    By noButton = By.id("idBtn_Back");

    By newEmailButton = By.xpath("//button[@aria-label='New mail']");
    By toRecipient = By.xpath("//div[@aria-label='To']");
    By subject = By.xpath("//input[@aria-label='Add a subject']");
    By message = By.xpath("//div[@aria-label='Message body, press Alt+F10 to exit']");
    By send = By.xpath("//button[@aria-label='Send']");

    By userButton = By.xpath("//button[@aria-label='Account manager for Test1 Email1']");
    By singOut = By.xpath("//a[@aria-label='Sign out of this account']");

    By sender = By.xpath("//span[contains(text(),'Test1 Email1')]");
    By mailBody = By.xpath("//div[@class='x_elementToProof']");


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromeDriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://outlook.live.com/");

        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        caps.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @Test
    public void validUserTest() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(buttonSingIn).click();
        driver.findElement(user).sendKeys("test_161@hotmail.com");
        driver.findElement(nextButton).isEnabled();
        driver.findElement(nextButton).click();
        driver.findElement(password).sendKeys("ThisIsATest");
        driver.findElement(singInButtom).click();
        driver.findElement(noButton).click();
    }


    @Test
    public void wrongPassword() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(buttonSingIn).click();
        driver.findElement(user).sendKeys("test_161@hotmail.com");
        driver.findElement(nextButton).isEnabled();
        driver.findElement(nextButton).click();
        driver.findElement(password).sendKeys("Hello");
        driver.findElement(singInButtom).click();
        driver.findElement(noButton).click();

    }

    @Test
    public void emptyData() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(buttonSingIn).click();
        driver.findElement(user).sendKeys("");
        driver.findElement(nextButton).isEnabled();
    }

    @Test
    public void sendEmail() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(buttonSingIn).click();
        driver.findElement(user).sendKeys("test_161@hotmail.com");
        driver.findElement(nextButton).isEnabled();
        driver.findElement(nextButton).click();
        driver.findElement(password).sendKeys("ThisIsATest");
        driver.findElement(singInButtom).click();
        driver.findElement(noButton).click();

        Thread.sleep(3000);
        driver.findElement(newEmailButton).click();
        driver.findElement(toRecipient).sendKeys("test_163@hotmail.com");
        driver.findElement(subject).sendKeys("Test");
        driver.findElement(message).sendKeys("Esto es un test para el curso de Automatizacion con Selenium Web Driver de EPAM");
        driver.findElement(send).click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(userButton).click();
        driver.findElement(singOut).click();

    }

    @Test
    public void checkEmail() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(buttonSingIn).click();
        driver.findElement(user).sendKeys("test_163@hotmail.com");
        driver.findElement(nextButton).click();
        driver.findElement(password).sendKeys("ThisIsATest");
        Thread.sleep(1000);
        driver.findElement(singInButtom).click();
        driver.findElement(noButton).click();

        Thread.sleep(1000);
        assertEquals("Test1 Email1", driver.findElement(sender).getText());
        driver.findElement(sender).click();
        Thread.sleep(1000);
        assertEquals("Esto es un test para el curso de Automatizacion con Selenium Web Driver de EPAM", driver.findElement(mailBody).getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


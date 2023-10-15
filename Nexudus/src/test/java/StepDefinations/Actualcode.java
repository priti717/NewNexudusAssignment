package StepDefinations;


import Utility.Utilityclass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import io.cucumber.java.Before;
//import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Actualcode extends Utilityclass {

    public static WebDriver driver;

    @Before
    public void setup() {

        //Setup Chromedriver
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        //Chromedriver path where you save the driver
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver\\V118\\chromedriver-win64\\chromedriver.exe");
        System.out.println("Print the login page ------");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);

    }

    @Given("Login page is visible URL {string}")
    public void Loginpage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Successfully login");
    }

    @When("Enter valid Email address {string}")
    public void EnterEmail(String email) throws IOException {
        driver.findElement(By.xpath(ReadFiledata().getProperty("Email"))).sendKeys(email);
    }

    @When("Enter valid password {string}")
    public void EnterPassword(String password) throws IOException {
        // driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(password);
        driver.findElement(By.xpath(ReadFiledata().getProperty("Password"))).sendKeys(password);
        System.out.println("entered password address");
    }

    @When("Click on Sign in")
    public void ErrorSignIn() throws IOException {
        driver.findElement(By.xpath(ReadFiledata().getProperty("SignIn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Enter sign In");
        String text = driver.findElement(By.xpath(ReadFiledata().getProperty("ErrorText"))).getText();
        Assert.assertEquals("The email or password is incorrect.", text);
    }

    @When("Successful sign in")
    public void SignIn() throws IOException {
        driver.findElement(By.xpath(ReadFiledata().getProperty("SignIn"))).click();
        ;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Enter sign In");

    }

    @Then("close the driver")
    public void DriverClose() {
        driver.quit();
    }


    @When("navigate to {string}")
    public void navigate_to(String url) {

        driver.get(url);
    }

        @After
    public void tear(){
        //Closing the browser
        driver.quit();
    }
    @When("Add the Product and fill the details name {string},{string} and {string} fields")
    public void AddProduct(String Name, String Description, String Price) throws InterruptedException, IOException {
        driver.findElement(By.xpath(ReadFiledata().getProperty("AddProduct"))).click();
        System.out.println("Product added page");
        driver.findElement(By.xpath(ReadFiledata().getProperty("ClickOnManual"))).click();
        driver.findElement(By.xpath(ReadFiledata().getProperty("ProductName"))).sendKeys(Name);
        driver.findElement(By.xpath(ReadFiledata().getProperty("ProductDescription"))).sendKeys(Description);
        driver.findElement(By.xpath(ReadFiledata().getProperty("ProductPrice"))).clear();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(ReadFiledata().getProperty("ProductPrice"))).sendKeys(Price);
        // driver.findElement(By.xpath(ReadFiledata().getProperty("ProductListId"))).sendKeys("1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(ReadFiledata().getProperty("SaveProduct"))).click();
        try {
            driver.findElement(By.cssSelector(ReadFiledata().getProperty("CloseDialogBox"))).click();
            System.out.println("successfully Product added");
        } catch (Exception e) {
            System.out.println("Exception while closing product page");
        }
        try {
            driver.findElement(By.cssSelector(ReadFiledata().getProperty("SearchTextBox"))).click();
            System.out.println("search click worked");
            driver.findElement(By.cssSelector(ReadFiledata().getProperty("SearchText"))).sendKeys(Name);
             driver.findElement(By.cssSelector(ReadFiledata().getProperty("SearchText"))).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Exception appeared");
        }
    }




    @When("Delete added product")
    public void DeleteProduct() throws IOException {
        try{
            driver.findElement(By.xpath(ReadFiledata().getProperty("SelectSearchedProduct"))).click();
        }
        catch(Exception e){System.out.println("Exception appeared in search link");
        }
        driver.findElement(By.xpath(ReadFiledata().getProperty("DeleteProduct"))).click();
        try{
            driver.findElement(By.xpath(ReadFiledata().getProperty("YesConfirmation"))).click();
        }catch(Exception e){System.out.println("Exception appeared while deleting product");
        }
    }


}

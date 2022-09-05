import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;




public class BoundaryValuesTest {
    WebDriver driver;

    @Given("Opened and maximized browse")
    public void openedBrowse() {
        System.setProperty("webdriver.edge.driver", "src/main/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @When("first site is opened")
    public void firstSite() {
        driver.get("https://www.google.com");
        WebElement cookie = driver.findElement(By.id("W0wltc"));
        cookie.click();
    }

    @Then("user is redirected to creating account page")
    public void createAccountPage() {
        WebElement element = driver.findElement(By.xpath("//div/div/div/div[1]/a"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span"));
        JavascriptExecutor egzekucjakrwiozerczymrobotem = (JavascriptExecutor) driver;
        egzekucjakrwiozerczymrobotem.executeScript("arguments[0].click();", element1);
        System.out.print("meow");
        WebElement element2 = driver.findElement(By.xpath("//div/div[2]/div/ul/li[3]"));
        element2.click();
    }

    @And("^potentially unaccepted data is introduced (.*) (.*) (.*) (.*) (.*)")
    public void registration(String firstName, String lastName, String email, String password, String repeatPassword) {
        List<WebElement> list = driver.findElements(By.cssSelector("@input[class=\"whsOnd zHQkBf\"]"));
        WebElement firstNameBar = list.get(1);
        WebElement lastNameBar = list.get(2);
        WebElement emailBar = list.get(3);
        WebElement passwordBar = list.get(4);
        WebElement repeatPasswordBar = list.get(5);
        WebElement checkbox = driver.findElement(By.id("selectioni1"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        firstNameBar.sendKeys(firstName);
        lastNameBar.sendKeys(lastName);
        emailBar.sendKeys(email);
        passwordBar.sendKeys(password);
        repeatPasswordBar.sendKeys(repeatPassword);
        WebElement wio = driver.findElement(By.xpath("//div[1]/div/div/button/div[3]"));
        wio.click();
    }
    @And("browser is  closed")
    public void closeBrowser(){
        try {
            driver.wait(2000);
        }
        catch (Exception e){
            System.out.println("no error should occur here");
        }
        driver.quit();
    }
}


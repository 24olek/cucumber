import java.lang.Thread;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.assertj.core.util.Arrays;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;


public class EdgeSteps {
    WebDriver driver;

    @Given("opened browse")
    public void openBrowse() {
        System.setProperty("webdriver.edge.driver", "src/main/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @When("opened site")
    public void openSite() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Then("^User is logged. email (.*) and password (.*) are inserted")
    public void searchPhrase(String email, String password) {
        WebElement element = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span"));
        element.click();
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement button = driver.findElement(By.id("submit-login"));
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        button.click();
    }

    @And("^new adress alias (.*)")
    public void addNewAdress(String alias) {
        WebElement element3 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]/span"));
        element3.click();
        WebElement element = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/a/span"));
        element.click();

        WebElement insertAlias = driver.findElement(By.name("alias"));
        insertAlias.clear();
        insertAlias.sendKeys(alias);


    }

    @And("^adding data firstname (.*), lastname (.*), company (.*)")
    public void newClass(String firstname, String lastname, String company) {
        WebElement insertFirstname = driver.findElement(By.name("firstname"));
        insertFirstname.clear();
        insertFirstname.sendKeys(firstname);
        WebElement insertLastname = driver.findElement(By.name("lastname"));
        insertLastname.clear();
        insertLastname.sendKeys(lastname);
        WebElement insertCompany = driver.findElement(By.name("company"));
        insertCompany.clear();
        insertCompany.sendKeys(company);

    }

    @And("^adding more data , vat number (.*), adress (.*), adress complemention (.*)")
    public void lol(String vatNumber, String adress, String adressComplement) {
        WebElement insertVatnumber = driver.findElement(By.name("vat_number"));
        insertVatnumber.clear();
        insertVatnumber.sendKeys(vatNumber);
        WebElement insertAdress = driver.findElement(By.name("address1"));
        insertAdress.clear();
        insertAdress.sendKeys(adress);
        WebElement insertAdress2 = driver.findElement(By.name("address2"));
        insertAdress2.clear();
        insertAdress2.sendKeys(adressComplement);
    }

    @And("^adding more data (.*), zip code (.*), country (.*), phone (.*) is added")
    public void newNew(String city, String zipCode, String country, String phone) {
        WebElement insertPostcode = driver.findElement(By.name("postcode"));
        insertPostcode.clear();
        insertPostcode.sendKeys(zipCode);
        WebElement insertCity = driver.findElement(By.name("city"));
        insertCity.clear();
        insertCity.sendKeys(city);
        WebElement insertPhone = driver.findElement(By.name("phone"));
        insertPhone.clear();
        insertPhone.sendKeys(phone);
        WebElement insertCountry = driver.findElement(By.name("id_country"));
        Select select = new Select(insertCountry);
        select.selectByVisibleText(country);
        WebElement saveButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        saveButton.click();
    }
    @And("^address is checked (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)")
    public void checkAddress(String alias, String firstname, String lastname, String company, String vatNumber,
                             String address, String addressComplemention, String city, String zipCode,
                             String country, String phone){
        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.className("address-body")));
        String addressInfo = list.get(1).getText();
        System.out.println(addressInfo);
        if (addressInfo.contains(alias) && addressInfo.contains(firstname) && addressInfo.contains(lastname) && addressInfo.contains(company) && addressInfo.contains(vatNumber)
                && addressInfo.contains(address) && addressInfo.contains(addressComplemention) && addressInfo.contains(city) && addressInfo.contains(zipCode)
                && addressInfo.contains(country) && addressInfo.contains(phone)){
            System.out.println("Address is correct");
        }

    }
    @And("address is deleted")
    public void deleteAdress(){
        WebElement delAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span"));
        delAddress.click();
    }
    @And("address deletion is checked")
    public void checkDeletion(){
        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.className("address-body")));
        if (list.size() == 1){
            System.out.println("Addres is deleted");
        }

    }

    @And("browser is closed")
    public void closeBrowser() {
        driver.quit();
    }
}

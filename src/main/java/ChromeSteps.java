import java.time.Duration;
import java.io.File;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;


public class ChromeSteps {
    WebDriver driver;
    String price;
    @When("Opened browse")
    public void openBrowse() {
        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Then("Opened site")
    public void openSite() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
    @And("^User is logged. Email (.*) password (.*)")
    public void login(String email, String password) {
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
    @And("^Item is added. Size (.*) quantity(.*)")
    public void addItem(String size, String quantity) {
        //This step additionally checks discount
        WebElement element = driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a"));
        element.click();
        WebElement discount = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/div/span[3]"));
        String discountValue = discount.getText();
        if (discountValue.contains("-20%")) {
            System.out.println("Discount -20% is appended");
        } else {
            System.out.println("Discount -20% is not appended");
        }
        WebElement element1 = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/a/img"));
        element1.click();
        WebElement chooseSize = driver.findElement(By.id("group_1"));
        Select select = new Select(chooseSize);
        select.selectByVisibleText(size);
        WebElement chooseQuantity = driver.findElement(By.id("quantity_wanted"));
        chooseQuantity.clear();
        chooseQuantity.sendKeys(quantity);
        WebElement order = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"));
        order.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement checkout = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
        checkout.click();
    }
    @And("^Order is finished")
    public void finishOrder() {
        WebElement checkout2 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a"));
        checkout2.click();
        WebElement addressCheckout = driver.findElement(By.name("id_address_delivery"));
        if (!addressCheckout.isSelected()) {
            addressCheckout.click();
        }
        WebElement confirmAddress = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[2]/button"));
        confirmAddress.click();
        WebElement deliveryMethod = driver.findElement(By.id("delivery_option_1"));
        if (!deliveryMethod.isSelected()) {
            deliveryMethod.click();
        }
        WebElement comment = driver.findElement(By.id("delivery_message"));
        comment.sendKeys("Chomik dżungarski jako drapieżnik syberyjski jest niezłym skrupulatnym łowcą");
        WebElement confirm = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button"));
        confirm.click();
        WebElement paymentMethod = driver.findElement(By.id("payment-option-1"));
        if (!paymentMethod.isSelected()) {
            paymentMethod.click();
        }
        WebElement agreeButton = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input"));
        if (!agreeButton.isSelected()) {
            agreeButton.click();
        }
        WebElement obligation = driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button"));
        obligation.click();
        price = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section[2]/div/div/div[1]/div/table/tbody/tr[3]/td[2]")).getText();
        System.out.println("Total price is " + price);
    }
    @And("^Screenshot is taken number (.*)")
    public void takeScreenshot(String number) throws Exception {
        WebElement screenshoot = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section[3]/div/div/div/p"));

        File screenshot = screenshoot.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\aleks\\source\\repos\\Testy automatyczne\\screenshot" + number + ".jpg");
        FileHandler.copy(screenshot, destination);
    }
    @And("^Price and status of order is checked order status (.*)")
    public void statusAndPriceCheck(String orderStatus) {
        WebElement goToAccountPage = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[2]/span"));
        goToAccountPage.click();
        WebElement goToOrdersList = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[3]/span/i"));
        goToOrdersList.click();
        WebElement goToLastOrder = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[6]/a[1]"));
        goToLastOrder.click();
        String orderStatusText = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section[1]/table/tbody/tr/td[2]/span")).getText();
       // String orderStatusText = orderStatusElement.getText();
        if (orderStatusText.contains(orderStatus)) {
            System.out.println("Order status is " + orderStatus);
        } else {
            System.out.println("Order status is not " + orderStatus);
        }
        String totalPrice = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/table/tfoot/tr[3]/td[2]")).getText();
        if (totalPrice.contains(price)) {
            System.out.println("Final price is equal to price provided while ordering");
        } else {
            System.out.println("Final price is not equal to price provided while ordering");
        }

    }
    @And("Browser is closed")
    public void closeBrowser(){
        driver.quit();
    }
}

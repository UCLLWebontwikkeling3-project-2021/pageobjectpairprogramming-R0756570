import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=Home");
    }

    @FindBy(id = "userid")
    private WebElement useridField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "logout")
    private WebElement logoutButton;

    public void setUserid(String userid) {
        useridField.clear();
        useridField.sendKeys(userid);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        loginButton.click();
    }

    public HomePage submitLogout() {
        logoutButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public boolean hasErrorMessage(String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("p.alert-danger"));
        System.out.println(errorMsg.getText());
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasWelcomeMessage(String message) {
        WebElement welcomeMsg = driver.findElement(By.cssSelector("div#container main p"));
        return (message.equals(welcomeMsg.getText()));
    }

}

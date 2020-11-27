import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/DeelOpdracht4B_war_exploded/Controller";


    @Before
    public void setUp() throws Exception {
        // pas aan indien nodig
        //System.setProperty("webdriver.chrome.driver", "/Users/grjon/Desktop/web3/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 maar houd er rekening mee dat Chrome wellicht een upgrade kreeg
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pecho\\OneDrive\\Desktop\\dependencies\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path+"?command=Home");
    }


    @After
    public void clean(){
        //driver.quit();
    }

    @Test
    public void test_Login_AllFieldsFilledInCorrectly_UserIsloggedIn() {
        //create user


        submitForm("admin","admin");

        String title = driver.getTitle();
        assertEquals("Home",title);

        WebElement fieldUserid=driver.findElement(By.id("welcome"));
        System.out.println(fieldUserid.getText());
        assertEquals("Welcome Ad !",fieldUserid.getText());


    }
/*
    private void deleteuser() {

    }

    private void createuser(){
        fillOutField("userid", "nicolas");
        fillOutField("firstName", "nicolas");
        fillOutField("lastName","deleteTest");
        fillOutField("email", "nico@gmail.com");
        fillOutField("password", "n");

        WebElement button=driver.findElement(By.id("signUp"));
        button.click();
    }
*/
    private void fillOutField(String name, String value) {
        WebElement field=driver.findElement(By.id(name));
        field.clear();
        field.sendKeys(value);
    }

    private void submitForm(String userid, String password) {
        fillOutField("userid", userid);
        fillOutField("password", password);

        WebElement button=driver.findElement(By.id("login"));
        button.click();
    }

}

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class jcTest {
    private WebDriver webDriver;

    @BeforeAll
    public void setupAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guilherme\\Desktop\\testes\\selenium-pratica-main" +
                "\\src\\test\\resourcers\\chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    public void setupEach(){
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser(){
        webDriver.close();
    }

    @Test
    public void abrePaginaJc(){

        webDriver.get("https://gas.sjcc.dev/login");
        Assertions.assertEquals("https://gas.sjcc.dev/login", webDriver.getCurrentUrl());

    }

    @Test
    public void loginOnJcPage()  {
        webDriver.get("https://gas.sjcc.dev/login/");
        WebElement buscaEmail = webDriver.findElement(By.id("email"));
        buscaEmail.sendKeys("teste@gmail.com");
        WebElement botaoEntrar = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/div[3]/button"));
        botaoEntrar.click();
        Assertions.assertEquals("https://gas.sjcc.dev/login/",webDriver.getCurrentUrl());
    }


}
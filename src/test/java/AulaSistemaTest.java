import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class AulaSistemaTest {
  private WebDriver webDriver;

  @BeforeAll
  public void setupAll(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Guilherme\\Desktop\\testes\\selenium-pratica-main" +
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
  public void abrePaginaPrincipal(){
   // System.setProperty("webdriver.chrome.driver","C:\\Users\\Guilherme\\Desktop\\testes\\selenium-pratica-main" +
   //        "\\src\\test\\resourcers\\chromedriver_win32\\chromedriver.exe");
   //webDriver = new ChromeDriver();
   // webDriver.manage().window().maximize();
    webDriver.get("https://www.casasbahia.com.br/");
    Assertions.assertEquals("https://www.casasbahia.com.br/", webDriver.getCurrentUrl());
    // webDriver.close();
  }

  @Test
  public void searchOnCasasBahiaPage()  {
    webDriver.get("https://www.casasbahia.com.br/");
    WebElement buscaSection = webDriver.findElement(By.id("strBusca"));
    buscaSection.sendKeys("geladeira");
    WebElement botaoBusca = webDriver.findElement(By.id("btnOK"));
    botaoBusca.click();
    Assertions.assertEquals("https://www.casasbahia.com.br/geladeira/b",webDriver.getCurrentUrl());
  }



  @Test
  public void buscaFormularioTest(){

    Actions actions = new Actions(webDriver);
    webDriver.get("https://www.globo.com/");
    WebElement buscaSection = webDriver.findElement(By.id("header-search-section"));
    actions.moveToElement(buscaSection).click().perform();
    Assertions.assertTrue(buscaSection.isEnabled());
    WebElement busca = webDriver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
    busca.sendKeys("fantastico");
    busca.submit();
    Assertions.assertTrue(webDriver.getCurrentUrl().contains("fantastico"));

  }


  @Test
  public void tooltipTest(){
    webDriver.get("https://www.diariodepernambuco.com.br/");
    Actions actions = new Actions(webDriver);
    WebElement botaoTwitter = webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div[2]/div/span[5]/a/img"));
    actions.moveToElement(botaoTwitter).build().perform();
    Assertions.assertTrue(webDriver.getPageSource().contains(botaoTwitter.getAttribute("title")));


  }
  @Test
  public void assertFalseTest(){
    WebElement chk1, chk2;
    webDriver.get("http://only-testing-blog.blogspot.com/2014/02/attributes.html");
    chk1 = webDriver.findElement(By.xpath("//input[@name='option1']"));
    chk2 = webDriver.findElement(By.xpath("//input[@name='option2']"));
    Assertions.assertFalse(chk2.isSelected()); {
      System.out.print("\n"+chk1.isSelected());
    }

   }

  @Test
  public void moveMouseEClicaTest(){
    webDriver.get("https://www.casasbahia.com.br/");
    Actions actions = new Actions(webDriver);
    WebElement botaoEntrarCarrinho = webDriver.findElement(By.id("itensCarrinho"));
    actions.moveToElement(botaoEntrarCarrinho).build().perform();
    botaoEntrarCarrinho.click();
    Assertions.assertEquals("https://carrinho.casasbahia.com.br/", webDriver.getCurrentUrl());
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
 /* @Test
  public void abrirPagina1Test (){
    {...}
    webDriver.get("http://tede2.unicap.br:8080/browse?type=dateissued");

    Select select = new Select(selectElement);
    select.selectByIndex(2);

    {...}
  }


  @Test
  public void abrirPaginaTest (){
    {...}
    WebElement table = webDriver.findElement
            (By.xpath(“/html/body/main/div[3]/div[3]/table/tbody”));
    List<WebElement> elements =
            table.findElements(By.xpath(“./tr”));
  }

  @Test
  public void abrirPaginaTest (){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement botao = webDriver.findElement(
            By.name(“button-fb-page”));
  }
  @Test
  public void abrirPaginaTest (){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://globo.com");
    Actions actions = new Actions(webDriver);
    WebElement botao = webDriver.findElement(
            By.name(“ge”));
    actions.moveToElement(botao).perform();
  }
*/



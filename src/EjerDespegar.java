import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EjerDespegar {

@Test(description = "Validar que las busquedas en Wikipedia funcionan")
public void ValidarBusquedaWikipedia() throws Exception {
	//Se define la ubicacion del driver a utilizar
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Documents\\Documentos Vates\\Testing Automatizado\\chromedriver.exe");
	//Se crea un nuevo webDriver 
	WebDriver driver = new ChromeDriver();
	//maximiza la pantalla
	driver.manage().window().maximize();
	//Ingresa al URL seleccionado
	driver.get("https://www.despegar.com.ar");
	
	//Le quitamos zoom a la pagina
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("document.body.style.zoom = '1'");
	
	//Define un nuevo webElement llamado "DespegarAlojamiento" por css y con su respectiva validacion
	WebElement DespegarAlojamiento = driver.findElement(By.cssSelector(".header-products-container [href='//www.despegar.com.ar/hoteles/']"));
	Assert.assertTrue(DespegarAlojamiento.isDisplayed(),"Error, no accede a la pagina");
	DespegarAlojamiento.click();
	Thread.sleep(500);
	
	//Define un nuevo webElement llamado "Origen" por xpath y con su respectiva validacion
	WebElement origen = driver.findElement(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox-places-destination--1xd0k']//input[@class='input-tag']"));
	//WebElement origen = origenes.get(0);
	Assert.assertTrue(origen.isDisplayed(),"Error, no accede al apartado Origen");
	origen.click(); 
	
	//Eliminamos el anuncio de las cookies
	WebElement anuncio = driver.findElement(By.xpath("//a[@class='lgpd-banner--button eva-3-btn -white -md']//em[@class='btn-text']"));
    Assert.assertTrue(anuncio.isDisplayed(),"Error, no elimina el anuncio");
    anuncio.click();
	
	//Envia el texto "Cordoba" para ingresar
	origen.sendKeys("San Carlos de Bariloche, Argentina");
	Thread.sleep(1000);
	//Oprime el boton Control para que salgan las diversas opciones
    origen.sendKeys(Keys.CONTROL);
    Thread.sleep(1000);
    //Oprime el boton Enter para ingresar solo a la primera opcion 
    origen.sendKeys(Keys.ENTER);
    //Define el elemento "entrada" y luego ingresa en el mismo
    WebElement entrada = driver.findElement(By.xpath("//input[@placeholder='Entrada']"));
    Assert.assertTrue(entrada.isDisplayed(),"Error, no accede a la fecha de entrada");
    entrada.click();
    Thread.sleep(2000);
    
    //Definimos la fecha de hoy
    WebElement hoy = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber -today']"));
    Assert.assertTrue(hoy.isDisplayed(),"Error, no selecciona la fecha de hoy");
    hoy.click();
    Thread.sleep(1000);
    
    //Definimos la fecha de Salida
    WebElement fechasalida = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber sbox5-monthgrid-datenumber-31']"));
    Assert.assertTrue(fechasalida.isDisplayed(),"Error, no accede a la fecha de salida");
    fechasalida.click();
    Thread.sleep(1000);

    //Definimos el boton aplicar y lo oprimimos
    WebElement botonAplicar = driver.findElement(By.xpath("//button[@class='sbox5-3-btn -primary -md']"));
    Assert.assertTrue(botonAplicar.isDisplayed(),"Error, no accede a la boton Aplicar");
    botonAplicar.click();
    Thread.sleep(1000);
    
    //Definimos y seleccionamos el apartado habitacion
    WebElement habitaciones = driver.findElement(By.xpath("//input[@class='sbox5-3-second-input']"));
    Assert.assertTrue(habitaciones.isDisplayed(),"Error, no accede al apartado de habitaciones");
    habitaciones.click();
    Thread.sleep(1000);

    //Cantidad adultos + 1
    WebElement cantAdultos = driver.findElement(By.xpath("//div[@class='stepper__room']//button[@class='steppers-icon-right stepper__icon']"));
    Assert.assertTrue(cantAdultos.isDisplayed(),"Error, no aumenta la cantidad de adultos");
    cantAdultos.click();
    Thread.sleep(1000);
    
    //Cantidad Niños + 1 creando una lista y seleccionado la segunda opcion
    List<WebElement> cantNiños = driver.findElements(By.xpath("//div[@class='stepper__room']//button[@class='steppers-icon-right stepper__icon']"));
    WebElement niños = cantNiños.get(1);
    Assert.assertTrue(niños.isDisplayed(),"Error, no aumenta la cantidad de Niños");
    niños.click();
    Thread.sleep(1000);
    
    //Definimos la edad del niño que se va a utilizar
    WebElement edad = driver.findElement(By.xpath("//select[@class='select']"));
    Assert.assertTrue(edad.isDisplayed(),"Error, no define la edad del niño");
    edad.click();
    Thread.sleep(1000);
    WebElement edadNiño = driver.findElement(By.xpath("//select[@class='select']//option[@class='select-option'][5]"));
    Assert.assertTrue(edadNiño.isDisplayed(),"Error, no define la edad del niño");
    edadNiño.click();
    Thread.sleep(1000);
  
    //Segundo boton aplicar 
    List<WebElement> botonaplicar2 = driver.findElements(By.xpath("//a[@class='sbox5-3-btn -md -primary']"));
    WebElement aplicar2 = botonaplicar2.get(1);
    Assert.assertTrue(aplicar2.isDisplayed(),"Error, no accede al 2do boton Aplicar");
    aplicar2.click();
    Thread.sleep(1000);
    
    //Boton Buscar
    WebElement botonBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']"));
    Assert.assertTrue(botonBuscar.isDisplayed(),"Error, no accede a el boton BUSCAR");
    botonBuscar.click();
    Thread.sleep(1000);
    
    //Seleccionamos la primera opcion de alojamiento
    WebElement opcion1 = driver.findElement(By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']"));
    Assert.assertTrue(opcion1.isDisplayed(),"Error, no accede a la primera opcion de alojamiento");
    opcion1.click();
    Thread.sleep(1000);
    
    //Cierra la pagina
	driver.close();
}
}
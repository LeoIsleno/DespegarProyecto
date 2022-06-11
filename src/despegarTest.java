package com.seleniuim.test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.Drivers;

import pageObjects.despegarAlojamientosPage;
import pageObjects.despegarMainPage;
import pageObjects.despegarResoultsPage;

public class despegarTest extends Drivers {

@Test(description = "Validar que las busquedas en Despegar funcionan")
public void ValidarDespegar() throws Exception {
	String url = "https://www.despegar.com.ar";
	String Browser = "CHROME";
	
	//Inicializamos con el browser a utilizar
	WebDriver driver = despegarTest.LevantarBrowser(Browser, url);
	
	//Concatenacion de paginas
	despegarMainPage mainPage = new despegarMainPage(driver);
	despegarAlojamientosPage alojamientosPage = mainPage.goToAlojamientos();
	
	//Realizamos el test
	alojamientosPage.IngresarTexto("Bariloche");
	alojamientosPage.EliminarCookies();
	alojamientosPage.IngresarEntrada();
	alojamientosPage.IngresarSalida();
	alojamientosPage.BotonAplicar(1);
	alojamientosPage.IngresarHabitaciones();
	alojamientosPage.AumentarCantidadAdultos();
	alojamientosPage.AumentarCantidadNiños();
	alojamientosPage.EdadNiño();
	alojamientosPage.BotonAplicar(2);
	alojamientosPage.BotonAplicar(3);
	//alojamientosPage.BuscarResultados();
	
	despegarResoultsPage resoultsPage = alojamientosPage.BuscarResultados();
	
	resoultsPage.VerDetalles();
	
	Thread.sleep(5000);
	driver.quit();
	}
}
  
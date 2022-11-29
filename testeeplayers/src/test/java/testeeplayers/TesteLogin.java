package testeeplayers;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	private WebDriver driver;
	
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testeNavegador() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/login");
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement botaoLogin = driver.findElement(By.id("botao-enviar"));
		
		String[] listaSenhas = {"senha1", "senhaerrada", "teste1", "test", "senhaerradaoutravez", "senhadotadeu"};
		for(int tentativa = 0; tentativa < listaSenhas.length; tentativa++) {
			try {
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("tadeu@tadeu.com");
				inputSenha.sendKeys(listaSenhas[tentativa]);
				botaoLogin.click();
				
				Thread.sleep(3000);
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
}

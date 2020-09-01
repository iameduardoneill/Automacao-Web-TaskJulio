package br.com.inmetrics.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.edsoft.framework.base.BasePage;
import com.edsoft.framework.base.DriverContext;

import br.com.inmetrics.pages.*;

public class HomePage extends BasePage {

	public String login;
	public String senha;

	public String valorRandom = "";

	public HomePage() {
	}

	@FindBy(how = How.ID, using = "signup")
	public WebElement btnSignUp;

	@FindBy(how = How.XPATH, using = "modal-action waves-effect waves-green btn-flat")
	public WebElement btnSave;

	@FindBy(how = How.NAME, using = "name")
	public WebElement preencherName;

	@FindBy(how = How.NAME, using = "login")
	public WebElement preencherLogin;

	@FindBy(how = How.NAME, using = "password")
	public WebElement preencherPassword;

	@FindBy(how = How.LINK_TEXT, using = "Logout")
	public WebElement btnLogout;

	@FindBy(how = How.XPATH, using = "//a[@class='brand-logo']")
	public WebElement TaskHome;

	@FindBy(how = How.XPATH, using = "/html/body/nav/div/div/ul[1]/li[3]/a")
	public WebElement linkLogout;

	@FindBy(how = How.XPATH, using = "//a[@data-target='signinbox']")
	public WebElement singIn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input")
	public WebElement informaLogin;

	@FindBy(how = How.XPATH, using = "//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")
	public WebElement informaPassword;

	public HomePage validaTitle() {
		DriverContext.WaitForElementTextVisible(TaskHome, "Task it!");
		return GetInstance(HomePage.class);
	}

	public  HomePage singUp() {
		DriverContext.WaitForElementVisible(btnSignUp);
		btnSignUp.click();
		return GetInstance(HomePage.class);
	}

	public HomePage preemchoName() {
		gerarValor();
		DriverContext.WaitForElementVisible(preencherName);
		preencherName.sendKeys(valorRandom);
		return GetInstance(HomePage.class);
	}

	public void preemchoLogin() {
		gerarValor();
		login = valorRandom;
		DriverContext.WaitForElementVisible(preencherLogin);
		preencherLogin.sendKeys(login);
	}

	public HomePage preemchoPassword() {
		gerarValor();
		senha = valorRandom;
		DriverContext.WaitForElementVisible(preencherPassword);
		preencherPassword.sendKeys(valorRandom);
		return GetInstance(HomePage.class);
	}

	public HomePage btnSave() {
		DriverContext.WaitForElementVisible(btnSave);
		btnSave.click();
		return GetInstance(HomePage.class);
	}

	public HomePage linkLogout() {
		DriverContext.WaitForElementVisible(linkLogout);
		linkLogout.click();
		return GetInstance(HomePage.class);
	}

	public void singIn() {
		DriverContext.WaitForElementVisible(singIn);
		singIn.click();
	}

	public HomePage informaLogin() {
		DriverContext.WaitForElementVisible(informaLogin);
		informaLogin.sendKeys("");
		return GetInstance(HomePage.class);
	}

	public HomePage informaPassword() {
		DriverContext.WaitForElementVisible(informaPassword);
		informaPassword.sendKeys("");
		return GetInstance(HomePage.class);
	}

	public HomePage btnSignIn() {
		DriverContext.WaitForElementVisible(singIn);
		singIn.click();
		return GetInstance(HomePage.class);
	}

	public void gerarValor() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		Random random = new Random();
		int index = -1;
		for (int i = 0; i < 9; i++) {
			index = random.nextInt(letras.length());
			valorRandom += letras.substring(index, index + 1);
		}
		System.out.println(valorRandom);
	}
}

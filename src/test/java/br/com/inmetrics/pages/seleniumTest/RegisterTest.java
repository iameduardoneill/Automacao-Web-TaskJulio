package br.com.inmetrics.pages.seleniumTest;

import org.junit.Test;

import com.edsoft.framework.base.DriverContext;

import br.com.inmetrics.pages.HomePage;

public class RegisterTest extends TestInitialize {

	@Test
	public void RegistrarTask() throws Exception {
		DriverContext.WaitForPageToLoad();
		CurrentPage = GetInstance(HomePage.class);
		CurrentPage = CurrentPage.As(HomePage.class).singUp();

	}
}

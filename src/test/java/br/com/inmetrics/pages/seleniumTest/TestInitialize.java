package br.com.inmetrics.pages.seleniumTest;

import java.io.IOException;

import org.junit.Before;

import com.edsoft.framework.base.DriverContext;
import com.edsoft.framework.base.FrameworkInitialize;
import com.edsoft.framework.configs.ConfigReader;
import com.edsoft.framework.configs.Settings;
import com.edsoft.framework.utilities.DatabaseUtil;
import com.edsoft.framework.utilities.ExcelUtil;
import com.edsoft.framework.utilities.LogUtil;

public class TestInitialize extends FrameworkInitialize {

	@Before
	public void Initialize() throws IOException {
		// Initilialize Config
		ConfigReader.PopulateSettings();
		// Logging
		Settings.Logs = new LogUtil();
		Settings.Logs.CreateLogFile();
		Settings.Logs.Write("Framework Initialize");

		
		// Create teste database
		Settings.Logs.Write("Conect ao database");
		Settings.AUTConnection = DatabaseUtil.Open(Settings.AUTConnectionString);
		DatabaseUtil.ExecuteQuery("select * from usuario where cod_usu='1'", Settings.AUTConnection);

		Settings.Logs.Write("Browser Initiliazer");
		initializeBrowser(Settings.BrowserType);
		Settings.Logs.Write("Navegated to URL " + Settings.AUT);
		DriverContext.Browser.Maximize().GoToUrl(Settings.AUT);
		try {
			ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
}

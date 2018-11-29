package com.kshyk.po.neobux;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class LoginPage {

	@FindBy(css = "input[placeholder='Username']")
	private WebElement username;
	@FindBy(css = "input[placeholder='Password']")
	private WebElement password;
	@FindBy(id = "botao_login")
	private WebElement send;
	@FindBy(css = "input[id=Kf3]")
	private WebElement captcha;
	private String login, passwd = null;
	private final WebDriver driver;
	private final BasePage basePage;

	public LoginPage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}

	public final void goToMemberLogin() {
		this.driver.get("https://www.neobux.com/m/l/");
	}

	public final void fillCredentials() {
		if ((this.login == null) && this.passwd == null) {
			this.initCredentials();
		}
		this.basePage.writeText(this.username, this.login);
		this.basePage.writeText(this.password, this.passwd);
	}

	public final void send() {
		this.basePage.click(this.send);
	}

	public final boolean isCaptchaVisible() {
		return this.captcha.isDisplayed();
	}

	public final WebElement getCaptcha() {
		return this.captcha;
	}

	private void initCredentials() {
		final Properties prop = new Properties();
		InputStream inStream = null;
		try {
			inStream = this.getClass().getClassLoader().getResourceAsStream("creds.properties");
			// load a properties file
			prop.load(inStream);
			// set credential fields
			this.login = prop.getProperty("username");
			this.passwd = prop.getProperty("password");
		}
		catch (final IOException ex) {
			this.basePage.getLogger().error("Cannot read creds.properties file.", ex);
		}
		finally {
			if (inStream != null) {
				try {
					inStream.close();
				}
				catch (final IOException ex) {
					this.basePage.getLogger().error("Cannot close input file stream of creds.properties file.", ex);
				}
			}
		}
	}
}
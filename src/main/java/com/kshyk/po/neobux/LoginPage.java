package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage extends BasePage {

    @FindBy(css = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(id = "botao_login")
    private WebElement send;
    @FindBy(css = "input[id=Kf3]")
    private WebElement captcha;
    private String login, passwd = null;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToMemberLogin() {
        driver.get("https://www.neobux.com/m/l/");
    }

    public void fillCredentials() {
        if ((this.login == null) && this.passwd == null) {
            this.initCredentials();
        }
        writeText(this.username, this.login);
        writeText(this.password, this.passwd);
    }

    public void send() {
        click(this.send);
    }

    public boolean isCaptchaVisible() {
        return captcha.isDisplayed();
    }

    public WebElement getCaptcha() {
        return captcha;
    }

    private void initCredentials() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = this.getClass().getClassLoader().getResourceAsStream("creds.properties");
            // load a properties file
            prop.load(input);
            // set credential fields
            this.login = prop.getProperty("username");
            this.passwd = prop.getProperty("password");
        } catch (final IOException ex) {
            logger.error("Cannot read creds.properties file.", ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException ex) {
                    logger.error("Cannot close input file stream of creds.properties file.", ex);
                }
            }
        }
    }
}
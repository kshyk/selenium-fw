package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.testingbot.models.TestingbotTest;
import com.testingbot.testingbotrest.TestingbotREST;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestCase implements TestWatcher {
    private static final String KEY = System.getenv("TESTINGBOT_KEY");
    private static final String SECRET = System.getenv("TESTINGBOT_SECRET");
    private final TestingbotREST tbREST = new TestingbotREST(KEY, SECRET);
    private TestingbotTest test;

    @BeforeAll
    protected void setup() {
        Configuration.timeout = 5000;
        Configuration.remote = "https://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }

    @BeforeEach
    protected void setupTestingbotTest(){
        test = new TestingbotTest();
        test.setSessionId(getSessionId());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        test.setSuccess(false);
        test.setStatusMessage(cause.getMessage());
        test.setName(context.getRequiredTestMethod().getName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test.setSuccess(true);
        test.setName(context.getRequiredTestMethod().getName());
    }

    @AfterEach
    public void sendBackTestStatus(){
        tbREST.updateTest(test);
    }

    private String getSessionId() {
        return ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
    }
}
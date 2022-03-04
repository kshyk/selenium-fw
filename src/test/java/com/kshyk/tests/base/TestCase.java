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

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public abstract class TestCase implements TestWatcher {
    private static final String KEY = System.getenv("TESTINGBOT_KEY");
    private static final String SECRET = System.getenv("TESTINGBOT_SECRET");
    private final TestingbotREST tbREST = new TestingbotREST(KEY, SECRET);
    private TestingbotTest tbTest;

    @BeforeAll
    protected void setup() {
        Configuration.timeout = 5000;
//        Configuration.remote = "https://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
        Configuration.headless = false;
    }

    @BeforeEach
    protected void setupTestingbotTest() {
        tbTest = new TestingbotTest();
        tbTest.setSessionId(getSessionId());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        tbTest.setSuccess(false);
        tbTest.setStatusMessage(cause.getMessage());
        tbTest.setName(getTestMethodName(context));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        tbTest.setSuccess(true);
        tbTest.setName(getTestMethodName(context));
    }

    @AfterEach
    public void sendBackTestStatus() {
//        tbREST.updateTest(tbTest);
    }

    private String getSessionId() {
        return ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
    }

    private String getTestMethodName(ExtensionContext context) {
        return context.getRequiredTestMethod().getName();
    }
}

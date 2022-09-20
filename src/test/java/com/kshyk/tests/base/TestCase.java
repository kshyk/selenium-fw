package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.testingbot.models.TestingbotTest;
import com.testingbot.testingbotrest.TestingbotREST;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;

import static com.kshyk.common.EnvHolder.KEY;
import static com.kshyk.common.EnvHolder.SECRET;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestCase implements TestWatcher {
    private TestingbotREST tbREST;
    private TestingbotTest tbTest;

    @BeforeAll
    protected void setup() {
        Configuration.timeout = 5000;
        Configuration.remote = "https://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
//        var dependencies = new DesiredCapabilities();
//        dependencies.setCapability("extended-debugging", true);
//        Configuration.browserCapabilities = dependencies;
        tbREST = new TestingbotREST(KEY, SECRET);
    }

    @BeforeEach
    protected void setupTestingbotTest() {
        tbTest = new TestingbotTest();
        tbTest.setSessionId(Selenide.sessionId().toString());
        tbTest.setGroups(new ArrayList<>(List.of("regression")));
        tbREST.updateTest(tbTest);
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
        tbREST.updateTest(tbTest);
    }

    private String getTestMethodName(ExtensionContext context) {
        return context.getRequiredTestMethod().getName();
    }
}

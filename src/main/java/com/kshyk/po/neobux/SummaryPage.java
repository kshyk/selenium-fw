package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends BasePage {

    @FindBy(id = "ch_cliques")
    private WebElement clicksChart;

    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public final WebElement getClicksChart() {
        return clicksChart;
    }
}

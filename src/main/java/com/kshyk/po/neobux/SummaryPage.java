package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class SummaryPage extends BasePage {

	@FindBy(id = "ch_cliques")
	private WebElement clicksChart;

	public SummaryPage(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public final WebElement getClicksChart() {
		return this.clicksChart;
	}
}

package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class SummaryPage extends AbstractPage {
	
	@FindBy(id = "ch_cliques")
	private WebElement clicksChart;
	
	public SummaryPage(final WebDriver driver) {
		super(driver);
	}
	
	public final WebElement getClicksChart() {
		return this.clicksChart;
	}
}

package com.kshyk.enums.teamandpersonal;

import com.codeborne.selenide.SelenideElement;
import com.kshyk.common.CommonUtil;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public enum SocialMedia {
    FACEBOOK("topka-facebook", "https://www.facebook.com/TeamAndPersonal/?ref=bookmarks"),
    GOOGLE_PLUS("topka-google", "https://plus.google.com/+TeamandpersonalPl"),
    YOUTUBE("topka-youtube", "https://www.youtube.com/channel/UCealDsXd2QtuW_on0wjSqtw"),
    LINKED_IN("topka-linkedin", "https://www.linkedin.com/company/teamandpersonal/"),
    PINTEREST("topka-pinterest", "https://www.pinterest.com/teampersonal/"),
    INSTAGRAM("topka-instagram", "https://www.instagram.com/teamandpersonal/"),
    TWITTER("topka-twitter", "https://twitter.com/TeamAndPersonal");

    private final String className;
    private final String url;

    SocialMedia(String className, String url) {
        this.className = className;
        this.url = url;
    }

    public SelenideElement getSelenideElement() {
        return $(className(className));
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(name());
    }
}
package io.fake.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class MainPage {

    public CategoryPage openCategoryPage(String category) {
        $$x("//table//div[@class='main_category']//a")
                .stream()
                .filter(selenideElement -> selenideElement.has(Condition.text(category)))
                .findFirst()
                .ifPresent(SelenideElement::click);
        return new CategoryPage();
    }
}

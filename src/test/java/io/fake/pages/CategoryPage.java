package io.fake.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class CategoryPage {

    public SubCategoryPage openSubCategoryPage(String subCategory) {
        $$x("//a[@class='a_category']")
                .stream()
                .filter(selenideElement -> selenideElement.has(Condition.text(subCategory)))
                .findFirst()
                .ifPresent(SelenideElement::click);
        return new SubCategoryPage();
    }
}

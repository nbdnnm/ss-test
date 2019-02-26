package io.fake;

import io.fake.pages.MemoPage;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {

    public MemoPage openMemo() {
        $x("//a[@title='Memo']").click();
        return new MemoPage();
    }
}

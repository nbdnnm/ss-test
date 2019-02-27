package io.fake;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.fake.elements.AlertMessage;
import io.fake.elements.NavigationMenu;
import io.fake.pages.AdvertisementPage;
import io.fake.pages.MainPage;
import io.fake.pages.MemoPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SSTest {

    String portalURL = "https://www.ss.com/en";

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
    }

    @Test
    public void testAddToFavoriteAlert() {
        addAdvertisementToFavorites("Vacancies", "Administrator", 1);
        assertAlertMessageAddedToFavorites();
    }

    @Test
    public void testFavoriteAddedToMemo() {
        String advertisementLink = addAdvertisementToFavorites("Vacancies", "Administrator", 2).
                getAdvertisementLink();
        MemoPage memos = new NavigationMenu().openMemo();
        assertTrue(memos.isThereMemoWithLink(advertisementLink));
    }

    @Test
    public void testTwoFavoritesAddedToMemo() {
        String advertisementLinkFirst = addAdvertisementToFavorites("Vacancies", "Administrator", 5)
                .getAdvertisementLink();
        String advertisementLinkSecond = addAdvertisementToFavorites("Vacancies", "Administrator", 6)
                .getAdvertisementLink();
        MemoPage memos = new NavigationMenu().openMemo();

        assertTrue(memos.isThereMemoWithLink(advertisementLinkFirst));
        assertTrue(memos.isThereMemoWithLink(advertisementLinkSecond));
    }

    @Test
    public void testOpenAdvertisementFromFavorite() {
        String originalAdvertisementLink = addAdvertisementToFavorites("Vacancies", "Administrator", 3)
                .getAdvertisementLink();
        String advertisementLinkOpenedFromMemo = new NavigationMenu()
                .openMemo()
                .openAdvertisementFromMemoWithLink(originalAdvertisementLink)
                .getAdvertisementLink();
        assertEquals(originalAdvertisementLink, advertisementLinkOpenedFromMemo);
    }

    //issue! functionality doesn't work as expected, alert message is not translated
    @Test
    public void testFavoriteAddedFromSearch() {
        open(portalURL);
        new NavigationMenu()
                .openSearch()
                .searchByWord("Linux")
                .selectAdvertisements(1)
                .selectAdvertisements(2)
                .addToFavourites();
        assertAlertMessageAddedToFavorites();
    }

    private AdvertisementPage addAdvertisementToFavorites(String category, String subCategory, Integer advertisementNumber) {
        open(portalURL);
        return new MainPage()
                .openCategoryPage(category)
                .openSubCategoryPage(subCategory)
                .openAdvertisement(advertisementNumber)
                .addToFavourites();
    }

    private void assertAlertMessageAddedToFavorites() {
        new AlertMessage()
                .getAlertMessage()
                .shouldHave(Condition.matchesText("Advertisement added to favorites."));
    }
}

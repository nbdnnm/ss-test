**Tests for https://www.ss.com/en portal**

**Used tech stack**: 

Java, gradle, selenide, junit

**Structure**:

src/test/java/io.fake.elements - elements which may appear on different pages (navigation menu, alert window)

src/test/java/io.fake.pages - pages of the portal used in tests

**How to run**:

gradlew clean test

One of the test fails due to bug on the portal, alert message is not translated on the search page

Potential improvements: 
- move browser type, portal link into parameters
- add Allure reporting with screenshots and sourcepage of failed tests
- parallel run per class/method
- selenoid as selenium server
- checks of javascript console on errors during testing
- etc

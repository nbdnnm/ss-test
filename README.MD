**Tests for https://www.ss.com/en portal**

**Used tech stack**: 

Java, gradle, selenide, junit

**Structure**:

src/test/java/io.fake.elements - elements which may appear on different pages (navigation menu, alert window)

src/test/java/io.fake.pages - pages of the portal used in tests

**How to run**:

gradlew clean test

One of test fails do to bug on the portal, alert message is not translated on the search page
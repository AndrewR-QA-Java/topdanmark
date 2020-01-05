package dk.stqa.pft.topdanmark.tests;

import org.testng.annotations.Test;

public class WebsiteAccessibilityTests extends TestBase {

  @Test
  public void websiteAccessibility() {
    app.getAccessibilityHelper().fillSearchRequest("topdanmark");
    app.getAccessibilityHelper().submitSearchRequest();
    app.getAccessibilityHelper().selectFirstResult();
    app.getAccessibilityHelper().validateTheResult("Log ind");
  }
}

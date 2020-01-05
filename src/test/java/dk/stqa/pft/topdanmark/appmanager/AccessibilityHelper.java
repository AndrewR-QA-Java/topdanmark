package dk.stqa.pft.topdanmark.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccessibilityHelper extends HelperBase {

  public AccessibilityHelper(WebDriver wd) {
    super(wd);
  }

  public void fillSearchRequest(String query) {
    type(By.cssSelector("input[name='q']"), query);
  }

  public void submitSearchRequest() {
    sendKeyToElement(By.cssSelector("input[name='q']"), Keys.ENTER);
  }

  public void selectFirstResult() {
    click(By.cssSelector(("h3.LC20lb")));
  }

  public void validateTheResult(String validation_string) {
    Assert.assertEquals(wd.findElement(By.cssSelector("li > a.btn.btn-login.btn-primary")).getText(), validation_string);
  }
}

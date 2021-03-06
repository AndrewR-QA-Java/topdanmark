package dk.stqa.pft.topdanmark.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private AccessibilityHelper accessibilityHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      wd = new EdgeDriver();
    }
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("https://www.google.com/");
    accessibilityHelper = new AccessibilityHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public AccessibilityHelper getAccessibilityHelper() {
    return accessibilityHelper;
  }
}

package org.example;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setBinary("browsers/chrome-linux64/chrome");
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();

    try {
      System.out.println("Please enter url: ");
      String url = input.nextLine();
      System.out.println("Please enter name: ");
      String name = input.nextLine();
      driver.get(url);
      boolean keywordCount = searchKeywords(driver, name);
      driver.quit();
      System.out.println("Keyword found: " + keywordCount);
    } finally {
      driver.quit();
    }
  }

  public static boolean searchKeywords(WebDriver driver, String keyword) {
    String pageSource = driver.getPageSource();
    return pageSource.toLowerCase().contains(keyword.toLowerCase().trim());
  }
}

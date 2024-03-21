package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setBinary("browsers/chrome-linux64/chrome");
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get("https://www.selenium.dev/");
    driver.quit();
  }
}

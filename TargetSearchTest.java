import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TargetSearchTest {

    public static void main(String[] args) {
        // System path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thein\\OneDrive\\Desktop\\QA\\SQA109 Software Test Automation Level 1 - 0124\\Selenium Projects\\chromedriver-win64\\chromedriver.exe");

        // Search term to use
        String searchTerm = "electronics";

        WebDriver driver = null;

        try {
            // Create a new WebDriver instance
            driver = new ChromeDriver();

            // Open Target homepage
            driver.get("https://www.target.com/");

            // Explicit wait for search bar visibility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            // Enter search term
            searchBar.sendKeys(searchTerm);

            // Click search button
            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
            searchButton.click();

            // Explicit wait for search results
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.h-flex-direction-row.h-display-flex.h-flex-wrap.h-flex-justify-center")));


            // Verify search term presence in results
            String pageTitle = driver.getTitle();
            if (pageTitle.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Search term found in title: " + pageTitle);
            } else {
                System.out.println("Search term not found in title.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred during test: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // Close the browser
            }
        }
    }
}
# Target Search Test

This Java program, `TargetSearchTest.java`, uses Selenium WebDriver to automate a search on the Target website.

## Project Description

The program automates the following steps:

1.  Opens the Target homepage in a Chrome browser.
2.  Locates the search bar.
3.  Enters a predefined search term ("electronics").
4.  Clicks the search button.
5.  Waits for the search results page to load.
6.  Verifies that the search term is present in the page title.
7.  Prints a message indicating whether the search term was found in the title.
8.  Closes the browser.

This program demonstrates a basic test case for verifying search functionality on a website. It uses Selenium's explicit wait to handle asynchronous page loading.

## Features

* Demonstrates how to set up and use Selenium WebDriver with ChromeDriver.
* Shows how to interact with web page elements (search bar, button).
* Implements explicit wait using `WebDriverWait` and `ExpectedConditions`.
* Verifies the presence of a search term in the page title.
* Handles potential exceptions during the test execution.
* Properly closes the browser and quits the WebDriver instance.

## How to Use

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * Selenium WebDriver Java library added to the project.
    * ChromeDriver installed and the system property `webdriver.chrome.driver` set to the correct path.

2.  **Compile the Java code:**

    ```bash
    javac TargetSearchTest.java
    ```

3.  **Run the compiled code:**

    ```bash
    java TargetSearchTest
    ```

    The program will open a Chrome browser, perform the search on Target, verify the results, and print the verification message.

## Code Explanation

The `TargetSearchTest.java` file contains the following code:

* **`System.setProperty("webdriver.chrome.driver", "[Local URL to Web Driver]");`**: Configures the system property to specify the location of the ChromeDriver executable. **Note:** You must replace `"[Local URL to Web Driver]"` with the actual path to your ChromeDriver.
* **`String searchTerm = "electronics";`**: Defines the search term.
* **`WebDriver driver = new ChromeDriver();`**: Initializes a new ChromeDriver instance.
* **`driver.get("https://www.target.com/");`**: Opens the Target homepage.
* **`WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));`**: Creates a `WebDriverWait` instance with a timeout of 10 seconds.
* **`wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));`**: Waits until the search bar element is visible.
* **`searchBar.sendKeys(searchTerm);`**: Enters the search term into the search bar.
* **`searchButton.click();`**: Clicks the search button.
* **`wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.h-flex-direction-row.h-display-flex.h-flex-wrap.h-flex-justify-center")));`**: Waits until the search results are visible
* **`driver.getTitle();`**: Gets the title of the page.
* **`pageTitle.toLowerCase().contains(searchTerm.toLowerCase())`**: Checks if the page title contains the search term.
* **`driver.quit();`**: Closes the browser and terminates the WebDriver session in the `finally` block.

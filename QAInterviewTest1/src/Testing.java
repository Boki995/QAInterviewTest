import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {

	public static void main(String[] args) {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(chromeOptions);

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

		driver.manage().window().maximize();
		driver.navigate().to("https://www.etsy.com");

		//  ******** 1.Logging into website ********
		boolean isDisplayed = driver.findElement(By.className(
				"wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin"))
				.isDisplayed();

		if (isDisplayed == true) {

			System.out.println("Sign in button is Displayed on page");

		} else {

			System.out.println("Sign in button can't be found on page");

		}

		driver.findElement(By.className(
				"wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin"))
				.click();
		WebDriver email = (WebDriver) driver.findElement(By.id("join_neu_email_field"));
		WebDriver password = (WebDriver) driver.findElement(By.id("join_neu_password_field"));
		WebDriver login = (WebDriver) driver.findElement(By.name("submit_attempt"));

		String emailRand = generateRandomName(10);

		String passwordRand = generateRandomName(8);
		((WebElement) email).sendKeys(emailRand);

		((WebElement) password).sendKeys(passwordRand);

		((WebElement) login).click();

		((WebElement) email).clear();

		((WebElement) password).clear();

		((WebElement) email).sendKeys("vonoh34916@flmcat.com");

		((WebElement) password).sendKeys("asdASD12!");

		((WebElement) login).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
	
		WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit_attempt")));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// ******** 2.Categories filtering ********

		WebDriver categories = (WebDriver) driver.findElement(By.id("catnav-primary-link-10855"));

		Actions action = new Actions(driver);

		action.moveToElement((WebElement) categories).perform();

		driver.findElement(By.id("side-nav-category-link-10856")).click();

		driver.findElement(By.className("wt-checkbox__label wt-display-inline")).click();
		driver.findElement(By.className("wt-radio__label wt-display-inline")).click();

		boolean isSelected = driver.findElement(By.className("wt-checkbox__label wt-display-inline")).isSelected();

		if (isSelected == true) {

			System.out.println("Checkbox on filter is selected");

		} else {

			System.out.println("Checkbox on filter is not selected");

		}

		driver.findElement(By.id("search-filter-min-price-input")).sendKeys("20");
		driver.findElement(By.id("search-filter-max-price-input")).sendKeys("100", Keys.ENTER);

		driver.navigate().refresh();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// ******** 3. Adding item to Cart ********
		driver.findElement(By.id(" text-gray text-truncate mb-xs-0 text-body ")).click();

		boolean isEnabled = driver.findElement(By.className("wt-btn wt-btn--filled wt-width-full")).isEnabled();

		if (isEnabled == false) {

			System.out.println("Select colors from dropdown menu first");

		} else {

			System.out.println("Item is in the cart");

		}

		Select drodownMenu = new Select(driver.findElement(By.id("inventory-variation-select-0")));

		drodownMenu.selectByVisibleText("Bronze");

		Select drodownMenu1 = new Select(driver.findElement(By.id("inventory-variation-select-1")));

		drodownMenu.selectByValue("1013381002");

		driver.findElement(By.className("wt-btn wt-btn--filled wt-width-full")).click();
 
		
		
		
		
		
		
		
		
		
		
		
		
		
		// ******** 4. Maneging cart items ********

		System.setProperty("webdriver.firefox.driver", "resources/geckodriver.exe");
		WebDriver driverfirefox = new FirefoxDriver();

		driverfirefox.manage().window().maximize();
		driverfirefox.navigate().to("https://www.etsy.com");

		WebDriver search = (WebDriver) driverfirefox.findElement(By.id("global-enhancements-search-query"));

		((WebElement) search).sendKeys("Bridal jewelry hair long vine", Keys.ENTER);

		driverfirefox
				.findElement(By.className(
						"wt-tooltip__trigger wt-tooltip__trigger--icon-only wt-btn wt-btn--transparent wt-btn--icon"))
				.click();

		driverfirefox
				.findElement(By.className("wt-pb-xs-2 wt-text-body-01 wt-line-height-tight wt-text-black wt-nudge-b-2"))
				.click();

		driverfirefox.findElement(By.className("wt-text-body-01 wt-line-height-tight wt-text-black wt-nudge-b-2"))
				.click();

		driverfirefox.findElement(By.className("wt-textarea")).sendKeys("");

		driverfirefox.findElement(By.className("proceed-to-checkout wt-btn wt-btn--filled wt-mt-xs-2 wt-width-full"))
				.click();

		
		
		
		
		
		
		
		
		
		
		
		
		// ******** 5. Favorite items ********

		driverfirefox.navigate().back();

		driverfirefox.findElement(By.className(
				"wt-tooltip__trigger wt-tooltip__trigger--icon-only wt-btn wt-btn--transparent wt-btn--icon reduced-margin-xs"))
				.click();

		driverfirefox.findElement(By.className(
				"btn--focus  wt-position-absolute wt-btn wt-btn--light wt-btn--small wt-z-index-2 wt-btn--filled wt-btn--icon neu-default-favorite wt-position-right wt-position-top neu-hover-on-card neu-default-button-position fav-opacity-full neu-favorite-cancel-animation"))
				.click();

		driverfirefox.findElement(By.id("favorites-filter-dropdown_button")).click();

		for (int i = 0; i < 50; i++) {
			// click the button 50 times
			driverfirefox.findElement(By.id("favorites-filter-only-available-checkbox")).click();
			// wait 2 seconds
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		driverfirefox.quit();

	}

	public static String generateRandomName(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}

}

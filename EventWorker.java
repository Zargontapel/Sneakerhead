import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by jlanham3 on 10/4/2016.
 */
public class EventWorker implements Runnable {

    PaymentDetails payment;
    EventDetails event;

    public void run() {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.out.println(System.getProperty("user.dir"));

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        driver.get(event.getUrl());
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement visibleElement = driver.findElement(By.xpath("//a[@id='pdp_size_select']"));
        System.out.println(visibleElement.getTagName());
        Actions act = new Actions(driver);
        act.moveToElement(visibleElement).click().perform();
        System.out.println(visibleElement);


        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("Jordan");
            }
        });
        //waitForPageToLoad();
//        WebElement sizeButton = driver.findElement(By.xpath("//a[@id='pdp_size_select']"));
//        System.out.println(sizeButton.getCssValue("background-image"));

//        WebElement sizeOption = driver.findElement(By.linkText(event.getSize()));
//        sizeOption.click();

//        if(!event.getQuantity().equals("1")) {
//            WebElement increaseQuantity = driver.findElement(By.className("add_quantity"));
//            for (int i = 1; i < Integer.getInteger(event.getQuantity()); i++) {
//                increaseQuantity.click();
//            }
//        }


        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds


        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }

    public EventWorker(PaymentDetails payment, EventDetails event){
        this.payment = payment;
        this.event = event;
    }

}

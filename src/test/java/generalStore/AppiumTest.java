package generalStore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class AppiumTest {
    public static void main(String[] args) throws Exception {
        // setup desired capabilities

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy A51");
        capabilities.setCapability("appium:udid", "R58NA5CK9ME");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:appPackage", "com.androidsample.generalstore");
        capabilities.setCapability("appium:appActivity", ".SplashActivity");
        capabilities.setCapability("appium:automationName", "UIAutomator2");

        // инициализируем драйвер
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        String currentPackage = driver.getCurrentPackage();
        if (currentPackage.equals("com.androidsample.generalstore")) {
            System.out.println("Application has loaded successfully and the package is avaliable");
        } else {
            System.out.println("Application failed and the package is not avaliable");
            driver.quit();
            return;
        }
        try {
            WebElement bucket = driver.findElement(By.id("com.androidsample.generalstore:id/splashscreen"));
            System.out.println("element with id 'com.androidsample.generalstore:id/splashscreen' is present");
        } catch (Exception e) {
            System.out.println("element is not present");
        }
        WebElement toolBarGeneralStore = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
        WebElement selectCountryText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select the country where you want to shop\"]"));
        WebElement youNameText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Your Name\"]"));
        WebElement genderText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Gender\"]"));


        //          driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        System.out.println("Checking property of the element find by ID");

        //creating method создаем метод с любым названием, обращаясь к найденному элементу
        verifyElementProperties(toolBarGeneralStore);
        verifyTextProperties(selectCountryText);
        verifyYourNameProperties(youNameText);
        verifyGenderProperties(genderText);

    }

    private static void verifyElementProperties(WebElement element) {
        // check if Title is displayed
        if (element.isDisplayed()) {
            System.out.println("Title 'General store'  is present on page");
        } else {
            System.out.println("Title 'General store'  is absent!!! on page");
        }

        // check if Title is enabled
        if (element.isEnabled()) {
            System.out.println("Title 'General store'  is enable");
        } else {
            System.out.println("Title 'General store'  is not enable");
        }

        // Check if the Title is clickable
        String clickableAttribute = element.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Element is not clickable.");
        } else {
            System.out.println("Element is clickable!!!");
        }
        // check is the Title is displayed
        String displayedAttribute = element.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Element is displayed");
        } else {
            System.out.println("Element is not displayed!!!");
        }
        // check is the Title is focusable
        String focusableAttribute = element.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Element is not focusable");
        } else {
            System.out.println("Element is focusable!!!");
        }
        // check is the Title is focused
        String focusedAttribute = element.getAttribute("focused");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Element is not focused");
        } else {
            System.out.println("Element is focused!!!");
        }
        // check is the Title is scrollable
        String scrollableAttribute = element.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Element is not scrollable");
        } else {
            System.out.println("Element is scrollable!!!");
        }
        // check is the Title is selected
        String selectedAttribute = element.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Element is not selected");
        } else {
            System.out.println("Element is selected!!!");
        }
        // check if the Title's text is "General Store"
        String expectedResultTitleText = "General Store";
        String actualResultTitleText = element.getText();
        if (actualResultTitleText.equals(expectedResultTitleText)) {
            System.out.println("Text 'General Store' is correct");
            System.out.println("Element text: " + element.getText());
        } else {
            System.out.println("Text 'General Store' is not correct!!!");
            System.out.println("Element text: " + element.getText());
        }
}

    private static void verifyTextProperties(WebElement element) {
        // check if Text is displayed
        if (element.isDisplayed()) {
            System.out.println("Text 'Select the country where you want to shop'  is present on page");
        } else {
            System.out.println("Text 'Select the country where you want to shop'  is absent!!! on page");
        }
        // check if Text has text  "Select the country where you want to shop"
        String textAttribute = element.getAttribute("text");
        if ("Select the country where you want to shop".equals(textAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is correct");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is not correct!!!");
        }

        // check if Text is enabled
        if (element.isEnabled()) {
            System.out.println("Text 'Select the country where you want to shop'  is enable");
        } else {
            System.out.println("Text 'Select the country where you want to shop'  is not enable");
        }

        // Check if the Text is clickable
        String clickableAttribute = element.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not clickable.");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is clickable!!!");
        }
        // check is the Text is displayed
        String displayedAttribute = element.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is displayed");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is not displayed!!!");
        }
        // check is the Text is focusable
        String focusableAttribute = element.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not focusable");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is focusable!!!");
        }
        // check is the Text is focused
        String focusedAttribute = element.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not focused");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is focused!!!");
        }
        // check is the Text is scrollable
        String scrollableAttribute = element.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not scrollable");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is scrollable!!!");
        }
        // check is the Text is selected
        String selectedAttribute = element.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not selected");
        } else {
            System.out.println("Text 'Select the country where you want to shop' is selected!!!");
        }
        // check if the Text is "Select the country where you want to shop"
        String expectedResultText = "Select the country where you want to shop";
        String actualResultText = element.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text 'Select the country where you want to shop' is correct");
            System.out.println("Element text: " + element.getText());
        } else {
            System.out.println("Text 'Select the country where you want to shop' is not correct!!!");
            System.out.println("Element text: " + element.getText());
        }
//        System.out.println("Element text: " + element.getText());
    }

    private static void verifyYourNameProperties(WebElement element) {
        // check if Text1 is displayed
        if (element.isDisplayed()) {
            System.out.println("Text 'Your Name'  is present on page");
        } else {
            System.out.println("Text 'Your Name'  is absent!!! on page");
        }
        // check if Text1 has text  "Your Name"
        String textAttribute = element.getAttribute("text");
        if ("Your Name".equals(textAttribute)) {
            System.out.println("Text 'Your Name' is correct");
        } else {
            System.out.println("Text 'Your Name' is not correct!!!");
        }

        // check if Text1 is enabled
        if (element.isEnabled()) {
            System.out.println("Text 'Your Name'  is enable");
        } else {
            System.out.println("Text 'Your Name'  is not enable");
        }

        // Check if the Text1 is clickable
        String clickableAttribute = element.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Your Name' is not clickable.");
        } else {
            System.out.println("Text 'Your Name' is clickable!!!");
        }
        // check is the Text1 is displayed
        String displayedAttribute = element.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Your Name' is displayed");
        } else {
            System.out.println("Text 'Your Name' is not displayed!!!");
        }
        // check is the Text1 is focusable
        String focusableAttribute = element.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Your Name' is not focusable");
        } else {
            System.out.println("Text 'Your Name' is focusable!!!");
        }
        // check is the Text1 is focused
        String focusedAttribute = element.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Your Name' is not focused");
        } else {
            System.out.println("Text 'Your Name' is focused!!!");
        }
        // check is the Text1 is scrollable
        String scrollableAttribute = element.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Your Name' is not scrollable");
        } else {
            System.out.println("Text 'Your Name' is scrollable!!!");
        }
        // check is the Text1 is selected
        String selectedAttribute = element.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Your Name' is not selected");
        } else {
            System.out.println("Text 'Your Name' is selected!!!");
        }
        // check if the Text1 is "Your Name"
        String expectedResultText = "Your Name";
        String actualResultText = element.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text is correct");
            System.out.println("Element text: " + element.getText());
        } else {
            System.out.println("Text is not correct!!!");
            System.out.println("Element text: " + element.getText());
        }

    }


    private static void  verifyGenderProperties(WebElement text2) {
        // check if Text2 is displayed
        if (text2.isDisplayed()) {
            System.out.println("Text 'Gender'  is present on page");
        } else {
            System.out.println("Text 'Gender'  is absent!!! on page");
        }
        // check if Text2 has text  "Gender"
        String textAttribute = text2.getAttribute("text");
        if ("Gender".equals(textAttribute)) {
            System.out.println("Text 'Gender' is correct");
        } else {
            System.out.println("Text 'Gender' is not correct!!!");
        }

        // check if Text2 is enabled
        if (text2.isEnabled()) {
            System.out.println("Text 'Gender'  is enable");
        } else {
            System.out.println("Text 'Gender'  is not enable");
        }

        // Check if the Text2 is clickable
        String clickableAttribute = text2.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Gender' is not clickable.");
        } else {
            System.out.println("Text 'Gender' is clickable!!!");
        }
        // check is the Text2 is displayed
        String displayedAttribute = text2.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Gender' is displayed");
        } else {
            System.out.println("Text 'Gender' is not displayed!!!");
        }
        // check is the Text2 is focusable
        String focusableAttribute = text2.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Gender' is not focusable");
        } else {
            System.out.println("Text 'Gender' is focusable!!!");
        }
        // check is the Text2 is focused
        String focusedAttribute = text2.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Gender' is not focused");
        } else {
            System.out.println("Text 'Gender' is focused!!!");
        }
        // check is the Text2 is scrollable
        String scrollableAttribute = text2.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Gender' is not scrollable");
        } else {
            System.out.println("Text 'Gender' is scrollable!!!");
        }
        // check is the Text2 is selected
        String selectedAttribute = text2.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Gender' is not selected");
        } else {
            System.out.println("Text 'Gender' is selected!!!");
        }
        // check if the Text2 is "Gender"
        String expectedResultText = "Gender";
        String actualResultText = text2.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text 'Gender' is correct");
            System.out.println("Element text: " + text2.getText());
        } else {
            System.out.println("Text 'Gender' is not correct!!!");
            System.out.println("Element text: " + text2.getText());
        }

    }

}
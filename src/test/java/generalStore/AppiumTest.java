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
        //finding all elements on the tab

        WebElement toolBarGeneralStore = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
        WebElement selectCountryText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select the country where you want to shop\"]"));
        WebElement youNameText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Your Name\"]"));
        WebElement genderText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Gender\"]"));
        WebElement countryList = driver.findElement(By.id("android:id/text1"));
        WebElement picture = driver.findElement(By.xpath("//android.widget.ImageView"));
        WebElement spinnerCountry = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]"));
        WebElement maleRadio = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));

        //          driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        System.out.println("Checking property of the element find by ID");

        //creating method создаем метод с любым названием, обращаясь к найденному элементу
        verifyElementProperties(toolBarGeneralStore);
        verifyTextProperties(selectCountryText);
        verifyYourNameProperties(youNameText);
        verifyGenderProperties(genderText);
        verifyCountryProperties(countryList);
        verifyPictureProperties(picture);
        verifySpinnerCountryProperties(spinnerCountry);
        verifySMaleRadioProperties(maleRadio);
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
    private static void verifyCountryProperties(WebElement country){
        // checking if this element has correct text
       String countryTextByDefault ="Afghanistan";
       String actualCountryText = country.getText();

        if(actualCountryText.equals(countryTextByDefault)) {
            System.out.println("Country text by default is correct and equal 'Afghanistan' ");
        } else {
            System.out.println(("Country text by default is not correct!!! and equal " + country.getText()));
        }
        // check is element displayed on the tab
        if (country.isDisplayed()) {
            System.out.println("Country 'Afghanistan'  is present on page");
        } else {
            System.out.println("Country 'Afghanistan'  is absent!!! on page");
        }
        // check if Country is enabled
        if (country.isEnabled()) {
            System.out.println("Country 'Afghanistan'  is enable");
        } else {
            System.out.println("TCountry 'Afghanistan'  is not enable");
        }
        // Check if the Country 'Afghanistan' is clickable
        String clickableAttribute = country.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Country 'Afghanistan' is not clickable.");
        } else {
            System.out.println("Country 'Afghanistan' is clickable!!!");
        }
        // check if Country 'Afghanistan' is focusable
        String focusableAttribute = country.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Country 'Afghanistan' is not focusable");
        } else {
            System.out.println("Country 'Afghanistan' is focusable!!!");
        }
        // check if the Country 'Afghanistan' is focused
        String focusedAttribute = country.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Country 'Afghanistan' is not focused");
        } else {
            System.out.println("Country 'Afghanistan' is focused!!!");
        }
        // check if the Country 'Afghanistan' is scrollable
        String scrollableAttribute = country.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Country 'Afghanistan' is not scrollable");
        } else {
            System.out.println("Country 'Afghanistan'' is scrollable!!!");
        }
        // check if the Country 'Afghanistan' is selected
        String selectedAttribute = country.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Country 'Afghanistan' is not selected");
        } else {
            System.out.println("Country 'Afghanistan' is selected!!!");
        }
        //check if the Country 'Afghanistan' is checked
        String checkedAttribute = country.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("Country 'Afghanistan' is not checked");
        } else {
            System.out.println("Country 'Afghanistan' is checked!!!");
        }
    }
    private static void verifyPictureProperties(WebElement picture){
            // check is element displayed on the tab
        if (picture.isDisplayed()) {
            System.out.println("Picture  is present on page");
        } else {
            System.out.println("Picture is absent!!! on page");
        }
        // check if Picture is enabled
        if (picture.isEnabled()) {
            System.out.println("Picture  is enable");
        } else {
            System.out.println("Picture is not enable");
        }
        // Check if the Picture is clickable
        String clickableAttribute = picture.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Country 'Afghanistan' is not clickable.");
        } else {
            System.out.println("Country 'Afghanistan' is clickable!!!");
        }
        // check if picture is focusable
        String focusableAttribute = picture.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("picture is not focusable");
        } else {
            System.out.println("picture is focusable!!!");
        }
        // check if the picture' is focused
        String focusedAttribute = picture.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("picture is not focused");
        } else {
            System.out.println("picture is focused!!!");
        }
        // check if the picture is scrollable
        String scrollableAttribute = picture.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("picture is not scrollable");
        } else {
            System.out.println("picture is scrollable!!!");
        }
        // check if the picture is selected
        String selectedAttribute = picture.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("picture is not selected");
        } else {
            System.out.println("picture is selected!!!");
        }
        //check if the picture is checked
        String checkedAttribute = picture.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("picture is not checked");
        } else {
            System.out.println("picture is checked!!!");
        }
    }
    private static void verifySpinnerCountryProperties(WebElement arrow){
        // check is element displayed on the tab
        if (arrow.isDisplayed()) {
            System.out.println("arrow  is present on page");
        } else {
            System.out.println("arrow is absent!!! on page");
        }
        // check if arrow is enabled
        if (arrow.isEnabled()) {
            System.out.println("arrow  is enable");
        } else {
            System.out.println("arrow is not enable");
        }
        // Check if the arrowis clickable
        String clickableAttribute = arrow.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("arrow is clickable.");
        } else {
            System.out.println("arrow is not clickable!!!");
        }
        // check if arrow is focusable
        String focusableAttribute = arrow.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("arrow is focusable");
        } else {
            System.out.println("arrow is not focusable!!!");
        }
        // check if the arrow is focused
        String focusedAttribute = arrow.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("arrow is not focused");
        } else {
            System.out.println("arrow is focused!!!");
        }
        // check if the arrow is scrollable
        String scrollableAttribute = arrow.getAttribute("scrollable");
        if ("true".equals(scrollableAttribute)) {
            System.out.println("arrow is scrollable");
        } else {
            System.out.println("arrow is not scrollable!!!");
        }
        // check if the arrow is selected
        String selectedAttribute = arrow.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("arrow is not not selected");
        } else {
            System.out.println("arrow is selected!!!");
        }
        //check if the arrow is checked
        String checkedAttribute = arrow.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("arrow picture is not checked");
        } else {
            System.out.println("arrow is  checked");
    }
    }
    private static void verifySMaleRadioProperties(WebElement male){
        // checking if this element has correct text
        String expectedMaleRadioText ="Male";
        String actualMaleRadioText = male.getText();

        if(actualMaleRadioText.equals(expectedMaleRadioText)) {
            System.out.println(" male text  is correct and equal 'Male' ");
        } else {
            System.out.println(("male text is not correct!!! and equal " + male.getText()));
        }
        // check is element displayed on the tab
        if (male.isDisplayed()) {
            System.out.println("male  is present on page");
        } else {
            System.out.println("male is absent!!! on page");
        }
        // check if male is enabled
        if (male.isEnabled()) {
            System.out.println("male  is enable");
        } else {
            System.out.println("male is not enable");
        }
        // Check if the male is clickable
        String clickableAttribute = male.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("male is clickable.");
        } else {
            System.out.println("male is not clickable!!!");
        }
        // check if male is focusable
        String focusableAttribute = male.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("male is focusable");
        } else {
            System.out.println("male is not focusable!!!");
        }
        // check if the male is focused
        String focusedAttribute = male.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("male is not focused");
        } else {
            System.out.println("male is focused!!!");
        }
        // check if the male is scrollable
        String scrollableAttribute = male.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("male is not scrollable");
        } else {
            System.out.println("male is scrollable!!!");
        }
        // check if the male is selected
        String selectedAttribute =male.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("male is not not selected");
        } else {
            System.out.println("male is selected!!!");
        }
        //check if the male is checked
        String checkedAttribute = male.getAttribute("checked");
        if ("true".equals(checkedAttribute)) {
            System.out.println("male picture is checked");
        } else {
            System.out.println("male is  not checked");
        }
        //check if the male is checkable
        String checkableAttribute = male.getAttribute("checkable");
        if ("true".equals(checkableAttribute)) {
            System.out.println("male picture is checkable");
        } else {
            System.out.println("male is  not checkable");
        }
    }
}
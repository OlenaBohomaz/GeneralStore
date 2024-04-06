package generalStore;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class OnboardingTest {
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

        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
        WebElement selectCountryText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select the country where you want to shop\"]"));
        WebElement yourNameText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Your Name\"]"));
        WebElement genderText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Gender\"]"));
        WebElement country = driver.findElement(By.id("android:id/text1"));
        WebElement picture = driver.findElement(By.xpath("//android.widget.ImageView"));
        WebElement spinnerCountry = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]"));
        WebElement maleRadio = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
        WebElement femaleRadio = driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
        WebElement inputName = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        WebElement button = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        WebElement albania = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='android:id/text1'])[1]"));
     //   WebElement country = driver.findElement(By.id("android:id/text1[1]"));

        //          driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        System.out.println("Checking property of the element find by ID");

        //creating method создаем метод с любым названием, обращаясь к найденному элементу
        verifyElementProperties(title);
        verifyTextProperties(selectCountryText);
        verifyYourNameProperties(yourNameText);
        verifyGenderProperties(genderText);
        verifyCountryProperties(country);
        verifyPictureProperties(picture);
        verifySpinnerCountryProperties(spinnerCountry);
        verifyMaleRadioProperties(maleRadio);
        verifyFemaleRadioProperties(femaleRadio);
        verifyInputProperties(inputName);
        driver.hideKeyboard();
        verifyIButtonProperties(button);

        scrollDown(driver);
//        verifyAlbaniaProperties(albania);
//        verifyCountrySelected(country);


    }

    private static void verifyElementProperties(WebElement title) {
        // check if Title is displayed
        if (title.isDisplayed()) {
            System.out.println("Title 'General store'  is present on page");
        } else {
            System.out.println("TEST FAILED! Title 'General store'  is absent!!! on page");
        }

        // check if Title is enabled
        if (title.isEnabled()) {
            System.out.println("Title 'Genera" +
                    "l store'  is enable");
        } else {
            System.out.println("TEST FAILED! Title 'General store'  is not enable!!!");
        }
        // Check if the Title is clickable
        String clickableAttribute = title.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Element is not clickable.");
        } else {
            System.out.println("TEST FAILED! Element is clickable!!!");
        }
        // check is the Title is displayed
        String displayedAttribute = title.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Element is displayed");
        } else {
            System.out.println("TEST FAILED! Element is not displayed!!!");
        }
        // check is the Title is focusable
        String focusableAttribute = title.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Element is not focusable");
        } else {
            System.out.println("TEST FAILED! Element is focusable!!!");
        }
        // check is the Title is focused
        String focusedAttribute = title.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("title is not focused");
        } else {
            System.out.println("TEST FAILED! title is focused!!!");
        }
        // check is the Title is scrollable
        String scrollableAttribute = title.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("title is not scrollable");
        } else {
            System.out.println("TEST FAILED! title is scrollable!!!");
        }
        // check is the Title is selected
        String selectedAttribute = title.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("title is not selected");
        } else {
            System.out.println("TEST FAILED! title is selected!!!");
        }
        // check if the Title's text is "General Store"
        String expectedResultTitleText = "General Store";
        String actualResultTitleText = title.getText();
        if (actualResultTitleText.equals(expectedResultTitleText)) {
            System.out.println("Text 'General Store' is correct");
            System.out.println("Element text: " + title.getText());
        } else {
            System.out.println("TEST FAILED! Text 'General Store' is not correct!!!");
            System.out.println("Element text: " + title.getText());
        }
}

    private static void verifyTextProperties(WebElement selectCountryText) {
        // check if selectCountryText is displayed
        if (selectCountryText.isDisplayed()) {
            System.out.println("Text 'Select the country where you want to shop'  is present on page");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop'  is absent!!! on page");
        }
        // check if selectCountryText has text  "Select the country where you want to shop"
        String textAttribute = selectCountryText.getAttribute("text");
        if ("Select the country where you want to shop".equals(textAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is correct");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is not correct!!!");
        }
        // check if selectCountryText is enabled
        if (selectCountryText.isEnabled()) {
            System.out.println("Text 'Select the country where you want to shop'  is enable");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop'  is not enable!!!!");
        }
        // Check if the selectCountryText is clickable
        String clickableAttribute = selectCountryText.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not clickable.");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is clickable!!!");
        }
        // check is the selectCountryText is displayed
        String displayedAttribute = selectCountryText.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is displayed");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is not displayed!!!");
        }
        // check is the selectCountryText is focusable
        String focusableAttribute = selectCountryText.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not focusable");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is focusable!!!");
        }
        // check is the selectCountryText is focused
        String focusedAttribute = selectCountryText.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not focused");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is focused!!!");
        }
        // check is the selectCountryText is scrollable
        String scrollableAttribute = selectCountryText.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not scrollable");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is scrollable!!!");
        }
        // check is the selectCountryText is selected
        String selectedAttribute = selectCountryText.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Select the country where you want to shop' is not selected");
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is selected!!!");
        }
        // check if the Text is "Select the country where you want to shop"
        String expectedResultText = "Select the country where you want to shop";
        String actualResultText = selectCountryText.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text 'Select the country where you want to shop' is correct");
            System.out.println("Element text: " + selectCountryText.getText());
        } else {
            System.out.println("TEST FAILED! Text 'Select the country where you want to shop' is not correct!!!");
            System.out.println("Element text: " + selectCountryText.getText());
        }
//        System.out.println("Element text: " + element.getText());
    }

    private static void verifyYourNameProperties(WebElement yourNameText) {
        // check if yourNameText is displayed
        if (yourNameText.isDisplayed()) {
            System.out.println("Text 'Your Name'  is present on page");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name'  is absent!!! on page");
        }
        // check if yourNameText has text  "Your Name"
        String textAttribute = yourNameText.getAttribute("text");
        if ("Your Name".equals(textAttribute)) {
            System.out.println("Text 'Your Name' is correct");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is not correct!!!");
        }
        // check if yourNameText is enabled
        if (yourNameText.isEnabled()) {
            System.out.println("Text 'Your Name'  is enable");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name'  is not enable!!!");
        }
        // Check if the yourNameText is clickable
        String clickableAttribute = yourNameText.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Your Name' is not clickable.");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is clickable!!!");
        }
        // check is the yourNameText is displayed
        String displayedAttribute =yourNameText.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Your Name' is displayed");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is not displayed!!!");
        }
        // check is the yourNameText is focusable
        String focusableAttribute = yourNameText.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Your Name' is not focusable");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is focusable!!!");
        }
        // check is the yourNameText is focused
        String focusedAttribute = yourNameText.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Your Name' is not focused");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is focused!!!");
        }
        // check is the yourNameText is scrollable
        String scrollableAttribute = yourNameText.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Your Name' is not scrollable");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is scrollable!!!");
        }
        // check is the yourNameText is selected
        String selectedAttribute = yourNameText.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Your Name' is not selected");
        } else {
            System.out.println("TEST FAILED! Text 'Your Name' is selected!!!");
        }
        // check if the yourNameText has "Your Name" text
        String expectedResultText = "Your Name";
        String actualResultText = yourNameText.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text is correct");
            System.out.println("Element text: " + yourNameText.getText());
        } else {
            System.out.println("TEST FAILED! Text is not correct!!!");
            System.out.println("Element text: " + yourNameText.getText());
        }
    }

    private static void  verifyGenderProperties(WebElement genderText) {
        // check if genderText is displayed
        if (genderText.isDisplayed()) {
            System.out.println("Text 'Gender'  is present on page");
        } else {
            System.out.println("TEST FAILED! Text 'Gender'  is absent!!! on page");
        }
        // check if genderText has text  "Gender"
        String textAttribute = genderText.getAttribute("text");
        if ("Gender".equals(textAttribute)) {
            System.out.println("Text 'Gender' is correct");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is not correct!!!");
        }
        // check if genderText is enabled
        if (genderText.isEnabled()) {
            System.out.println("Text 'Gender'  is enable");
        } else {
            System.out.println("TEST FAILED! Text 'Gender'  is not enable!!!");
        }
        // Check if the genderText is clickable
        String clickableAttribute = genderText.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Text 'Gender' is not clickable.");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is clickable!!!");
        }
        // check is the genderText is displayed
        String displayedAttribute = genderText.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Text 'Gender' is displayed");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is not displayed!!!");
        }
        // check is the genderText is focusable
        String focusableAttribute = genderText.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Text 'Gender' is not focusable");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is focusable!!!");
        }
        // check is the genderText is focused
        String focusedAttribute = genderText.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Text 'Gender' is not focused");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is focused!!!");
        }
        // check is the genderText is scrollable
        String scrollableAttribute = genderText.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Text 'Gender' is not scrollable");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is scrollable!!!");
        }
        // check is the genderText is selected
        String selectedAttribute = genderText.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Text 'Gender' is not selected");
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is selected!!!");
        }
        // check if the genderText is "Gender"
        String expectedResultText = "Gender";
        String actualResultText = genderText.getText();
        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Text 'Gender' is correct");
            System.out.println("Element text: " + genderText.getText());
        } else {
            System.out.println("TEST FAILED! Text 'Gender' is not correct!!!");
            System.out.println("Element text: " + genderText.getText());
        }
    }
    public static void verifyCountryProperties(WebElement country){
        // checking if country has correct text
       String countryTextByDefault ="Afghanistan";
       String actualCountryText = country.getText();

        if(actualCountryText.equals(countryTextByDefault)) {
            System.out.println("Country text by default is correct and equal 'Afghanistan' ");
        } else {
            System.out.println(("TEST FAILED! Country text by default is not correct!!! and equal " + country.getText()));
        }
        // check is country displayed on the tab
        if (country.isDisplayed()) {
            System.out.println("Country 'Afghanistan'  is present on page");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan'  is absent!!! on page");
        }
        // check if Country is enabled
        if (country.isEnabled()) {
            System.out.println("Country 'Afghanistan'  is enable");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan'  is not enable!!!!");
        }
        // Check if the Country 'Afghanistan' is clickable
        String clickableAttribute = country.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Country 'Afghanistan' is not clickable.");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is clickable!!!");
        }
        // check if Country 'Afghanistan' is focusable
        String focusableAttribute = country.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Country 'Afghanistan' is not focusable");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is focusable!!!");
        }
        // check if the Country 'Afghanistan' is focused
        String focusedAttribute = country.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("Country 'Afghanistan' is not focused");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is focused!!!");
        }
        // check if the Country 'Afghanistan' is scrollable
        String scrollableAttribute = country.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("Country 'Afghanistan' is not scrollable");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan'' is scrollable!!!");
        }
        // check if the Country 'Afghanistan' is selected
        String selectedAttribute = country.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("Country 'Afghanistan' is not selected");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is selected!!!");
        }
        //check if the Country 'Afghanistan' is checked
        String checkedAttribute = country.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("Country 'Afghanistan' is not checked");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is checked!!!");
        }
    }
    private static void verifyPictureProperties(WebElement picture){
            // check is element displayed on the tab
        if (picture.isDisplayed()) {
            System.out.println("Picture  is present on page");
        } else {
            System.out.println("TEST FAILED! Picture is absent!!! on page");
        }
        // check if Picture is enabled
        if (picture.isEnabled()) {
            System.out.println("Picture  is enable");
        } else {
            System.out.println("TEST FAILED! Picture is not enable!!!!");
        }
        // Check if the Picture is clickable
        String clickableAttribute = picture.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Country 'Afghanistan' is not clickable.");
        } else {
            System.out.println("TEST FAILED! Country 'Afghanistan' is clickable!!!");
        }
        // check if picture is focusable
        String focusableAttribute = picture.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("picture is not focusable");
        } else {
            System.out.println("TEST FAILED! picture is focusable!!!");
        }
        // check if the picture' is focused
        String focusedAttribute = picture.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("picture is not focused");
        } else {
            System.out.println("TEST FAILED! picture is focused!!!");
        }
        // check if the picture is scrollable
        String scrollableAttribute = picture.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("picture is not scrollable");
        } else {
            System.out.println("TEST FAILED! picture is scrollable!!!");
        }
        // check if the picture is selected
        String selectedAttribute = picture.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("picture is not selected");
        } else {
            System.out.println("TEST FAILED! picture is selected!!!");
        }
        //check if the picture is checked
        String checkedAttribute = picture.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("picture is not checked");
        } else {
            System.out.println("TEST FAILED! picture is checked!!!");
        }
    }
        private static void verifyMaleRadioProperties(WebElement maleRadio){
           // check is maleRadio displayed on the tab
        if (maleRadio.isDisplayed()) {
            System.out.println("male  is present on page");
        } else {
            System.out.println("TEST FAILED! male is absent!!! on page");
        }
        // check if maleRadio is enabled
        if (maleRadio.isEnabled()) {
            System.out.println("male  is enable");
        } else {
            System.out.println("TEST FAILED! male is not enable!!!!");
        }
        // Check if the maleRadio is clickable
        String textAttribute = maleRadio.getAttribute("clickable");
        if ("true".equals(textAttribute)) {
            System.out.println("male is clickable.");
        } else {
            System.out.println("TEST FAILED! male is not clickable!!!");
        }
        // check if maleRadio is focusable
        String focusableAttribute = maleRadio.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("male is focusable");
        } else {
            System.out.println("TEST FAILED! male is not focusable!!!");
        }
        // check if the maleRadio is focused
        String focusedAttribute = maleRadio.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("male is not focused");
        } else {
            System.out.println("TEST FAILED! male is focused!!!");
        }
        // check if the maleRadio is scrollable
        String scrollableAttribute = maleRadio.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("male is not scrollable");
        } else {
            System.out.println("TEST FAILED! male is scrollable!!!");
        }
        // check if the maleRadio is selected
        String selectedAttribute =maleRadio.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("male is not not selected");
        } else {
            System.out.println("TEST FAILED! male is selected!!!");
        }
        //check if the maleRadio is checked
        String checkedAttribute = maleRadio.getAttribute("checked");
        if ("true".equals(checkedAttribute)) {
            System.out.println("male picture is checked");
        } else {
            System.out.println("TEST FAILED! male is  not checked!!!");
        }
        //check if the maleRadio is checkable
        String checkableAttribute = maleRadio.getAttribute("checkable");
        if ("true".equals(checkableAttribute)) {
            System.out.println("male picture is checkable");
        } else {
            System.out.println("TEST FAILED! male is  not checkable!!!");
        }
    }
    private static void verifyFemaleRadioProperties(WebElement female){
        // checking if this element has correct text
        String expectedFemaleRadioText ="Female";
        String actualFemaleRadioText = female.getText();

        if(actualFemaleRadioText.equals(expectedFemaleRadioText)) {
            System.out.println(" female text  is correct and equal:" + female.getText());
        } else {
            System.out.println("TEST FAILED! female text is not correct!!! and equal " + female.getText());
        }
        // check is element displayed on the tab
        if (female.isDisplayed()) {
            System.out.println("female  is present on page");
        } else {
            System.out.println("TEST FAILED! female is absent!!! on page");
        }
        // check if female is enabled
        if (female.isEnabled()) {
            System.out.println("female  is enable");
        } else {
            System.out.println("TEST FAILED! female is not enable!!!!");
        }
        // Check if the female is clickable
        String clickableAttribute = female.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("female is clickable.");
        } else {
            System.out.println("TEST FAILED! female is not clickable!!!");
        }
        // check if female is focusable
        String focusableAttribute = female.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("female is focusable");
        } else {
            System.out.println("TEST FAILED! female is not focusable!!!");
        }
        // check if the female is focused
        String focusedAttribute = female.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("female is not focused");
        } else {
            System.out.println("TEST FAILED! female is focused!!!");
        }
        // check if the female is scrollable
        String scrollableAttribute = female.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("female is not scrollable");
        } else {
            System.out.println("TEST FAILED! female is scrollable!!!");
        }
        // check if the female is selected
        String selectedAttribute =female.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("female is not not selected");
        } else {
            System.out.println("TEST FAILED! female is selected!!!");
        }
        //check if the female is checked
        String checkedAttribute = female.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("female picture is not checked");
        } else {
            System.out.println("TEST FAILED! female is checked!!!");
        }
        //check if the female is checkable
        String checkableAttribute = female.getAttribute("checkable");
        if ("true".equals(checkableAttribute)) {
            System.out.println("female picture is checkable");
        } else {
            System.out.println("TEST FAILED! female is  not checkable!!!");
        }
        female.click();
        //check if the female is checked after clicking
        String checkedAttributeAfterTapping = female.getAttribute("checked");
        if ("true".equals(checkedAttributeAfterTapping)) {
            System.out.println("female is checked after  tapping");
        } else {
            System.out.println("TEST FAILED! female is NOT checked after  tapping!!!");
        }

    }
    private static void verifyInputProperties(WebElement inputName){
        // checking if this element has correct text
        String expectedPlaceholderText ="Enter name here";
        String actualPlaceholderText = inputName.getText();

        if(actualPlaceholderText.equals(expectedPlaceholderText)) {
            System.out.println(" placeholder text  is correct and equal " + inputName.getText());
        } else {
            System.out.println("TEST FAILED! placeholder text is not correct!!! and equal " + inputName.getText());
        }
        // check is element displayed on the tab
        if (inputName.isDisplayed()) {
            System.out.println("input  is present on page");
        } else {
            System.out.println("TEST FAILED! input is absent!!! on page");
        }
        // check if female is enabled
        if (inputName.isEnabled()) {
            System.out.println("input  is enable");
        } else {
            System.out.println("TEST FAILED! input is not enable!!!!");
        }
        // Check if the input is clickable
        String clickableAttribute = inputName.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("input is clickable.");
        } else {
            System.out.println("TEST FAILED! input is not clickable!!!");
        }
        // check if input is focusable
        String focusableAttribute = inputName.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("input is focusable");
        } else {
            System.out.println("TEST FAILED! input is not focusable!!!");
        }
        // check if the input is focused
        String focusedAttribute = inputName.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("input is not focused");
        } else {
            System.out.println("TEST FAILED! input is focused!!!");
        }
        // check if the input is scrollable
        String scrollableAttribute = inputName.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("input is not scrollable");
        } else {
            System.out.println("TEST FAILED! input is scrollable!!!");
        }
        // check if the input is selected
        String selectedAttribute = inputName.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("input is not selected");
        } else {
            System.out.println("TEST FAILED! input is selected!!!");
        }
        //check if the input is checked
        String checkedAttribute = inputName.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("input  is not checked");
        } else {
            System.out.println("TEST FAILED! input is checked!!!");
        }
        //check if the input is checkable
        String checkableAttribute = inputName.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("input is not checkable");
        } else {
            System.out.println("TEST FAILED! input is  checkable!!!");
        }
        inputName.click();

        // check if the input is focused after clicking
        String focusedAttributeAfterTapping = inputName.getAttribute("focused");
        if ("true".equals(focusedAttributeAfterTapping)) {
            System.out.println("input is focused after tapping");
        } else {
            System.out.println("TEST FAILED! input is not focused after tapping!!!");
        }
        inputName.sendKeys("Ivan");

        // checking if this element has correct text
        String expectedInputNameText ="Ivan";
        String actualInputNameText = inputName.getText();

        if(actualInputNameText.equals(expectedInputNameText)) {
            System.out.println(" name  is correct and equal " + inputName.getText());
        } else {
            System.out.println("TEST FAILED! name is not correct!!! and equal " + inputName.getText());
        }
    }
    private static void verifyIButtonProperties(WebElement button){
        // checking if this element has correct text
        String expectedButtonText ="Let's  Shop";
        String actualButtonText = button.getText();

        if(actualButtonText.equals(expectedButtonText)) {
            System.out.println(" button text  is correct and equal " + button.getText());
        } else {
            System.out.println("TEST FAILED! button text is not correct!!! and equal " + button.getText());
        }
        // check is element displayed on the tab
        if (button.isDisplayed()) {
            System.out.println("button is present on page");
        } else {
            System.out.println("TEST FAILED! button is absent!!! on page");
        }
        // check if button is enabled
        if (button.isEnabled()) {
            System.out.println("button  is enable");
        } else {
            System.out.println("TEST FAILED! button is not enable!!!");
        }
        // Check if the button is clickable
        String clickableAttribute = button.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("button is clickable.");
        } else {
            System.out.println("TEST FAILED! button is not clickable!!!");
        }
        // check if button is focusable
        String focusableAttribute = button.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("button is focusable");
        } else {
            System.out.println("TEST FAILED! button is not focusable!!!");
        }
        // check if the button is focused
        String focusedAttribute = button.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("button  is not focused");
        } else {
            System.out.println("TEST FAILED! button is focused!!!");
        }
        // check if the button is scrollable
        String scrollableAttribute = button.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("button is not scrollable");
        } else {
            System.out.println("TEST FAILED! button is scrollable!!!");
        }
        // check if the button is selected
        String selectedAttribute =button.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("button is not selected");
        } else {
            System.out.println("TEST FAILED! button is selected!!!");
        }
        //check if the button is checked
        String checkedAttribute = button.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("button is not checked");
        } else {
            System.out.println("TEST FAILED! button is checked!!!");
        }
        //check if the button is checkable
        String checkableAttribute = button.getAttribute("checkable");
        if ("false".equals(checkableAttribute)) {
            System.out.println("button is not checkable");
        } else {
            System.out.println("TEST FAILED! button is  checkable!!!");
        }
     button.click();

    }
    private static void verifySpinnerCountryProperties(WebElement spinnerCountry){
        // check if spinnerCountry is enabled
        if (spinnerCountry.isEnabled()) {
            System.out.println("spinnerCountry  is enable");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is not enable!!!!");
        }
        // Check if the spinnerCountry is clickable
        String clickableAttribute = spinnerCountry.getAttribute("clickable");
        if ("true".equals(clickableAttribute)) {
            System.out.println("spinnerCountry is clickable.");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is not clickable!!!");
        }
        // check if spinnerCountry is focusable
        String focusableAttribute = spinnerCountry.getAttribute("focusable");
        if ("true".equals(focusableAttribute)) {
            System.out.println("spinnerCountry is focusable");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is not focusable!!!");
        }
        // check if the spinnerCountry is focused
        String focusedAttribute = spinnerCountry.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("spinnerCountry is not focused");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is focused!!!");
        }
        // check if the spinnerCountry is scrollable
        String scrollableAttribute = spinnerCountry.getAttribute("scrollable");
        if ("true".equals(scrollableAttribute)) {
            System.out.println("spinnerCountry is scrollable");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is not scrollable!!!");
        }
        // check if the spinnerCountry is selected
        String selectedAttribute = spinnerCountry.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("spinnerCountry is not selected");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is selected!!!");
        }
        //check if the spinnerCountry is checked
        String checkedAttribute = spinnerCountry.getAttribute("checked");
        if ("false".equals(checkedAttribute)) {
            System.out.println("spinnerCountry  is not checked");
        } else {
            System.out.println("TEST FAILED! spinnerCountry is  checked");
        }
        // check is spinnerCountry displayed on the tab
        if (spinnerCountry.isDisplayed()) {
            System.out.println("spinnerCountry  is present on page");
            // spinnerCountry.click();
        } else {
            System.out.println("TEST FAILED! spinnerCountry is absent!!! on page");
        }
   //     spinnerCountry.click();
    }
//
//    public static void verifyAlbaniaProperties(WebElement albania){
//        // check is element displayed on the tab
//        if (albania.isDisplayed()) {
//            System.out.println("Albania  is present on page");
//        } else {
//            System.out.println("TEST FAILED! Albania is absent!!! on page");
//        }
//        // check if Albania is enabled
//        if (albania.isEnabled()) {
//            System.out.println("Albania  is enable");
//        } else {
//            System.out.println("TEST FAILED! Albania is not enable!!!!");
//        }
//        // Check if Albania is clickable
//        String clickableAttribute = albania.getAttribute("clickable");
//        if ("true".equals(clickableAttribute)) {
//            System.out.println("Albania is clickable.");
//        } else {
//            System.out.println("TEST FAILED! Albania is not clickable!!!");
//        }
//        // check if Albania is focusable
//        String focusableAttribute = albania.getAttribute("focusable");
//        if ("true".equals(focusableAttribute)) {
//            System.out.println("Albania is focusable");
//        } else {
//            System.out.println("TEST FAILED! Albania is not focusable!!!");
//        }
//        // check if Albania is focused
//        String focusedAttribute = albania.getAttribute("focused");
//        if ("false".equals(focusedAttribute)) {
//            System.out.println("Albania is not focused");
//        } else {
//            System.out.println("TEST FAILED! Albania is focused!!!");
//        }
//        // check if the Albania is scrollable
//        String scrollableAttribute = albania.getAttribute("scrollable");
//        if ("true".equals(scrollableAttribute)) {
//            System.out.println("Albania is scrollable");
//        } else {
//            System.out.println("TEST FAILED! Albania is not scrollable!!!");
//        }
//        // check if Albania is selected
//        String selectedAttribute = albania.getAttribute("selected");
//        if ("false".equals(selectedAttribute)) {
//            System.out.println("Albania is not not selected");
//        } else {
//            System.out.println("TEST FAILED! Albania is selected!!!");
//        }
//        //check if Albania is checked
//        String checkedAttribute = albania.getAttribute("checked");
//        if ("false".equals(checkedAttribute)) {
//            System.out.println("Albania is not checked");
//        } else {
//            System.out.println("TEST FAILED! Albania is  checked");
//        }
//        albania.click();
//
//        // verifyCountrySelected(albania);
//     }
//    public static void verifyCountrySelected(WebElement country) {
//        // checking if this element has correct text
//        String expectedCountryText ="Albania";
//        String actualCountryText = country.getText();
//
//        if (actualCountryText.equals(expectedCountryText)) {
//            System.out.println("Country selected is correct and equal " + country.getText());
//        } else {
//            System.out.println("TEST FAILED! Country selected is not correct!!! and equal " + country.getText());
//        }
//    }


    public static void scrollDown(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int starty = (int) (size.height * 0.50);
//        int endy = (int) (size.height * 0.20);
//        int startx = size.width / 2;
//
//        TouchAction action = new TouchAction(driver);
//
//        action.press(PointOption.point(startx, starty))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
//                .moveTo(PointOption.point(startx, endy))
//                .release()
//                .perform();

        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.80);
        int endY = (int) (size.height * 0.20);


        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();


    }
}
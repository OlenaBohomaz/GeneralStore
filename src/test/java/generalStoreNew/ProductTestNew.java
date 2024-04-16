package generalStoreNew;

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

public class ProductTestNew {
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
        WebElement inputName = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        WebElement button = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));

        //       WebElement secondTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));
        //      WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/appbar_btn_cart")));

        System.out.println("Checking property of the element find by ID");

        //creating method создаем метод с любым названием, обращаясь к найденному элементу
        verifyTitleProperties(title);
        verifyInputProperties(inputName);
        driver.hideKeyboard();
        verifyIButtonProperties(button);
        System.out.println("Go to the Product page");

        WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/appbar_btn_cart")));
        WebElement secondTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        WebElement firstPicture = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.androidsample.generalstore:id/productImage\"])[1]"));
        WebElement firstProductName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 4 Retro\"]"));
        WebElement firstProductPrice = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\"$160.97\"]"));
        WebElement firstProductCard = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout"));
        WebElement productList = driver.findElement(By.id("com.androidsample.generalstore:id/rvProductList"));

        verifyCartProperties(cart);
        verifySecondTitleProperties(secondTitle);
        verifyFirstPictureProperties(firstPicture);
        verifyFirstProductNameProperties(firstProductName);
        verifyFirstProductPriceProperties(firstProductPrice);
        verifyFirstProductCardProperties(firstProductCard);
        verifyProductListProperties(productList);
        scrollDown(driver);
        cart.click();



//        WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[@text=\"Toast message\"]")));
        WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[@text=\"Please add some product at first\"]")));
       verifyToastProperties(toast);

        scrollDown(driver);
        WebElement addToCartButton = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"));
        verifyAddToCartButton(addToCartButton);
        WebElement counterCart = driver.findElement(By.id("com.androidsample.generalstore:id/counterText"));
        verifyCounterCart(counterCart);



    //    scrollDown(driver);

    }
    public static void verifyTitleProperties(WebElement title) {
        // check if Title is displayed
        if (title.isDisplayed()) {
            System.out.println("Title 'General store'  is present on page");
        } else {
            System.out.println("TEST FAILED! Title 'General store'  is absent!!! on page");
        }
    }
    public static void verifyInputProperties(WebElement inputName) {
        inputName.click();
        inputName.sendKeys("Olena");
        String actualName = inputName.getAttribute("Text");
        if (actualName.equals("Olena")) {
            System.out.println("inputName is correct");
        } else {
            System.out.println("inputName is not correct and equals" + inputName.getAttribute("Text"));
        }
    }
    public static void verifyIButtonProperties(WebElement button) {
        button.click();
    }
    public static void verifyCartProperties(WebElement cart) {
        // check if cart is displayed
        if (cart.isDisplayed()) {
            System.out.println("cart is present on page");
        } else {
            System.out.println("TEST FAILED! cart is absent!!! on page");
        }

    }
    public static void verifySecondTitleProperties(WebElement secondTitle) {
        // check if secondTitle is displayed
        if (secondTitle.isDisplayed()) {
            System.out.println("secondTitle 'Products'  is present on page");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products'  is absent!!! on page");
        }
        // check if secondTitle is enabled
        if (secondTitle.isEnabled()) {
            System.out.println("secondTitle 'Products' is enabled");
        } else {
            System.out.println("TEST FAILED! secondTitle 'Products'  is not enabled!!!");
        }
        // Check if the secondTitle is clickable
        String clickableAttribute = secondTitle.getAttribute("clickable");
        if ("false".equals(clickableAttribute)) {
            System.out.println("Element secondTitle is not clickable.");
        } else {
            System.out.println("TEST FAILED! Element secondTitle  is clickable!!!");
        }
        // check is the secondTitle is displayed
        String displayedAttribute = secondTitle.getAttribute("displayed");
        if ("true".equals(displayedAttribute)) {
            System.out.println("Element secondTitle is displayed");
        } else {
            System.out.println("TEST FAILED! Element secondTitle is not displayed!!!");
        }
        // check is the secondTitle is focusable
        String focusableAttribute = secondTitle.getAttribute("focusable");
        if ("false".equals(focusableAttribute)) {
            System.out.println("Element secondTitle  is not focusable");
        } else {
            System.out.println("TEST FAILED! Element secondTitle  is focusable!!!");
        }
        // check is the Title is focused
        String focusedAttribute = secondTitle.getAttribute("focused");
        if ("false".equals(focusedAttribute)) {
            System.out.println("secondTitle is not focused");
        } else {
            System.out.println("TEST FAILED! secondTitle is focused!!!");
        }
        // check is the secondTitle is scrollable
        String scrollableAttribute = secondTitle.getAttribute("scrollable");
        if ("false".equals(scrollableAttribute)) {
            System.out.println("secondTitle is not scrollable");
        } else {
            System.out.println("TEST FAILED! secondTitle is scrollable!!!");
        }
        // check is the secondTitle is selected
        String selectedAttribute = secondTitle.getAttribute("selected");
        if ("false".equals(selectedAttribute)) {
            System.out.println("secondTitle is not selected");
        } else {
            System.out.println("TEST FAILED! secondTitle is selected!!!");
        }
        // check if the secondTitle's text is "Products"
        String expectedResultTitleText = "Products";
        String actualResultTitleText = secondTitle.getText();
        if (actualResultTitleText.equals(expectedResultTitleText)) {
            System.out.println("Text 'Products' is correct");
            System.out.println("Element text: " + secondTitle.getText());
        } else {
            System.out.println("TEST FAILED! Text 'Products' is not correct!!!");
            System.out.println("Element text: " + secondTitle.getText());
        }
    }
    private static void verifyFirstPictureProperties(WebElement firstPicture) {
        // check if firstPicture is displayed
        if (firstPicture.isDisplayed()) {
            System.out.println("firstPicture is present on page");
        } else {
            System.out.println("TEST FAILED! firstPicture is absent!!! on page");
        }
    }
    private static void verifyFirstProductNameProperties(WebElement firstProductName) {
        // check if firstProductName is displayed
        if (firstProductName.isDisplayed()) {
            System.out.println("firstProductName 'Air Jordan 4 Retro' is present on page");
        } else {
            System.out.println("TEST FAILED! firstProductName 'Air Jordan 4 Retro' is absent!!! on page");
        }
    }
    private static void verifyFirstProductPriceProperties(WebElement firstProductPrice) {
        // check if firstProductPrice is displayed
        if (firstProductPrice.isDisplayed()) {
            System.out.println("firstProductPrice '160.97' is present on page");
        } else {
            System.out.println("TEST FAILED! firstProductPrice '160.97' is absent!!! on page");
        }
    }
    private static void verifyFirstProductCardProperties(WebElement firstProductCard) {
        // check if firstProductCard is displayed
        if (firstProductCard.isDisplayed()) {
            System.out.println("firstProductCard is present on page");
        } else {
            System.out.println("TEST FAILED! firstProductCard is absent!!! on page");
        }
    }
    private static void verifyProductListProperties(WebElement productList) {
        // check if ProductList is displayed
        if (productList.isDisplayed()) {
            System.out.println("productList is present on page");
        } else {
            System.out.println("TEST FAILED! productList is absent!!! on page");
        }
    }
    private static void verifyToastProperties(WebElement toast) {

        String textAttribute = toast.getAttribute("text");
        if ("Please add some product at first".equals(textAttribute)) {
            System.out.println("Text toast is correct");
        } else {
            System.out.println("TEST FAILED! Text toast is nor correct!!!");
        }
    }
    public static void scrollDown(AndroidDriver driver) {
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
    private static void verifyAddToCartButton(WebElement addToCartButton) {

        if (addToCartButton.isDisplayed()) {
            System.out.println("addToCartButton is present on page");
        } else {
            System.out.println("TEST FAILED!addToCartButton is absent!!! on page");
        }

        String textAttribute = addToCartButton.getAttribute("text");
        if ("ADD TO CART".equals(textAttribute)) {
            System.out.println("Text 'Add to cart' BUTTON is correct");
        } else {
            System.out.println("TEST FAILED! Text 'Add to cart' BUTTON is not correct!!!");
        }
        addToCartButton.click();
        String textAttributeAfterClicking = addToCartButton.getAttribute("text");
        if ("ADDED TO CART".equals(textAttributeAfterClicking)) {
            System.out.println("Text 'Added to cart' BUTTON is correct");
        } else {
            System.out.println("TEST FAILED! Text 'Added to cart' BUTTON is not correct!!!");
        }

    }

    private static void verifyCounterCart(WebElement counterCart) {

        if (counterCart.isDisplayed()) {
            System.out.println("counterCart is present on page");
        } else {
            System.out.println("TEST FAILED! counterCart is absent!!! on page");
        }

        String textAttribute = counterCart.getAttribute("text");
        if ("1".equals(textAttribute)) {
            System.out.println("Counter is correct");
        } else {
            System.out.println("TEST FAILED! Counter is not correct!!!");
        }

    }

}

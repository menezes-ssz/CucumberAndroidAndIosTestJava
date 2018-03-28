# CucumberAndroidAndIosTestJava
Simple tests in android and ios using cucumber with java.

## Required to run this project

- *Java (used version 8)*
- *Appium*
- *Node*
- *Android Emulator*
- *Maven*
- *Cucumber*
- *MacOS*
- *Xcode*

## How to run tests with your own configurations

1. Set your own capabilities in RemoteWebDriverHelper.java
```Java
if(plataformName.equals("Android")) {
  //Change what you need to run your android apk!
  capabilities.setCapability("app",new File("apps/app-android-calculator.apk"));
  capabilities.setCapability("platformName","Android" );
  capabilities.setCapability("deviceName","Android Emulator API 22");
  capabilities.setCapability("disableAndroidWatchers" , true);
  return appiumDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
}else if(plataformName.equals("Ios")) {
  //Change what you need to run your ios app!
  capabilities.setCapability("app",new File("apps/SimpleCalculator.app"));
  capabilities.setCapability("plataform", "MAC" );
  capabilities.setCapability("plataformName", "ios" );
  capabilities.setCapability("deviceName", "iPhone SE");
  capabilities.setCapability("automationName" , "XCUITest");
  return appiumDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
}...
``` 
2. Paste your app and your apk file in **apps/** folder.
3. Create your features files in **resources/features/**
```Gherkin
Feature: Calculator

Scenario: Sum two numbers
Given i'am in Calculator Screen
When sum two numbers
Then show the result of sum
```
4. Run mvn inside **resources/**
```
$ mvn clean test
```
5. Implement your steps in your class or classes inside **steps_definition/**

```
@Given("^i'am in Calculator Screen$")
public void i_am_in_Calculator_Screen() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^sum two numbers$")
public void sum_two_numbers() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
```   

6. Run the tests with maven sending plataform name by parameter, "Ios" or "Android"
```
$ mvn clean test -Denv.PLATAFORM=Android
```
7.After tests run you can get a pretty simple report in **target/cucumber/index.html**

## Docs and Libs

- Appium: http://appium.io/downloads.html
- Cucumber: https://cucumber.io/docs
- Surefire: http://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html


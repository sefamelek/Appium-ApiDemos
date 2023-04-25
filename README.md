# Appium-ApiDemos

Appium-ApiDemos

**1. Clone the application**

```bash
git clone 
```

**2. Import project in any Editor(Eclispe/Intellij)**

**3. Run appium desktop on default port**

**4. Run testCase.xml**


## Project Structure
### Package & Classes Details

##### actionHelper : In this package common Android functions is present

```bash
AndroidHelperMethods : All the common Android functions is present in this class like click(),Scroll(),Enter() etc.
```
##### DriverManager : In this package We are handling drivers initialization.

```bash
DriverManagerType : We have create an enum for Driver types and its definations
```
```bash
DriverManager : In this class we are creating driver object on the Basis of DriverType  like DriverManagerType.Android,DriverManagerType.IOS
```
##### listners : In this package we are using TestNg ITestlistner for creating report on the basis of Test result

```bash
TestListner :In order to listen to test events such as passed, failed, skipped, etc. we have TestListener class which implements ITestListener.
```
```bash
**onFinish:** This method is invoked after all tests methods gets executed.

**onTestStart:** This method is invoked before any test methods are invoked. This can be used to indicate that the particular test method has been started.

**onTestSkipped:** This method is invoked when each test method is skipped. This can be used to indicate that the particular test method has been skipped.

**onTestSuccess:** This method is invoked when any test method succeeds. This can be used to indicate that the particular test method has successfully finished its execution.

**onTestFailure:** This method is invoked when any test method fails. This can be used to indicate that the particular test method has failed. You can create an event for taking a screenshot which will show where the test has been failed.
```
##### reportManager : In this package we are using Extent report for reporting testCases

```bash
ExtentManager :In this class we are using Extent api and  initialization of Extent object 
```

##### Pages : In this package all the pages of application is present.

```bash
BasePageClass :In this class we have initialize all the page classes using PagePafctory conecepts(PageFactory.initElements)
```
```bash
Pages/AppMenuPages Page :In this class we have all the locators and associated methods.
```
##### TestCases : In this package all the TestCases is present.


```bash
BasePageClass :In this class we have initialize all the page classes using PagePafctory conecepts(PageFactory.initElements)
```
```bash
BaseTest :In this class we have initialize drivers and all the pages.
```
#####


##### TEST CASES ####

Scenario-1:
```bash
Requirements:

1- The application is installed,
2- Permissions are given by default when the app is opened,
3- It is checked that the opened app is the desired app.
'Go to App > ActionBar > Action Bar Tabs' menu. Make sure that the 'Toggle tab
mode' is passive. Add 3 new tabs, check that 3 tabs have been added, the last added tab is deleted
with 'Remove last tab' and it is checked that the correct tab has been deleted. With 'Remove all tabs',
all tabs are deleted and it is checked that there are no active tabs in the activity.
```
Scenario-2:
```bash
Requirement:

1- At this stage, it is reached by making clear cash without deleting the application.
'App > Activity > Custom Title' menu. In the activity that opens, the default textBox
and navigationBar texts are checked. By changing the left and right textBox fields, it is checked that
the relevant textBox and navigationBar texts have changed.
```
Scenario-3:
```bash
Requirement:

1- At this stage, it is reached without clear cash without deleting the application.
(noReset=true)
'Follow the App > Alert Dialogs > List dialog' menu. In the opened activity, any
element is selected in the list dialog, after the selection is made, the order of the selected
element and the name of the element is checked in the alert message.
```

Scenario-4:
```bash
Requirement:

1- At this stage, it is reached without clear cash without deleting the application.
(noReset=true)
'App > Fragment > Context Menu' In the activity that opens, it is checked that the
Menu A and Menu B elements are opened by long pressing the 'long press me' button.
```

Scenario-5:
```bash
Requirement:

1- At this stage, it is reached without clear cash without deleting the application.
(noReset=true)
'App > Fragment> Hide and Show' menus. It is checked that there are two Hide
buttons and two text boxes in the opened activity. Second Click on the 'hide' button and check
that the textBox field is 'Hide' and the 'Hide' button becomes 'Show'. By pressing the 'Show'
button, it is checked that the textBox is back and the button text is 'Hide'.
```

Scenario-6:
```bash
Requirement:

1- At this stage, it is reached without clear cash without deleting the application.
(noReset=true)
'App > Notification > Incoming Message'. In the activity that opens, the 'Show
Notification' button is clicked, the Notification Bar area is opened, and the notification is
checked. Notification is clicked, and it is checked that the notification detail opened and the
text in the notification bar area contain each other.

```

Scenario-7:
```bash
Requirement:

1- At this stage, the application is deleted and reinstalled and the flow continues.
'Views > Tabs menu > 5. Scrollable' menu. Switching to Tab, which is in the last place
in the activity that opens, is checked, after clicking Tab, it is checked that the opened page
information belongs to tab 30.
```
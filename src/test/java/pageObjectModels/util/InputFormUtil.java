package pageObjectModels.util;

import base.*;
import pageObjectModels.locators.InputFormPage;

import java.io.IOException;

import static base.CommonMethods.*;
import static base.ElementsInteractingMethods.*;
//import static base.interactElements.ElementsInteractingMethods.*;


public class InputFormUtil extends  SetUp{


    static InputFormPage iform = new InputFormPage(driver);
    //static CommonSteps common = new CommonSteps();
    static boolean status = false;
    static String statusToString = "false";
    static String url;

    public static boolean is_element_visible(String elementName)
    {
        switch (elementName) {
            case "Logotype": {
                waitUntilVisibility(iform.logotype);
                status = isVisible(iform.logotype);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }

            case "Sponsored_By": {
                waitUntilVisibility(iform.sponsoredBy);
                status = isVisible(iform.sponsoredBy);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }

            case "PopUpWindow_close_button": {
                waitUntilVisibility(iform.closePopUpWindow);
                status = isVisible(iform.closePopUpWindow);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }
            case "Please_enter_your_message": {
                waitUntilVisibility(iform.enterMessage);
                status = isVisible(iform.enterMessage);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }
            case "Your_message": {
                waitUntilVisibility(iform.yourMessage);
                status = isVisible(iform.yourMessage);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }
            case "Show_Message_Button": {
                waitUntilVisibility(iform.showMessageButton);
                status = isVisible(iform.showMessageButton);
                printToLogFile("\tLogotype is visible: ", Boolean.toString(status));
                break;
            }
        }
        return status;
    }

    public static void click_On_Element(String elementName)
    {
        switch (elementName) {

            case "Show_Message_Button": {
                waitUntilVisibility(iform.showMessageButton);
                clickOnButton(iform.showMessageButton);
                break;
            }
            case "PopUpWindow_close_button": {
                waitUntilVisibility(iform.closePopUpWindow);
                clickOnButton(iform.closePopUpWindow);
                break;
            }
            case "Get_total_button": {
                waitUntilVisibility(iform.getTotalButton);
                clickOnButton(iform.getTotalButton);
                break;
            }
        }
    }

    public static String get_Current_URL(String pageName) throws IOException {
        switch (pageName) {
            case "input_form_page": {
                url = getURLFromProperties("inputForm");
                break;
            }
        }
        return url;
    }



    public static boolean verify_text(String elementName) throws IOException {
        switch (elementName) {

            case "Your_message": {
                waitUntilVisibility(iform.yourMessage);
                if (getTextFromExcel("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\resources\\testData\\data1.xlsx", "dataSource", 1,0).equals(getText(iform.yourMessage)))
                     {status = true;}
                else {status = false;}
                printToLogFile("\tText matches: ", Boolean.toString(status));
                break;
            }
            case "Total_a_plus_b":
            {
                waitUntilVisibility(iform.total);
                String sum1= String.valueOf(getNumberFromExcel("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\resources\\testData\\data2.xlsx", "Sheet1", 1, 2));
                printToLogFile("\tSumma: ", sum1);
                String sum2 = getText(iform.total);
                if (sum1.equals(sum2)) {status = true;}
                else {status = false;}
                printToLogFile("\tSumma is right: ", Boolean.toString(status));
              break;
            }

        }
        return status;
    }

    public static void send_text_to_element(String elementName) throws IOException {

        switch (elementName) {
            case "Please_enter_your_message": {
                waitUntilVisibility(iform.enterMessage);
                String single_message = getTextFromExcel("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\resources\\testData\\data1.xlsx", "dataSource", 1, 0);
                sendKeys(iform.enterMessage, single_message);
                printToLogFile("\tText sent to the text box: ", single_message);
                break;
            }
            case "Enter_value_for_a": {
                waitUntilVisibility(iform.valueA);
                int a = getNumberFromExcel("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\resources\\testData\\data2.xlsx", "Sheet1", 1, 0);
                sendKeys(iform.valueA, String.valueOf(a));
                printToLogFile("\tText sent to the text box: ", String.valueOf(a));
                break;
            }
            case "Enter_value_for_b": {
                waitUntilVisibility(iform.valueA);
                int a = getNumberFromExcel("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\resources\\testData\\data2.xlsx", "Sheet1", 1, 1);
                sendKeys(iform.valueB, String.valueOf(a));
                printToLogFile("\tText sent to the text box: ", String.valueOf(a));
                break;
            }
        }
    }

    public static String get_Test_Data_From_Properties(String pageName) throws IOException {
        switch (pageName) {
            case "input_form_page": {
                url = getURLFromProperties("inputForm");
                break;
            }
        }
        return url;
    }

}

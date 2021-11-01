package tests;

import base.ElementsInteractingMethods;
//import base.interactElements.ElementsInteractingMethods;
import base.SetUp;

import org.junit.jupiter.api.*;

import pageObjectModels.locators.InputFormPage;
import pageObjectModels.util.InputFormUtil;

import java.io.IOException;

import static base.CommonMethods.openHomePage;
import static base.CommonMethods.printToLogFile;
import static base.CommonMethods.sleep;
//import static base.interactElements.ElementsInteractingMethods.openHomePage;

import static pageObjectModels.util.InputFormUtil.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputFormsTest extends SetUp {

    public String className = this.getClass().getSimpleName();


    //static boolean status

    static InputFormPage iform = new InputFormPage(driver);
    static InputFormUtil util = new InputFormUtil();
    static ElementsInteractingMethods common = new ElementsInteractingMethods();


    //String SITE_URL = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

    boolean status;

    @BeforeAll
    public static void before() throws IOException {
        printToLogFile("\n", "{");

       // String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
       // String appConfigPath = rootPath + "pageURLs.properties";

        //Properties urlProps = new Properties();
       // urlProps.load(new FileInputStream("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\pageURLs.properties"));

       // String url = urlProps.getProperty("inputForm");
       // System.out.println("URL is: " + url);

    }

    @AfterAll
    public static void after()
    {
        printToLogFile("", "}");
    }

    @DisplayName("Open a website")
    @Test
    @Order(1)
    public void test01_openPage() throws IOException {

        //----------------------------------------------------------------
        printToLogFile("\tClass name is: ", className);
        printToLogFile("\n\tMethodName is: ", Thread.currentThread().getStackTrace()[1].getMethodName());
        //----------------------------------------------------------------

        String Url= get_Test_Data_From_Properties("input_form_page");

        status = openHomePage(Url);
        Assertions.assertTrue(status);

        status = is_element_visible("PopUpWindow_close_button");
        Assertions.assertTrue(status);

        click_On_Element("PopUpWindow_close_button");

        sleep(3000);
    }

    @DisplayName("Test that elements are present on webpage")
    @Test
    @Order(2)
    public void test02_isPresent()
    {
        //----------------------------------------------------------------
        printToLogFile("\n\tMethodName is: ",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        //----------------------------------------------------------------

        status = is_element_visible("Logotype");
        Assertions.assertTrue(status);

        status = is_element_visible("Sponsored_By");
        Assertions.assertTrue(status);
    }


   @Test
   @Order(3)
   //@Disabled
   @DisplayName("Single Input Field")
    public void test03_enterSingleMessage() throws IOException
   {
       //----------------------------------------------------------------
       printToLogFile("\n\tMethodName is: ",
               Thread.currentThread().getStackTrace()[1].getMethodName());
       //----------------------------------------------------------------

       status =is_element_visible("Please_enter_your_message");
       Assertions.assertTrue(status);

       send_text_to_element("Please_enter_your_message");

       status =is_element_visible("Show_Message_Button");
       click_On_Element("Show_Message_Button");
       sleep(3000);

       status = is_element_visible("Your_message");
       Assertions.assertTrue(status);

       status = verify_text("Your_message");
       sleep(3000);
       Assertions.assertTrue(status);
    }

    @Test
    @DisplayName("Enter two messages")
    @Order(4)
    //@Disabled
    public void test04_enterValues() throws IOException {

        //--------------------------------------------------------------
        printToLogFile("\n\tMethodName is: ",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        //--------------------------------------------------------------

        send_text_to_element("Enter_value_for_a");
        sleep(1000);

        send_text_to_element("Enter_value_for_b");
        sleep(1000);

        click_On_Element("Get_total_button");
        sleep(1000);

        status = verify_text("Total_a_plus_b");
        Assertions.assertTrue(status);

    }

    @DisplayName("Test to illustrate that test is failed")
    @Order(5)
    //@Disabled
    @Test
    public void test05_testFailed()
    {
        //----------------------------------------------------------------
        printToLogFile("\n\tMethodName is: ",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        //----------------------------------------------------------------

        Assertions.assertTrue(false);
    }

    @DisplayName("Test to illustrate that test is disabled")
    @Order(6)
    @Disabled
    @Test
    public void test06_disabled()
    {
        //----------------------------------------------------------------
        printToLogFile("\tMethodName is: ",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        //----------------------------------------------------------------

        Assertions.assertTrue(true);
    }

}

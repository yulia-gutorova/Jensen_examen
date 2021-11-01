package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.CommonMethods.printToLogFile;

public class ElementsInteractingMethods extends SetUp {


    //CommonMethods commonMethods= new CommonMethods();

/*    public static Boolean status;

    *//*---------------------------------------------------------------------
    * Method sleep() to take a pause in execution
    *---------------------------------------------------------------------*//*
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

*//*    *//**//*---------------------------------------------------------------------
     * Create a mechanism to write information in result file
     *---------------------------------------------------------------------*//**//*
    public static PrintWriter write_to_file;
    static {
        try {
            write_to_file = new PrintWriter( new BufferedWriter(new FileWriter("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\target\\results.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*//*

    *//*---------------------------------------------------------------------
     * Method printToLogFile() to print information in the log file
     *---------------------------------------------------------------------*//*
    public static void printToLogFile(String str1, String srt2)
    {
        writer.println(str1 + srt2);
    }


    *//*---------------------------------------------------------------------
     * Method openHomePage() to land on a particular home page
     *---------------------------------------------------------------------*//*
    public static boolean openHomePage(String url)
    {
        driver.get(url);
        printToLogFile("\tGiven URL is: ", url);
        if (url.equals(driver.getCurrentUrl()))
        {
            status = true;
            printToLogFile("\tURL is right: ", status.toString());
        }
        else status= false;
        return status;
    }

    *//*---------------------------------------------------------------------
     * Method currentURL() to get current url
     *---------------------------------------------------------------------*//*
    public  static String currentURL()
    {
        String currentURL = driver.getCurrentUrl();
        //printToLogFile("\tCurrent URL is: ", currentURL);
        return currentURL;
    }

    *//*---------------------------------------------------------------------
     * Method getTextFromExcel() to read text information from Excel file
     *---------------------------------------------------------------------*//*
    public static String getTextFromExcel(String fileName, int row, int column) throws IOException {

        FileInputStream inputStream = new FileInputStream(fileName);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);

        XSSFSheet sheet=wb.getSheet("dataSource");
        XSSFRow row2=sheet.getRow(row);
        XSSFCell cell=row2.getCell(column);
        String value= cell.getStringCellValue();
        return value;
    }

    *//*---------------------------------------------------------------------
     * Method getNumberFromExcel() to read numeric information from Excel file
     *---------------------------------------------------------------------*//*
    public static int getNumberFromExcel(String fileName, int row, int column) throws IOException {

        FileInputStream inputStream = new FileInputStream(fileName);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);

        XSSFSheet sheet=wb.getSheet("Sheet1");
        XSSFRow row2=sheet.getRow(row);
        XSSFCell cell=row2.getCell(column);

        double value = cell.getNumericCellValue();
        int resultValue = (int) Math.round(value);
        return resultValue;
    }

    *//*---------------------------------------------------------------------
     * Method getURLFromProperties() to read url from properties by key
     *---------------------------------------------------------------------*//*
    public static String getURLFromProperties(String key) throws IOException {

        Properties urlProps = new Properties();
        urlProps.load(new FileInputStream("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\src\\test\\java\\pageURLs.properties"));

        String url = urlProps.getProperty(key);
        System.out.println("URL is: " + url);
        return url;
    }*/


    //============================ Methods to interact with elements ===================================================


    /*---------------------------------------------------------------------
     * Method waitUntilVisibility() to wait the visibility of the element
     *---------------------------------------------------------------------*/
    public static void waitUntilVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /*---------------------------------------------------------------------
     * Method isVisible() to verify that element is displayed
     *---------------------------------------------------------------------*/
    public static boolean isVisible(WebElement element)
    {
        return element.isDisplayed();
    }

    /*---------------------------------------------------------------------
     * Method clickOnButton() to click on element
     *---------------------------------------------------------------------*/
    public static void clickOnButton(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        if(element.isDisplayed())
        {
            element.click();
        }
       else
        {
            printToLogFile("\tElement is displayed: ", "false" );
        }
    }

    /*---------------------------------------------------------------------
     * Method sendKeys() to send text in element
     *---------------------------------------------------------------------*/
    public static void sendKeys(WebElement element, String str)
    {
        if(element.isDisplayed())
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            element.sendKeys(str);
        }
        else
        {
            printToLogFile("\tSend key to element:", "false" );
        }
    }

    /*---------------------------------------------------------------------
     * Method sendKeys() to get text from the element
     *---------------------------------------------------------------------*/
    public static String getText(WebElement element) {

        if(element.isDisplayed())
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            String text = element.getText();
            printToLogFile("\tText in the element is ", text );
            return text;
        }
        else
        {
            printToLogFile("\tGet text from element: ", "false" );
            return "false";
        }
        }

}

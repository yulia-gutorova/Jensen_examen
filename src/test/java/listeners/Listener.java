package listeners;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import tests.testSuite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//import static base.CommonSteps.write_to_file;


public class Listener extends RunListener{

    public static PrintWriter write_to_file;

    static {
        try {
            write_to_file = new PrintWriter( new BufferedWriter(new FileWriter("C:\\Users\\Yulia\\IdeaProjects\\Demo_Examen_JUnit\\target\\results.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println( "\n-----TestListener-----\n" );
        write_to_file.println("\n-----TestListener started-----\n" );
        Date date=java.util.Calendar.getInstance().getTime();
        write_to_file.println("\nDate: " + date);

        JUnitCore runner = new JUnitCore();
        runner.addListener(new Listener());
        runner.run(testSuite.class);
        System.out.println("\n-----End of testListener-----\n");
        write_to_file.println("\n-----TestListener ended-----\n" );
    }

    //-----------------------------------------------------------------
    //Called before any tests have been run.
    @Override
    public void testRunStarted(Description description) throws Exception {
        //System.out.println( "\nTests run  " + description.getClassName());
        write_to_file.println("\nTests run  " + description.getClassName());
    }

    //-----------------------------------------------------------------
    //Called when an atomic test is about to be started.
    @Override
    public void testStarted (Description description) throws Exception
    {
        write_to_file.println("\nClass: >>>>> " + description.getClassName());
        write_to_file.println("\n     Test started: >>>>> " + description.getDisplayName());
    }

    //-----------------------------------------------------------------
    // Called when an atomic test has finished, whether the test succeeds or fails.
    @Override
    public void testFinished(Description description) throws Exception {

        write_to_file.println( "     Tests finished ");
        write_to_file.println("--------------------------------------");
    }

    //-----------------------------------------------------------------
    //Called when an atomic test fails.
    @Override
    public void testFailure (Failure failure) throws Exception
    {
        write_to_file.println("\n>>>>> Tests failure  "  + failure );
    }

    //-----------------------------------------------------------------
    //Called when a test will not be run, generally because a test method is annotated with Ignore.
    @Override
    public void testIgnored(Description description) throws Exception {
        write_to_file.println(">>>>> Tests disabled: "+ description );
        write_to_file.println("--------------------------------------");
    }

    //-----------------------------------------------------------------
    //Called when all tests have finished
    @Override
    public void testRunFinished(Result result) throws Exception {

        write_to_file.println( "\nResult of the test run: "+ result.wasSuccessful());
        write_to_file.println( "Run time: " + result.getRunTime() + " ms");
        int countOfTests = result.getRunCount() + result.getIgnoreCount();
        write_to_file.println( "Number of tests in test suite: "+ countOfTests);
        write_to_file.println( "Number of tests executed: "+ result.getRunCount());
        int countOfSucceed = countOfTests - result.getIgnoreCount() -result.getFailureCount();
        write_to_file.println( "Number of tests succeed: "+ countOfSucceed);
        write_to_file.println( "Failure count: " + result.getFailureCount() );
        write_to_file.println( "Ignored count: "  + result.getIgnoreCount() );

        write_to_file.close();
/*
        System.out.println( "\nResult of the test run: "+ result.wasSuccessful() );
        System.out.println("Run time: " + result.getRunTime() + " ms");
        System.out.println("Number od tests executed: "+ result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount() );
        System.out.println("Ignored count: "  + result.getIgnoreCount() );*/
    }
}

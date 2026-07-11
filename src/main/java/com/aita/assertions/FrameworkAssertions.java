package com.aita.assertions;

import com.aita.loggers.FrameworkLogger;
import org.testng.Assert;

public class FrameworkAssertions {

    private FrameworkAssertions() {}

    public static void assertTrue(boolean condition,
                                  String message){

        FrameworkLogger.info("ASSERT : " + message);

        try{
            Assert.assertTrue(condition,message);
        }
        catch(AssertionError e){
            FrameworkLogger.error(e.getMessage());
            throw e;
        }
    }

    public static void assertFalse(boolean condition,
                                   String message){

        FrameworkLogger.info("ASSERT : " + message);

        Assert.assertFalse(condition, message);

    }

    public static void assertEquals(Object actual,
                                    Object expected,
                                    String message){

        FrameworkLogger.info("ASSERT : " + message);

        Assert.assertEquals(actual, expected, message);

    }

}
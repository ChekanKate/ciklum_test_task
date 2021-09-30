package com.chekan.ciklum;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void runTests() {
        Result result = JUnitCore.runClasses(ControllerTest.class, OrderDAOTest.class, OrderEntityTest.class,
                OrdItemsEntityTest.class, ProductDAOTest.class, ProductEntityTest.class);
        System.out.println("Total number of tests " + result.getRunCount());
        System.out.println("Total number of tests failed " + result.getFailureCount());

        for(Failure failure : result.getFailures())
        {
            System.out.println(failure.getMessage());
        }
        System.out.println(result.wasSuccessful());
    }
    }

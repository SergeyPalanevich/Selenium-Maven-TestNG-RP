package com.epam.ta.runners;

import com.epam.ta.listeners.TAListener;
import org.testng.ISuiteListener;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

public class RunnerTestNG {
    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        testNG.addListener((ISuiteListener) new TAListener());
        try {
            List<XmlSuite> suite = (List<XmlSuite>) (new Parser("src/main/resources/Suite.xml").parse());
            testNG.setXmlSuites(suite);
            testNG.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

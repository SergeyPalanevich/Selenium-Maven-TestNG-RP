package com.epam.ta.runners;

import com.epam.ta.listeners.TAListener;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

public class RunnerTestNG {
    public static final String PATH_TO_SUITE = "src/main/resources/Suite.xml";

    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        testNG.addListener(new TAListener());
        try {
            List<XmlSuite> suite = (List<XmlSuite>) (new Parser(PATH_TO_SUITE).parse());
            testNG.setXmlSuites(suite);
            testNG.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

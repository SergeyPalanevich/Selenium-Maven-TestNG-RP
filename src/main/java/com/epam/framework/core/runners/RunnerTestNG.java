package com.epam.framework.core.runners;

import com.epam.framework.core.listeners.TAListener;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

import static com.epam.framework.core.utils.FIleUtils.getResourcePath;

public class RunnerTestNG {
    public static final String PATH_TO_SUITE = getResourcePath("Suite.xml");

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

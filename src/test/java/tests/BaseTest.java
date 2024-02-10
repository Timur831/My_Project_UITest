package tests;

import helpers.Driver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }
}

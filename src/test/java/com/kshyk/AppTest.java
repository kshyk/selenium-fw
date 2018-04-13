package com.kshyk;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testLengthOfTheUniqueKey() {
        Assert.assertEquals(36, new App().generateUniqueKey().length());
    }
}
package com.kshyk.dummy;

import com.kshyk.App;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class DummyTests {

    @Test
    public void testLengthOfTheUniqueKey() {
        Assert.assertEquals(36, new App().generateUniqueKey().length());
    }

    @Test
    public void failTest() {
        fail();
    }

    @Test
    public void trueTest() {
        assertTrue(true);
    }
}
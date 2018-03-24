package com.hfut.entity;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AjaxResultTest {
    Logger logger = Logger.getLogger(AjaxResultTest.class);

    @Test
    public void toStringTest() {
        AjaxResult result = new AjaxResult();
        result.setMsg("test ajax result!");
        result.ok();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        result.setData(integers);
        logger.debug(result.toString());
        System.out.println(result.toString());
        Assert.assertEquals(integers.size(), result.getCount());
    }
}
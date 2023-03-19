package com.exelenter.steps;

import com.exelenter.base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void startBrowser(){
        BaseClass.setUp();
    }

    @After
    public void quitBrowser(){BaseClass.tearDown();}
}

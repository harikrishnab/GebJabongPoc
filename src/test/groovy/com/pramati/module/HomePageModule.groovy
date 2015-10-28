package com.pramati.module

import geb.Module
import org.openqa.selenium.By


/**
 * Created by harikrishnab on 15-10-2015.
 */
class HomePageModule extends Module{

    static content = {
        signIn { $(By.xpath(".//a[text()='Sign In']"))}
        userLoginName {$(".loged-in>div a")}
        menCatagory {$("#mainTopNav li[class*='nav-men']>a")}
        clothingLink {$("#mainTopNav>li[class*='nav-men'] a[href='/men/clothing/?source=topnav_men']")}
    }
}

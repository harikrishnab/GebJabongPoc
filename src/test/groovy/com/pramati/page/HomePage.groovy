package com.pramati.page

import com.pramati.module.HomePageModule
import geb.Page
import org.openqa.selenium.interactions.Actions

/**
 * Created by harikrishnab on 15-10-2015.
 */
class HomePage extends  Page{
    static at = { title == "Official Jabong Coupons, Online Sale Offers, Discount Deals" }

    static content = {
       homePageObjects{module(HomePageModule)}
    }

    def "clickOnSignInButton"(){
        homePageObjects.signIn.click()
    }

    def "verifyLoginSuccessfully"(){
        return homePageObjects.userLoginName.text().equalsIgnoreCase("HI, CUSTOMER")
    }

    def "mouseOverOnMenCatagoryAndClickOnClothing"(){
        waitFor {homePageObjects.menCatagory.displayed}
        def actions = new Actions(driver)
        actions.moveToElement(homePageObjects.menCatagory.firstElement()).build().perform()
        waitFor { homePageObjects.clothingLink.displayed}
        homePageObjects.clothingLink.click()
    }
}

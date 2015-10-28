package com.pramati.page

import com.pramati.module.SignInPageModule
import geb.Page

/**
 * Created by harikrishnab on 16-10-2015.
 */
class SignInPage extends Page{

    static at = { waitFor {signInPageObjects.siteUserName.displayed} }

    static content = {
        signInPageObjects {module(SignInPageModule)}
    }

    def "enterLoginDetails"(String userName, String password){
        signInPageObjects.siteUserName.value(userName)
        signInPageObjects.sitePassword.value(password)
        signInPageObjects.siteSignIn.click()
   }



}

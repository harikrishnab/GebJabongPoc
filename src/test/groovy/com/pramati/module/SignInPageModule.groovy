package com.pramati.module

import geb.Module

/**
 * Created by harikrishnab on 16-10-2015.
 */
class SignInPageModule extends Module{

    static content = {
        siteUserName{$("#login-email")}
        sitePassword{$("#login-pwd")}
        siteSignIn{$("#btn-login")}

    }
}

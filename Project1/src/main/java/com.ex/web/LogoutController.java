package com.ex.web;

import static com.ex.web.LoginController.loginSession;

public class LogoutController {

    public void destroy() {

        loginSession = false;

    }
}

package com.example.spring_boot_application.constant;

public interface ApiConstant {
    String SLASH = "/";
    String API = "/api";
    String ALL_API_REGEX = "/**";

    //~ Login / Logout:
    String LOGIN = "/login";
    String LOGOUT = "/logout";

    //~ Home API:
    String HOME_API = API + "/home";
    String TEST_API = "/test";
}

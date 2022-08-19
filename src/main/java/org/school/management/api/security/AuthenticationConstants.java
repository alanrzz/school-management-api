package org.school.management.api.security;

public class AuthenticationConstants {

    public static final String SECRET = "rzz_test_rzz";

    public static final long EXPIRATION_TIME = 864000000; // ms

    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/api/user";
}

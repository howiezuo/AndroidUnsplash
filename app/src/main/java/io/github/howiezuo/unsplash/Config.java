package io.github.howiezuo.unsplash;

public class Config {

    public static final String APP_SCHEME = "app";
    public static final String APP_HOST = "io.github.howiezuo.unsplash";

    public static final String OAUTH_URL = "https://unsplash.com";
    public static final String API_URL = "https://api.unsplash.com";
    public static final String API_VERSION = "v1";
    public static final String CLIENT_ID = "bb0b8493dba89c5b8765bdca724c00c3766b20971017f3315536ba19856e6287";
    public static final String CLIENT_SECRET = "cf360e6f78681263df3f76d50e21ac0c44814e8b5ab85465a97cb11ceb9cbf6b";
    public static final String REDIRECT_URI = APP_SCHEME + "://" + APP_HOST + "/oauth/authorize";
    public static final String LOGIN_URL = OAUTH_URL + "/oauth/authorize" +
            "?client_id=" + CLIENT_ID +
            "&redirect_uri=" + REDIRECT_URI +
            "&response_type=code" +
            "&scope=public+read_user+read_photos+read_collections+write_likes+write_followers";
}

package burp.utils;

import okhttp3.CacheControl;
import okhttp3.Request;

import java.util.Calendar;

public class HttpUtils {
    public static CacheControl NoCache = new CacheControl.Builder().noCache().noStore().build();

    public static Request.Builder GetDefaultRequest(String url) {
        int fakeFirefoxVersion = Utils.GetRandomNumber(45, 94 + Calendar.getInstance().get(Calendar.YEAR) - 2021);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        requestBuilder.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:" + fakeFirefoxVersion + ".0) Gecko/20100101 Firefox/" + fakeFirefoxVersion + ".0");
        return requestBuilder.cacheControl(NoCache);
    }
    public  static Request.Builder GetDefaultRequestNew(String domain,String token,String url) {
        CacheControl NoCache = new CacheControl.Builder().noCache().noStore().build();
        int fakeFirefoxVersion = Utils.GetRandomNumber(45, 94 + Calendar.getInstance().get(Calendar.YEAR) - 2021);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        requestBuilder.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:" + fakeFirefoxVersion + ".0) Gecko/20100101 Firefox/" + fakeFirefoxVersion + ".0");
        requestBuilder.header("Cookie", "key=" + domain + "; " + "token=" + token);
        return requestBuilder.cacheControl(NoCache);
    }
}

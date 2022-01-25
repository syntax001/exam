package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpUtils {

    public static String fetchData(int amount, String from, String to) throws MalformedURLException, IOException{

        String url = String.format("https://currency-exchange.p.rapidapi.com/exchange?from=%s&to=%s&q=%d",from, to, amount);

        HttpURLConnection httpURLConnection = HttpUtils.getURLConnection(url);

        Map<String, String> headers = new HashMap<>();

        headers.put("X-RapidAPI-Host","currency-exchange.p.rapidapi.com");
        headers.put("X-RapidAPI-Key","b076052a43msh3c498562801ef5ap160d2ajsnd1fdb00fb3cd");

        HttpUtils.setHeaders(httpURLConnection, headers);

       // con = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accpet", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(httpURLConnection.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()){
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

    public static HttpURLConnection getURLConnection(String urlToConnect) throws IOException {
        URL url = new URL(urlToConnect);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        return httpUrlConnection;
    }

    public static void setHeaders(HttpURLConnection httpUrlConnection, Map<String, String> headers) {
        for (String headerKey : headers.keySet()) {
            httpUrlConnection.setRequestProperty(headerKey, headers.get(headerKey));
        }
    }
}

package com.boya.commons;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.canedata.core.logging.LoggerFactory;
import org.canedata.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public final class HttpUtils {

    private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    private HttpUtils() {

    }

    public static String fetch(String host, String addr, String requestStr)
            throws IOException {
        String resp = null;
        if (addr == null)
            return "";
        URL url = new URL(addr);
        URLConnection connection;
        connection = url.openConnection();
        if (host != null && !host.equals("")) {
            connection.setRequestProperty("Host", host);
        }
        if (requestStr == null) {
            connection.connect();
        } else {
            connection.setDoOutput(true);
            connection.setDoInput(true);
            OutputStreamWriter wr = new OutputStreamWriter(
                    connection.getOutputStream(), "utf-8");
            if (requestStr != null || !"".equals(requestStr)) {
                wr.write(requestStr);
            }
            wr.flush();
            wr.close();
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), "utf-8"));
        resp = "";
        StringBuffer sb = new StringBuffer();
        sb.append("");
        while (true) {
            int ch;
            ch = rd.read();
            if (ch > -1) {
                sb.append((char) ch);
            } else {
                break;
            }
        }
        resp = sb.toString();
        rd.close();
        return resp;
    }

    public static URLConnection fetch(String addr) throws IOException {
        URL url = new URL(addr);
        URLConnection connection;
        connection = url.openConnection();
        return connection;
    }

    public static String sendGet(String url) {
        String returnMsg = "";

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse httpResponse = client.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                returnMsg = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } else {
                returnMsg = "";
            }
        } catch (IOException e) {
            LOG.error(Constant.EXCEPTIONHINT, "sendGet", "sendGet", e);
        }
        return returnMsg;
    }
}

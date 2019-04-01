package com.gunner.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class CommonUtil {
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 远程连接网址
     *
     * @param url
     * @return 返回远程访问的结果，json对象类型
     */
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = httpResponse.getEntity();
            String result = EntityUtils.toString(entity, Consts.UTF_8);
            jsonObject = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();

        return jsonObject;
    }

    /**
     * 远程连接网址
     *
     * @param myurl
     * @return 返回远程访问的结果，json字符串类型
     */
    public static String ConnectUrl(String myurl) throws IOException {
        URL url = null;
        StringBuffer resultBuffer = null;
        url = new URL(myurl);
        URLConnection conn = url.openConnection();
        conn.setUseCaches(false);
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.connect();
        //Map<String, List<String>> headers=conn.getHeaderFields();
        //System.out.println(headers);
        BufferedReader reader = null;
        resultBuffer = new StringBuffer();
        String tempLine = null;
        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
        }
        reader.close();
        return resultBuffer.toString();
    }
}

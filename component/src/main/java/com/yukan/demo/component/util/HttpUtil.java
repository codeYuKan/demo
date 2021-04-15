package com.yukan.demo.component.util;

import lombok.Cleanup;
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2021/4/7
 * @email yukan.cn.mail@gmail.com
 */
public class HttpUtil {

    /**
     * 后续扩展参数，重载
     */
    public static String get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);

        return request(httpGet, new HashMap<>(2));
    }

    public static String request(HttpUriRequest request, Map<String, String> headerMap) throws IOException {
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            request.setHeader(entry.getKey(), entry.getValue());
        }
        @Cleanup CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        @Cleanup CloseableHttpResponse response = closeableHttpClient.execute(request);

        // @Cleanup会导致直接return response获取不到数据
        return EntityUtils.toString(response.getEntity(), Consts.UTF_8);
    }
}

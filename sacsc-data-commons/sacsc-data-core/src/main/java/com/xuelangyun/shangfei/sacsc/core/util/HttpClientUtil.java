package com.xuelangyun.shangfei.sacsc.core.util;

import com.google.common.base.Throwables;
import com.xuelangyun.shangfei.sacsc.core.exception.BusinessException;
import com.xuelangyun.shangfei.sacsc.core.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtil {

  /**
   * get请求
   *
   * @param url 请求地址
   * @param param 参数
   * @return
   */
  public static String doGet(HttpClient httpClient, String url, Map<String, Object> param) {
    String resultString = "";
    HttpResponse response = null;
    try {
      // 创建uri
      URIBuilder builder = new URIBuilder(url);
      if (param != null) {
        for (String key : param.keySet()) {
          builder.addParameter(key, param.get(key).toString());
        }
      }
      URI uri = builder.build();

      // 创建http GET请求
      HttpGet httpGet = new HttpGet(uri);

      // 执行请求
      response = httpClient.execute(httpGet);
      // 判断返回状态是否为200
      if (response.getStatusLine().getStatusCode() == 200) {
        resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
      } else {
        log.error("请求失败:" + response.getStatusLine().getStatusCode());
        throw new BusinessException(
            StatusCode.ERROR, "请求失败," + response.getStatusLine().getStatusCode());
      }
      log.info(
          "请求状态:" + response.getStatusLine().getStatusCode() + ",返回数据:" + response.getEntity());
    } catch (Exception e) {
      log.error("请求失败", e);
      throw new BusinessException(StatusCode.ERROR, "请求失败," + e.getMessage());
    }
    return resultString;
  }

  /**
   * post请求
   *
   * @param url
   * @param param
   * @return
   */
  public static String doPost(HttpClient httpClient, String url, Map<String, String> param) {
    // 创建Httpclient对象
    HttpResponse response = null;
    String resultString = "";

    try {
      // 创建Http Post请求
      HttpPost httpPost = new HttpPost(url);
      // 创建参数列表
      if (param != null) {
        List<NameValuePair> paramList = new ArrayList<>();
        for (String key : param.keySet()) {
          paramList.add(new BasicNameValuePair(key, param.get(key)));
        }
        // 模拟表单
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
        httpPost.setEntity(entity);
      }
      // 执行http请求
      response = httpClient.execute(httpPost);
      resultString = EntityUtils.toString(response.getEntity(), "utf-8");
    } catch (Exception e) {
      log.error("请求失败", e);
      throw new BusinessException(StatusCode.ERROR, "请求失败," + e.getMessage());
    }
    return resultString;
  }

  /**
   * 请求的参数类型为json
   *
   * @param url
   * @param json
   * @return {username:"",pass:""}
   */
  public static MutablePair<Integer, String> doPostJson(String url, String json, Integer timeout) {
    // 创建Httpclient对象
    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse response = null;
    String resultString = "";
    Integer statusCode = -1;
    try {
      // 创建Http Post请求
      HttpPost httpPost = new HttpPost(url);
      if (null != timeout) {
        // 设置超时时间
        RequestConfig requestConfig =
            RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        httpPost.setConfig(requestConfig);
      }
      // 创建请求内容
      StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
      httpPost.setEntity(entity);
      httpPost.setHeader("Accept", "application/json");
      httpPost.setHeader("Content-type", "application/json");
      // 执行http请求
      response = httpClient.execute(httpPost);

      if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        statusCode = response.getStatusLine().getStatusCode();
        resultString = EntityUtils.toString(response.getEntity(), "utf-8");
      }
    } catch (Exception e) {
      log.error("doPostJson error: {}", Throwables.getStackTraceAsString(e));
    } finally {
      close(response, httpClient);
    }
    return MutablePair.of(statusCode, resultString);
  }

  public static MutablePair<Integer, String> doPostJson(String url, String json) {
    return doPostJson(url, json, null);
  }

  /**
   * 关闭资源
   *
   * @param closeables
   */
  private static void close(Closeable... closeables) {
    for (Closeable closeable : closeables) {
      if (null != closeable) {
        try {
          closeable.close();
        } catch (IOException e) {
        }
      }
    }
  }
}

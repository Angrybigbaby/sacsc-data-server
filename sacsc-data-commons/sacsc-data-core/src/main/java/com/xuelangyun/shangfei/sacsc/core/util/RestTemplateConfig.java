package com.xuelangyun.shangfei.sacsc.core.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

@Configuration
public class RestTemplateConfig {

  public static final int CONNECTION_REQUEST_TIMEOUT = 3 * 1000;

  public static final int CONNECTION_TIMEOUT = 30 * 1000;

  public static final int READ_TIMEOUT = 3 * 60 * 1000;

  public static final int MAX_TOTAL_CONNECTIONS = 300;

  public static final int MAX_PERROUTE_CONNECTIONS = 100;

  @Bean
  public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
    RestTemplate restTemplate = new RestTemplateBuilder().build();
    restTemplate.setRequestFactory(clientHttpRequestFactory);

    // (clientHttpRequestFactory);

    // StringHttpMessogeConverter 默认使用 IS0-8859-编码，此处修改为 UTF-8
    List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
    while (iterator.hasNext()) {
      HttpMessageConverter converter = iterator.next();
      if (converter instanceof StringHttpMessageConverter) {
        ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
      }
    }
    return restTemplate;
  }

  @Bean
  public ClientHttpRequestFactory httpRequestFactory(HttpClient httpClient) {
    HttpComponentsClientHttpRequestFactory factory =
        new HttpComponentsClientHttpRequestFactory(httpClient);
    return factory;
  }

  @Bean
  public HttpClient httpClient() {
    Registry<ConnectionSocketFactory> registry =
        RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.getSocketFactory())
            .register("https", SSLConnectionSocketFactory.getSocketFactory())
            .build();
    PoolingHttpClientConnectionManager connectionManager =
        new PoolingHttpClientConnectionManager(registry);
    // 设置整个连接池最大连接数 根据自己的场景决定
    connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
    // 路由是对maxTotal的细分
    connectionManager.setDefaultMaxPerRoute(MAX_PERROUTE_CONNECTIONS);

    RequestConfig requestConfig =
        RequestConfig.custom()
            // 服务器返回数据(response)的时间，超过该时间抛出read timeout
            .setSocketTimeout(READ_TIMEOUT)
            // 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
            .setConnectTimeout(CONNECTION_TIMEOUT)
            // 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
            // 会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for
            // connection from pool
            .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
            .setContentCompressionEnabled(true)
            .build();

    return HttpClientBuilder.create()
        .setDefaultRequestConfig(requestConfig)
        .setConnectionManager(connectionManager)
        .build();
  }
}

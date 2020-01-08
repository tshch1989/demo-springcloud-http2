package com.example.demo.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory httpsFactory){
        RestTemplate restTemplate = new RestTemplate(httpsFactory);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) {

            }
        });
        return restTemplate;
    }

    @Bean(name = "httpsFactory")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() throws Exception{
        CloseableHttpClient httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
        HttpComponentsClientHttpRequestFactory httpsFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        httpsFactory.setReadTimeout(2000);
        httpsFactory.setConnectTimeout(2000);
        return httpsFactory;
    }

}

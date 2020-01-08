package com.example.demo.config;

import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class FeignConfig {

    @Bean
    @Primary
    public HttpClient httpClient2()
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return HttpClientUtils.acceptsUntrustedCertsHttpClient();
    }
}

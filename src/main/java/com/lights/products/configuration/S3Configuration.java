package com.lights.products.configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.lights.products.util.ApplicationHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class S3Configuration {

    @Autowired
    private ApplicationHelper applicationHelper;

    @Bean
    public AmazonS3 amazonS3Client() {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion("us-east-1")
                    .withCredentials(new DefaultAWSCredentialsProviderChain())
                    .build();
            return s3Client;
        } catch (Exception ex) {
            log.error("Error while creating S3 Client::: {}", ex.getMessage());
            applicationHelper.shutDownGracefully();
            throw ex;
        }
    }
}

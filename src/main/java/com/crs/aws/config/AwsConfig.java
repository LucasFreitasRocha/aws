package com.crs.aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.util.Objects;

@Configuration
public class AwsConfig {

    @Bean
    public S3Client s3Client(){
        return (Objects.isNull(System.getenv("AWS_WEB_IDENTITY_TOKEN_FILE"))) ?
                S3Client.builder()
                        .region(Region.US_EAST_1)
                        .credentialsProvider(ProfileCredentialsProvider.create())
                        .build() : S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
                .build()
               ;
    }

}

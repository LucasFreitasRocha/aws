package com.crs.aws.gateway.aws;

import com.amazonaws.services.mq.model.NotFoundException;
import com.crs.aws.core.domain.FileDomain;
import com.crs.aws.gateway.DocumentGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class DocumentAwsGateway implements DocumentGateway {
    @Value("${aws.bucket-name}")
    private String BUCKET_NAME;
    @Autowired
    S3Client s3Client;

    @Override
    public List<String> search(String prefix) {
        List<String> resultKeys = new ArrayList<>();
        ListObjectsV2Response response;
        ListObjectsV2Request request = ListObjectsV2Request.builder()
                .prefix(prefix)
                .bucket(BUCKET_NAME)
                .build();
        do {
            response = s3Client.listObjectsV2(request);
            response.contents().forEach(s3Object -> {
                if (!s3Object.key().endsWith("/")) {
                    resultKeys.add(s3Object.key());
                }
            });
            var token = response.continuationToken();
            request = ListObjectsV2Request.builder().prefix(prefix).bucket(BUCKET_NAME).continuationToken(token).build();
        } while (response.isTruncated());
        return resultKeys;
    }

    @Override
    public FileDomain getFile64(String key) {
        try {
            ResponseInputStream<GetObjectResponse> response = s3Client.getObject(buildRequest(key));
            return FileDomain.builder()
                    .name(key)
                    .base64(Base64.getEncoder().encodeToString(response.readAllBytes()))
                    .type(response.response().contentType())
                    .build();
        } catch (NoSuchKeyException e) {
            log.error("not found this key");
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void uploadFile(String fileName, String contentType, byte[] bytes) {
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(BUCKET_NAME)
                        .key(fileName)
                        .contentType(contentType)
                        .build(),
                RequestBody.fromBytes(bytes)
        );
    }

    @Override
    public FileDomain download(String key) {

        try {
            ResponseInputStream<GetObjectResponse> response = s3Client.getObject(buildRequest(key));
            FileDomain domain =
                    FileDomain.builder()
                            .type("application/octet-stream")
                            .build();
            if (Objects.isNull(response.response())) {
                throw new NotFoundException("Not found");
            }
            if (Objects.nonNull(response.response().contentType())) {
                domain.setType(response.response().contentType());
            }
            domain.setResource(new InputStreamResource(response));
            return domain;
        } catch (NoSuchKeyException e) {
            log.error("not found this key");
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    private GetObjectRequest buildRequest(String key) {
        return GetObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(key)
                .build();
    }
}

package com.crs.aws.gateway;

import com.crs.aws.core.domain.FileDomain;
import com.crs.aws.entrypoint.dto.out.File64Dto;

import java.util.List;

public interface DocumentGateway {

    public List<String> search(String prefix);

    public FileDomain getFile64(String key);

    void uploadFile(String originalFilename, String contentType, byte[] bytes);

    FileDomain download(String key);
}

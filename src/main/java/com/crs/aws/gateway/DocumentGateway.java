package com.crs.aws.gateway;

import com.crs.aws.entrypoint.dto.out.File64Dto;

import java.util.List;

public interface DocumentGateway {

    public List<String> search(String prefix);


    public File64Dto getFile64(String key);
}

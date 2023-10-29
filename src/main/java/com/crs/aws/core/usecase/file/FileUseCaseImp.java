package com.crs.aws.core.usecase.file;

import com.crs.aws.entrypoint.dto.out.File64Dto;
import com.crs.aws.gateway.DocumentGateway;
import com.crs.aws.gateway.aws.DocumentAwsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUseCaseImp implements FileUseCaseInterface {
    private final DocumentGateway documentGateway;
    @Override
    public File64Dto getFile64(String key) {
        return documentGateway.getFile64(key);
    }
}

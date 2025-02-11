package com.crs.aws.core.usecase.file;

import com.crs.aws.entrypoint.dto.out.File64Dto;
import com.crs.aws.gateway.DocumentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUseCaseImp implements FileUseCaseGateway {
    private final DocumentGateway documentGateway;
    @Override
    public File64Dto getFile64(String key) {
        return documentGateway.getFile64(key);
    }

    @Override
    public void uploadBy(MultipartFile file) throws IOException {

        documentGateway.uploadFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}

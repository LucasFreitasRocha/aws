package com.crs.aws.entrypoint.api.file.base64;

import com.crs.aws.core.usecase.file.FileUseCaseGateway;
import com.crs.aws.entrypoint.dto.out.File64Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileBase64Controller implements FileBase64Api {
    private final FileUseCaseGateway fileUseCaseGateway;
    @Override
    public ResponseEntity<File64Dto> getFile64(String key) {
        return ResponseEntity.ok(fileUseCaseGateway.getFile64(key));
    }


}

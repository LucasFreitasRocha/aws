package com.crs.aws.entrypoint.api.file;

import com.crs.aws.core.usecase.file.FileUseCaseInterface;
import com.crs.aws.entrypoint.dto.in.KeyDto;
import com.crs.aws.entrypoint.dto.out.File64Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileController implements FileApi{
    private final FileUseCaseInterface fileUseCaseInterface;
    @Override
    public ResponseEntity<File64Dto> getFile64(KeyDto keyDto) {
        return ResponseEntity.ok(fileUseCaseInterface.getFile64(keyDto.key()));
    }
}

package com.crs.aws.entrypoint.api.file;

import com.crs.aws.core.usecase.file.FileUseCaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class FileController implements FileApi{
    private final FileUseCaseGateway fileUseCaseGateway;
    @Override
    public ResponseEntity<?> uploadMultipartFile(MultipartFile file) throws IOException {
        fileUseCaseGateway.uploadBy(file);
        return ResponseEntity.created(URI.create(file.getOriginalFilename())).build();
    }
}

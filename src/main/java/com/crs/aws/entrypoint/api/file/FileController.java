package com.crs.aws.entrypoint.api.file;

import com.crs.aws.core.domain.FileDomain;
import com.crs.aws.core.usecase.file.FileUseCaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    @Override
    public ResponseEntity<InputStreamResource> donwloadFile(String key) {
        FileDomain domain = fileUseCaseGateway.download(key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .contentType(MediaType.parseMediaType(domain.getType()))
                .body(domain.getResource());
    }
}

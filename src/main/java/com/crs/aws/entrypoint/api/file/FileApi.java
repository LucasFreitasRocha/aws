package com.crs.aws.entrypoint.api.file;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/v1/file")
@Tag(name= "File MultipartFile")
public interface FileApi {

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    ResponseEntity<?> uploadMultipartFile(@RequestPart("file") MultipartFile file) throws IOException;


    @GetMapping
    ResponseEntity<InputStreamResource> donwloadFile(@RequestParam("key") String key);
}

package com.crs.aws.entrypoint.api.file;

import com.crs.aws.entrypoint.dto.in.KeyDto;
import com.crs.aws.entrypoint.dto.out.File64Dto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/file")
@Tag(name= "file")
public interface FileApi {

    @PostMapping("/base64")
    ResponseEntity<File64Dto> getFile64(@RequestBody KeyDto keyDto);
}

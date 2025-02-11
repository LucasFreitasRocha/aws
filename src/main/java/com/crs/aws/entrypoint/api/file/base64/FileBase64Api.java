package com.crs.aws.entrypoint.api.file.base64;

import com.crs.aws.entrypoint.dto.out.File64Dto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/file/base64")
@Tag(name= "File base 64")
public interface FileBase64Api {

    @GetMapping
    ResponseEntity<File64Dto> getFile64(@RequestParam String  prefix);

}

package com.crs.aws.entrypoint.api.consult;

import com.crs.aws.entrypoint.dto.in.KeyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/v1/consult")
@Tag(name= "consult")
public interface ConsultApi {

    @PostMapping
    @Operation(summary = "Consult with prefix key", description =
            "consult with prefix key, if send a empty key return all keys")
    public ResponseEntity<List<String>> consult(@RequestBody KeyDto keyDto);

}

package com.crs.aws.core.usecase.file;

import com.crs.aws.entrypoint.dto.in.KeyDto;
import com.crs.aws.entrypoint.dto.out.File64Dto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface FileUseCaseInterface {
   File64Dto getFile64(String key);
}

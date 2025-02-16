package com.crs.aws.core.usecase.file;

import com.crs.aws.core.domain.FileDomain;
import com.crs.aws.entrypoint.dto.out.File64Dto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUseCaseGateway {
   FileDomain getFile64(String key);

   void uploadBy(MultipartFile file) throws IOException;

   FileDomain download(String key);

}

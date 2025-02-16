package com.crs.aws.entrypoint.dto.out;

import com.crs.aws.core.domain.FileDomain;
import lombok.Builder;

@Builder
public record File64Dto(
        String type,
        String file,
        String name
) {

    public static File64Dto of(FileDomain domain){
        return File64Dto.builder()
                .type(domain.getType())
                .file(domain.getBase64())
                .name(domain.getName())
                .build();
    }
}

package com.crs.aws.entrypoint.dto.out;

import lombok.Builder;

@Builder
public record File64Dto(
        String type,
        String file,
        String name
) {
}

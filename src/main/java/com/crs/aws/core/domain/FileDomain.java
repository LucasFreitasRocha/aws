package com.crs.aws.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.InputStreamResource;

@Builder
@Getter
@Setter
public class FileDomain {
    private String name;
    private String type;
    private String base64;
    private InputStreamResource resource;
}

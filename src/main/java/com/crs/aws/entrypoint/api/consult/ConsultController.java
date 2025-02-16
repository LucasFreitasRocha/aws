package com.crs.aws.entrypoint.api.consult;

import com.crs.aws.core.usecase.consult.ConsultUseCaseInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConsultController implements ConsultApi {
    private final ConsultUseCaseInterface useCase;

    @Override
    public ResponseEntity<List<String>> consult(String prefix) {
        return ResponseEntity.ok(useCase.consult(prefix));
    }
}

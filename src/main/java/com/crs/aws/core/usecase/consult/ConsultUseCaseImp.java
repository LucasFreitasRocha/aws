package com.crs.aws.core.usecase.consult;

import com.crs.aws.gateway.DocumentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultUseCaseImp implements ConsultUseCaseInterface {
    private final DocumentGateway documentGateway;
    @Override
    public List<String> consult(String prefix) {
        return documentGateway.search(prefix);
    }
}

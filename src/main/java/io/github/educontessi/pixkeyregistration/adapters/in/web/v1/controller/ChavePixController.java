package io.github.educontessi.pixkeyregistration.adapters.in.web.v1.controller;

import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.datamanager.ChavePixDataManager;
import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dto.ChavePixDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChavePixController extends BaseController<ChavePixDto> {

    private final ChavePixDataManager dataManager;

    public ChavePixController(ChavePixDataManager dataManager) {
        this.dataManager = dataManager;
    }

    @PostMapping
    public ResponseEntity<ChavePixDto> save(@RequestBody ChavePixDto dto) {
        ChavePixDto saved = dataManager.save(dto);
        return created(saved.getId(), saved);
    }


}

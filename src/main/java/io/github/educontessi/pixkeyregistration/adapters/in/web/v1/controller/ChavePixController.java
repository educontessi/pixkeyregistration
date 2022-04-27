package io.github.educontessi.pixkeyregistration.adapters.in.web.v1.controller;

import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.datamanager.ChavePixDataManager;
import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.core.enums.TipoPessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/{tipoPessoa}/chaves")
public class ChavePixController extends BaseController<ChavePixDto> {

    private final ChavePixDataManager dataManager;

    public ChavePixController(ChavePixDataManager dataManager) {
        this.dataManager = dataManager;
    }

    @PostMapping
    public ResponseEntity<ChavePixDto> save(@PathVariable String tipoPessoa, @RequestBody ChavePixDto dto) {
        ChavePixDto saved = dataManager.save(dto, tipoPessoa);
        return created(saved.getId(), saved);
    }


}

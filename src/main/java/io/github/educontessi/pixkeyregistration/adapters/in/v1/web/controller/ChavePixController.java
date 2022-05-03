package io.github.educontessi.pixkeyregistration.adapters.in.v1.web.controller;

import io.github.educontessi.pixkeyregistration.adapters.in.v1.datamanager.ChavePixDataManager;
import io.github.educontessi.pixkeyregistration.adapters.in.v1.dto.ChavePixDto;
import io.github.educontessi.pixkeyregistration.core.filter.ChavePixFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/{tipoPessoa}/chaves",
        produces = {"application/json"},
        consumes = {"application/json"})
public class ChavePixController {

    private final ChavePixDataManager dataManager;

    public ChavePixController(ChavePixDataManager dataManager) {
        this.dataManager = dataManager;
    }

    @PostMapping
    public ResponseEntity<ChavePixDto> save(@PathVariable String tipoPessoa,
                                            @RequestBody ChavePixDto dto) {
        return ResponseEntity.ok(dataManager.save(dto, tipoPessoa));
    }

    @PatchMapping("/alterar-chave/{valorChave}")
    public ResponseEntity<ChavePixDto> path(@PathVariable String tipoPessoa,
                                            @PathVariable String valorChave,
                                            @RequestBody ChavePixDto dto) {
        return ResponseEntity.ok(dataManager.path(valorChave, dto, tipoPessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChavePixDto> path(@PathVariable String tipoPessoa,
                                            @PathVariable UUID id) {
        return ResponseEntity.ok(dataManager.delete(id, tipoPessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChavePixDto> findById(@PathVariable String tipoPessoa,
                                                @PathVariable UUID id) {
        return ResponseEntity.ok(dataManager.findById(id, tipoPessoa));
    }

    @GetMapping
    public ResponseEntity<List<ChavePixDto>> search(@PathVariable String tipoPessoa,
                                                    ChavePixFilter chavePixFilter) {
        return ResponseEntity.ok(dataManager.search(chavePixFilter, tipoPessoa));
    }
}

package io.github.educontessi.pixkeyregistration.adapters.in.web.v1.controller;

import io.github.educontessi.pixkeyregistration.adapters.in.web.v1.dto.BaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public abstract class BaseController<D extends BaseDto> {

    protected ResponseEntity<D> created(UUID id, D dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

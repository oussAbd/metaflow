package com.flowkit.metaflow.controller;

import com.flowkit.metaflow.service.CamelComponentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/components")
public class CamelComponentController {

    private final CamelComponentService service;

    public CamelComponentController(CamelComponentService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllComponents() {
        return service.getAllComponentNames();
    }

    @GetMapping("/input")
    public List<String> getAllInputComponents() {
        return service.getAllComponentNames();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getComponentMetadata(@PathVariable String name) {
        String metadata = service.getComponentMetadata(name);
        if (metadata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Component not found");
        }
        return ResponseEntity.ok().body(metadata);
    }
}


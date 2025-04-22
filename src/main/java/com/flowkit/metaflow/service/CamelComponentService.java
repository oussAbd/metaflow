package com.flowkit.metaflow.service;

import org.apache.camel.catalog.CamelCatalog;
import org.apache.camel.catalog.DefaultCamelCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamelComponentService {

    private final CamelCatalog catalog;

    public CamelComponentService() {
        this.catalog = new DefaultCamelCatalog();
    }

    public List<String> getAllComponentNames() {
        return catalog.findComponentNames();
    }

    public String getComponentMetadata(String componentName) {
        return catalog.componentJSonSchema(componentName);
    }
}


package com.flowkit.metaflow.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.apache.camel.catalog.CamelCatalog;
import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CamelComponentServiceTest {

	@InjectMocks
	CamelComponentService service;

	@Mock
	CamelCatalog catalog;

	@DisplayName( "getAllComponentNames should return all component present in camel" )
	@Test
	void should_return_all_catalog(){

		List<String> allComponentNames = service.getAllComponentNames();
		Assertions.assertThat(allComponentNames).isNotNull();

	}
}
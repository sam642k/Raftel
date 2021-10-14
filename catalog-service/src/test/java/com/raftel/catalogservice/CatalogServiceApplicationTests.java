package com.raftel.catalogservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.raftel.catalogservice.controller.CatalogController;
import com.raftel.catalogservice.model.Product;
import com.raftel.catalogservice.repository.ProductRepository;

@SpringBootTest
class CatalogServiceApplicationTests {
	
	@MockBean
	private ProductRepository prodRepo;

	@Autowired
	private CatalogController contr;
	
	@Test
	void getAllProductsTest() {
		when(prodRepo.findAll()).thenReturn(Stream
				.of(new Product(2, "Note 8", "Electronics", 65465, "data.jpg", "Samsung galaxy note 8"),
					new Product(64, "Levi", "Clothing", 3599, "levi.jpg", "Printed Tshirt")).collect(Collectors.toList()));
		assertEquals(2, contr.getAllProducts().size());
	}

}

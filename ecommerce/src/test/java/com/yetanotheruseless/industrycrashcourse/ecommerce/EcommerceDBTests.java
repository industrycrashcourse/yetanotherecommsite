package com.yetanotheruseless.industrycrashcourse.ecommerce;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DataJpaTest(bootstrapMode = BootstrapMode.DEFAULT)
class EcommerceDBTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

}

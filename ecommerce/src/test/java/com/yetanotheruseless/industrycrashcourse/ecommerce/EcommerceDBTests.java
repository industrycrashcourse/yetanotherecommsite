package com.yetanotheruseless.industrycrashcourse.ecommerce;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductRepository;
import com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart.ShoppingCart;
import com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.time.Instant;
import java.util.List;

@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DataJpaTest(bootstrapMode = BootstrapMode.DEFAULT)
class EcommerceDBTests {

	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindAllByLastUpdatedAtTimestampBetween() {
		ShoppingCart cart1 = new ShoppingCart();
		cart1.setLastUpdatedAtTimestamp(Instant.now());
		ShoppingCart cart2 = new ShoppingCart();
		cart2.setLastUpdatedAtTimestamp(Instant.now().plusSeconds(60));
		shoppingCartRepository.save(cart1);
		shoppingCartRepository.save(cart2);

		List<ShoppingCart> results =
				shoppingCartRepository.findAllWithLastUpdatedAtTimestampBefore(Instant.now().plusSeconds(5));

		assert results.size() == 1;
	}

}

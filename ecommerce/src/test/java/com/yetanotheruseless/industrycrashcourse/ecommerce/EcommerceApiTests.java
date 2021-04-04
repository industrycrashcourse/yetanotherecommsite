package com.yetanotheruseless.industrycrashcourse.ecommerce;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductController;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductService;
import com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart.ShoppingCart;
import com.yetanotheruseless.industrycrashcourse.ecommerce.shoppingCart.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes=EcommerceApplication.class)
@WebMvcTest
public class EcommerceApiTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    public void listAllTest() throws Exception {
        Product dummyFuji = new Product();
        dummyFuji.setName("Fuji");
        when(productService.findAll()).thenReturn(Arrays.asList(dummyFuji));

        mockMvc
                .perform(get("/api/v1/product/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fuji")));
    }

    @Test
    public void incorrectPathTest() throws Exception {
        mockMvc
                .perform(get("/api/v1/product/foo/bar/baz"))
                .andDo(print())
                .andExpect(status().isNotFound());
               // .andExpect(content().string(containsString("dude")));
    }

    @Test
    public void testShoppingCartAPIFunctions() throws Exception {
        ShoppingCart cart = new ShoppingCart();
        cart.setId(3000L);
        cart.setLastUpdatedAtTimestamp(LocalDateTime.now());
        cart.setNumOfItemsInCart(309);
        when(shoppingCartService.findAll()).thenReturn(Collections.singletonList(cart));

        mockMvc
                .perform(get("/api/v1/shoppingCart/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("309")));

        reset(shoppingCartService);

        when(shoppingCartService.findById(3000L)).thenReturn(Optional.of(cart));

        mockMvc
                .perform(get("/api/v1/shoppingCart/3000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("309")));
    }

}

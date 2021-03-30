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
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes=EcommerceApplication.class)
@WebMvcTest(ProductController.class)
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
        dummyFuji.setSku("1234");
        when(productService.findAll()).thenReturn(Collections.singletonList(dummyFuji));

        mockMvc
                .perform(get("/api/v1/product/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fuji")));

        reset(productService);

        when(productService.findBySku("1234")).thenReturn(Optional.of(dummyFuji));

        mockMvc
                .perform(get("/api/v1/product/1234"))
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
        LocalDateTime currentDateTime = LocalDateTime.now();
        cart.setLastUpdatedAtTimestamp(currentDateTime);
        cart.setNumOfItemsInCart(5);
        when(shoppingCartService.findAll()).thenReturn(Collections.singletonList(cart));

        mockMvc
                .perform(get("/api/v1/shoppingCart/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(currentDateTime.toString())));

        reset(shoppingCartService);

        when(shoppingCartService.findById(3000L)).thenReturn(Optional.of(cart));

        mockMvc
                .perform(get("/api/v1/shoppingCart/3000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(currentDateTime.toString())));
    }

}

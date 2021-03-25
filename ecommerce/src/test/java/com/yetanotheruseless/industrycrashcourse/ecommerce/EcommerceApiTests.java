package com.yetanotheruseless.industrycrashcourse.ecommerce;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductController;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
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

    @Test
    public void listAllTest() throws Exception {
        Product dummyFuji = new Product();
        dummyFuji.setName("Fuji");
        when(productService.findAll()).thenReturn(Collections.singletonList(dummyFuji));

        mockMvc
                .perform(get("/api/v1/product/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fuji")));

/*
        mockMvc
                .perform(post("/api/v1/product").content("json form of fuji's product"))
                .andExpect(productService.addProduct(dummyFuji));

 */
    }

    @Test
    public void incorrectPathTest() throws Exception {
        mockMvc
                .perform(get("/api/v1/product/foo/bar/baz"))
                .andDo(print())
                .andExpect(status().isNotFound());
               // .andExpect(content().string(containsString("dude")));
    }
}

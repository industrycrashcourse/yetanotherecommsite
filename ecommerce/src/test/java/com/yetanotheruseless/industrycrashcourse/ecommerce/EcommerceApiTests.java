package com.yetanotheruseless.industrycrashcourse.ecommerce;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductController;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductService;
import com.yetanotheruseless.industrycrashcourse.ecommerce.message.Message;
import com.yetanotheruseless.industrycrashcourse.ecommerce.message.MessageController;
import com.yetanotheruseless.industrycrashcourse.ecommerce.message.MessageService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.reset;
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

    @MockBean
    private MessageService messageService;

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
    public void listAllMessagesTest() throws Exception {
        Message dummyMsg = new Message();
        dummyMsg.setRecipientFirstName("Fuji");
        dummyMsg.setRecipientEmailAddress("fuji@foo.com");
         when(messageService.findAll()).thenReturn(Collections.singletonList(dummyMsg));

        mockMvc
                .perform(get("/api/v1/message/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fuji")));

        reset(messageService);

        when(messageService.findByEmailAddress("fuji@foo.com")).thenReturn(Optional.of(dummyMsg));

        mockMvc
                .perform(get("/api/v1/message/byEmail/fuji@foo.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("fuji@foo.com")));
    }




}

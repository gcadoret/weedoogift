package com.weedoogift.web.controller;

import com.weedoogift.domain.service.user.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
@ContextConfiguration(classes = UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    void computeBalance_Test() throws Exception {

        // Given
        when(userService.computeBalance(1L)).thenReturn(500);

        // When
        MockHttpServletRequestBuilder request = get("/weedoogift/user/{idUser}/balance", 1L);

        // Test
        mvc.perform(request).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.balance", Matchers.is(500)));

    }
}
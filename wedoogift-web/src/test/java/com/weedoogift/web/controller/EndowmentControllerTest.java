package com.weedoogift.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weedoogift.domain.model.User;
import com.weedoogift.domain.service.endowment.EndowmentService;
import com.weedoogift.web.dto.EndowmentDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EndowmentController.class)
@ContextConfiguration(classes = EndowmentController.class)
class EndowmentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EndowmentService endowmentService;

    @Test
    void distributeGift_Test() throws Exception {

        // Given
        when(endowmentService.distributeGift(1L, 1L, 100)).thenReturn(User.builder().id(1L).build());
        ObjectMapper objectMapper = new ObjectMapper();
        EndowmentDto endowmentDto = new EndowmentDto();
        endowmentDto.setAmount(100);
        var payload = objectMapper.writer().forType(EndowmentDto.class).writeValueAsString(endowmentDto);

        // When
        MockHttpServletRequestBuilder request = post("/weedoogift/company/{idCompany}/user/{idUser}/gift", 1L, 1L).contentType(MediaType.APPLICATION_JSON).content(payload);

        // Test
        mvc.perform(request).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    void distributeMeal_Test() throws Exception {

        // Given
        when(endowmentService.distributeMeal(1L, 1L, 100)).thenReturn(User.builder().id(1L).build());
        ObjectMapper objectMapper = new ObjectMapper();
        EndowmentDto endowmentDto = new EndowmentDto();
        endowmentDto.setAmount(100);
        var payload = objectMapper.writer().forType(EndowmentDto.class).writeValueAsString(endowmentDto);

        // When
        MockHttpServletRequestBuilder request = post("/weedoogift/company/{idCompany}/user/{idUser}/meal", 1L, 1L).contentType(MediaType.APPLICATION_JSON).content(payload);

        // Test
        mvc.perform(request).andDo(print()).andExpect(status().isNoContent());
    }
}
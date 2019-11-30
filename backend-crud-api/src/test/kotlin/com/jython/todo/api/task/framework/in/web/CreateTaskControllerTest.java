package com.jython.todo.api.task.framework.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.jdbc.EmbeddedDatabaseConnection.H2;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = H2)
class CreateTaskControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void create() throws Exception {
    mockMvc.perform(
        post("/task")
            .contentType(APPLICATION_JSON_VALUE)
            .content("{\"description\" : \"val\"}"))
        .andExpect(status().isCreated())
        .andExpect(redirectedUrlPattern("/task/*"))
        .andExpect(jsonPath("$.description", equalTo("val")));
  }
}
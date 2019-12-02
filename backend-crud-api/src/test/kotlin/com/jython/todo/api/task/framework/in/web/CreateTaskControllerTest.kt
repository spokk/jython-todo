package com.jython.todo.api.task.framework.`in`.web

import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
internal class CreateTaskControllerTest() {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun create() {
        mockMvc!!.perform(
                MockMvcRequestBuilders.post("/task")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{\"description\" : \"val\"}"))
                .andExpect(status().isCreated)
                .andExpect(redirectedUrlPattern("/task/*"))
                .andExpect(jsonPath("$.description", equalTo("val")))
    }
}
package com.jython.todo.api.task.framework.`in`.web

import com.jython.todo.api.task.application.port.`in`.CreateTaskUseCase
import com.jython.todo.api.task.application.port.`in`.command.CreateTaskCommand
import com.jython.todo.api.task.framework.`in`.web.dto.ExistingTaskDto
import com.jython.todo.api.task.framework.`in`.web.dto.NewTaskDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URI
import javax.validation.Valid

@Controller
@RequestMapping("/task")
internal class CreateTaskController(private val createTaskUseCase: CreateTaskUseCase) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody inDto: @Valid NewTaskDto): ResponseEntity<ExistingTaskDto> {
        val created = createTaskUseCase.create(CreateTaskCommand(inDto.description))
        val outDto = ExistingTaskDto.fromDomain(created)
        return ResponseEntity
                .created(URI.create("/task/" + outDto.id))
                .body<ExistingTaskDto>(outDto)
    }
}
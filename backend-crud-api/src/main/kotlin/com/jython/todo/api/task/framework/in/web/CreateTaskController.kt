package com.jython.todo.api.task.framework.in.web;

import com.jython.todo.api.task.application.port.in.CreateTaskUseCase;
import com.jython.todo.api.task.application.port.in.command.CreateTaskCommand;
import com.jython.todo.api.task.domain.Task;
import com.jython.todo.api.task.framework.in.web.dto.ExistingTaskDto;
import com.jython.todo.api.task.framework.in.web.dto.NewTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
class CreateTaskController {

  private final CreateTaskUseCase createTaskUseCase;

  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  ResponseEntity<ExistingTaskDto> create(@Valid @RequestBody NewTaskDto inDto) {
    Task created = createTaskUseCase.create(new CreateTaskCommand(inDto.getDescription()));
    ExistingTaskDto outDto = ExistingTaskDto.fromDomain(created);

    return ResponseEntity
        .created(URI.create("/task/" + outDto.getId()))
        .body(outDto);
  }
}

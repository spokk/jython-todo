package com.jython.todo.api.task.application.service;

import com.jython.todo.api.task.application.port.in.CreateTaskUseCase;
import com.jython.todo.api.task.application.port.in.command.CreateTaskCommand;
import com.jython.todo.api.task.application.port.out.SaveTaskPort;
import com.jython.todo.api.task.domain.Task;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskService implements CreateTaskUseCase {

  private final SaveTaskPort saveTaskPort;

  @Override
  public Task create(CreateTaskCommand command) {
    return saveTaskPort.create(
        Task.withNoId(command.getTaskDescription()));
  }
}

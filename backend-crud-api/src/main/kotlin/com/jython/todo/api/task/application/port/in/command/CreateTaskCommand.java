package com.jython.todo.api.task.application.port.in.command;

import lombok.Value;

@Value
public class CreateTaskCommand {

  private final String taskDescription;
}

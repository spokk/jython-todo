package com.jython.todo.api.task.framework.in.web.dto;

import com.jython.todo.api.task.domain.Task;
import lombok.Data;

@Data
public class ExistingTaskDto {
  private final Long id;
  private final String description;

  public static ExistingTaskDto fromDomain(Task task) {
    return new ExistingTaskDto(task.getId().getValue(), task.getDescription());
  }
}

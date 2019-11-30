package com.jython.todo.api.task.domain;

import lombok.Value;

@Value
public class Task {
  private Id id;
  private String description;

  public static Task withNoId(String description) {
    return new Task(null, description);
  }

  @Value
  public static class Id {
    private Long value;
  }
}

package com.jython.todo.api.task.application.port.out;

import com.jython.todo.api.task.domain.Task;

public interface SaveTaskPort {
  Task create(Task task);
}

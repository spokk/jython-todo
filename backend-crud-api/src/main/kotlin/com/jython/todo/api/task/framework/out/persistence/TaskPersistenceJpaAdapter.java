package com.jython.todo.api.task.framework.out.persistence;

import com.jython.todo.api.task.application.port.out.SaveTaskPort;
import com.jython.todo.api.task.domain.Task;
import com.jython.todo.api.task.framework.out.persistence.entity.TaskEntity;
import com.jython.todo.api.task.framework.out.persistence.repository.TaskJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskPersistenceJpaAdapter implements SaveTaskPort {

  private final TaskJpaRepository repository;

  @Override
  public Task create(Task task) {
    TaskEntity entity = TaskEntity.builder()
        .description(task.getDescription())
        .build();

    return repository.save(entity).toDomain();
  }
}

package com.jython.todo.api.task.framework.out.persistence.entity;

import com.jython.todo.api.task.domain.Task;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class TaskEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String description;

  public static TaskEntity fromDomain(Task task) {
    return TaskEntity.builder()
        .id(task.getId().getValue())
        .description(task.getDescription())
        .build();
  }

  public Task toDomain() {
    return new Task(new Task.Id(this.id), this.description);
  }
}

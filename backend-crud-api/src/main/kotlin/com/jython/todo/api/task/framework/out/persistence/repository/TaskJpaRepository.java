package com.jython.todo.api.task.framework.out.persistence.repository;

import com.jython.todo.api.task.framework.out.persistence.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends CrudRepository<TaskEntity, Long> {
}

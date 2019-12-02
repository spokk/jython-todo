package com.jython.todo.api.task.framework.out.persistence.repository

import com.jython.todo.api.task.framework.out.persistence.entity.TaskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskJpaRepository : CrudRepository<TaskEntity, Long>
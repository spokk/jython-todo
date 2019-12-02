package com.jython.todo.api.task.framework.out.persistence

import com.jython.todo.api.task.application.port.out.SaveTaskPort
import com.jython.todo.api.task.domain.Task
import com.jython.todo.api.task.framework.out.persistence.entity.TaskEntity
import com.jython.todo.api.task.framework.out.persistence.repository.TaskJpaRepository

class TaskPersistenceJpaAdapter(private val repository: TaskJpaRepository) : SaveTaskPort {

    override fun create(task: Task): Task {
        val entity = TaskEntity.description(task.description).build()
        val saved = repository.save(entity)
        return saved.toDomain()
    }
}
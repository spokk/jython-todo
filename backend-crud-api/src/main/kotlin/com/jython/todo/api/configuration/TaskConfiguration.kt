package com.jython.todo.api.configuration

import com.jython.todo.api.task.application.port.`in`.CreateTaskUseCase
import com.jython.todo.api.task.application.port.out.SaveTaskPort
import com.jython.todo.api.task.application.service.CreateTaskService
import com.jython.todo.api.task.framework.out.persistence.TaskPersistenceJpaAdapter
import com.jython.todo.api.task.framework.out.persistence.repository.TaskJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskConfiguration {

    @Bean
    fun createTaskUseCase(saveTaskPort: SaveTaskPort): CreateTaskUseCase =
            CreateTaskService(saveTaskPort)

    @Bean
    fun createTaskPort(taskJpaRepository: TaskJpaRepository): SaveTaskPort =
            TaskPersistenceJpaAdapter(taskJpaRepository)
}
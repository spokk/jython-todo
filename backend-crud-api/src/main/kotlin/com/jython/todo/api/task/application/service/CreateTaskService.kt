package com.jython.todo.api.task.application.service

import com.jython.todo.api.task.application.port.`in`.CreateTaskUseCase
import com.jython.todo.api.task.application.port.`in`.command.CreateTaskCommand
import com.jython.todo.api.task.application.port.out.SaveTaskPort
import com.jython.todo.api.task.domain.Task

internal class CreateTaskService(private val saveTaskPort: SaveTaskPort) : CreateTaskUseCase {

    override fun create(command: CreateTaskCommand): Task {
        return saveTaskPort.create(Task.withNoId(command.taskDescription))
    }
}

package com.jython.todo.api.task.application.port.`in`

import com.jython.todo.api.task.application.port.`in`.command.CreateTaskCommand
import com.jython.todo.api.task.domain.Task

interface CreateTaskUseCase {
    fun create(command: CreateTaskCommand): Task
}
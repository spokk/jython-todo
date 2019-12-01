package com.jython.todo.api.task.application.port.out

import com.jython.todo.api.task.domain.Task

interface SaveTaskPort {
    fun create(task: Task): Task
}

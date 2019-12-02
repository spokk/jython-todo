package com.jython.todo.api.task.framework.`in`.web.dto

import com.jython.todo.api.task.domain.Task

data class ExistingTaskDto(val id: Long?, val description: String?) {

    companion object {
        fun fromDomain(task: Task): ExistingTaskDto = ExistingTaskDto(task.id!!.value, task.description)
    }
}
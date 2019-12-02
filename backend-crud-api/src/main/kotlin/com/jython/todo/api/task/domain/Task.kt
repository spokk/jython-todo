package com.jython.todo.api.task.domain

data class Task(val id: Id?, val description: String) {

    companion object {
        fun withNoId(description: String): Task {
            return Task(null, description)
        }
    }

    class Id(val value: Long?)
}
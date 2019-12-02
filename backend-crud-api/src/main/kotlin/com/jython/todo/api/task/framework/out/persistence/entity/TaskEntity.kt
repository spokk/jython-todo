package com.jython.todo.api.task.framework.out.persistence.entity

import com.jython.todo.api.task.domain.Task
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TaskEntity(
        @Id @GeneratedValue private val id: Long?,
        private val description: String?) {

    private constructor(builder: Builder) : this(builder.id, builder.description)

    fun toDomain(): Task = Task(
            Task.Id(this.id),
            this.description ?: throw IllegalArgumentException("description must not be null"))

    companion object Builder {
        var id: Long? = null;
        var description: String? = null;

        fun id(value: Long) = apply { id = value }
        fun description(value: String) = apply { description = value }

        fun build(): TaskEntity = TaskEntity(this)
    }
}
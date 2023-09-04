package com.mak.tarefas.service

import com.mak.tarefas.model.Tasks
import com.mak.tarefas.repository.TasksRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class TasksService(var repository: TasksRepository){
    fun getTask(id: Long) : Tasks {
        return repository.findById(id).orElseThrow{EntityNotFoundException()}
    }
    fun createTask(task: Tasks) : Tasks {
        return repository.save(task)
    }
}
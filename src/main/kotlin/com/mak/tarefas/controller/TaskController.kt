package com.mak.tarefas.controller

import com.mak.tarefas.model.Tasks
import com.mak.tarefas.service.TasksService
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(var tasksService: TasksService) {
    @GetMapping("/findById")
    fun findById(@RequestParam id: Long) : ResponseEntity<Any>  {
        return try {
            ResponseEntity.ok(tasksService.getTask(id))
        }
        catch (ex: EntityNotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel achar a Task com este ID")
        }
    }

    @PostMapping("/create")
    fun crateTask(@RequestBody task: Tasks) : ResponseEntity<Tasks> {
        return ResponseEntity.ok(tasksService.createTask(task))
    }
}
package com.mak.tarefas.repository

import com.mak.tarefas.model.Tasks
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TasksRepository: JpaRepository<Tasks, Long> {
}
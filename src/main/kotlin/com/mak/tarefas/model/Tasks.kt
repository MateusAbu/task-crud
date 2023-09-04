package com.mak.tarefas.model

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Tasks (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var title: String = "",

    @Column
    var status: String = "",
)
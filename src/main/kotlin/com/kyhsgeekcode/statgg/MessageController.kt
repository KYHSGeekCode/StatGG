package com.kyhsgeekcode.statgg

import org.springframework.data.relational.core.mapping.Table
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.annotation.Id


@RestController
class MessageController(val service: MessageService) {

    @GetMapping("/messages")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/message")
    fun post(@RequestBody message: Message) {
        service.post(message)
    }

}

@Table("MESSAGE")
data class Message(@Id val id: String?, val text: String)

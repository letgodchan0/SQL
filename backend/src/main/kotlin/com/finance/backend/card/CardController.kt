package com.finance.backend.card

import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/card")
class CardController(
        val cardService: CardService
) {

    @PutMapping("/asset")
    fun registerCard(@RequestBody cdNoList: List<String>): ResponseEntity<Any>{
        return ResponseEntity
                .ok()
                .body(cardService.registerMain(cdNoList))
    }
}
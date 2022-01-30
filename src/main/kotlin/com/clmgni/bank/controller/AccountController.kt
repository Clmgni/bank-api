package com.clmgni.bank.controller

import com.clmgni.bank.model.Account
import com.clmgni.bank.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

var logger: Logger = LoggerFactory.getLogger(LoggingController::class.java)

@RestController
@RequestMapping("/accounts")
class AccountController(private val service: AccountService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account): Account {
        logger.info("Conta criada!")
        return service.create(account)
    }

    @GetMapping
    fun getAll(): List<Account> {
        logger.info("Listagem solicitada")
        return service.getAll()
    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Account> =
            service.getById(id).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: Account) : ResponseEntity<Account> =
            service.update(id, account).map {
                ResponseEntity.ok(it)
                }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}
package com.clmgni.bank.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController


@RestController
class LoggingController {
    var logger: Logger = LoggerFactory.getLogger(LoggingController::class.java)
    @RequestMapping("/")
    fun index(): String {
        logger.trace("A TRACE Message")
        logger.debug("A DEBUG Message")
        logger.info("An INFO Message")
        logger.warn("A WARN Message")
        logger.error("An ERROR Message")
        return "Logs gerados no output da aplicação!"
    }
}
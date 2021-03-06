package com.clmgni.bank.repository

import com.clmgni.bank.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountRepository : JpaRepository<Account, Long> {

    fun findByDocument(document: String): Optional<Account>

}
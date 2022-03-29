package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun mastercardAndMaestro() {
        val amount = 76_000
        val commissionMastercardAndMaestroPercent = 0.6
        val commissionMastercardAndMaestro = 20
        val maxMastercardAndMaestroInMonth = 75_000

        val result = mastercardAndMaestro(
            amount = amount,
            commissionMastercardAndMaestroPercent = commissionMastercardAndMaestroPercent,
            commissionMastercardAndMaestro = commissionMastercardAndMaestro,
            maxMastercardAndMaestroInMonth = maxMastercardAndMaestroInMonth
        )
        val sum = result.first.toInt()
        val commission = result.second.toInt()
        assertEquals(76_476, sum)
        assertEquals(476, commission)
    }

    @Test
    fun visaAndMir() {
        val amount = 1
        val commissionVisaAndMir = 0.75
        val minCommissionVisaAndMir = 35.0


        val result = visaAndMir(
            amount = amount,
            commissionVisaAndMir = commissionVisaAndMir,
            minCommissionVisaAndMir = minCommissionVisaAndMir
        )
        val sum = result.first.toInt()
        val commission = result.second.toInt()
        assertEquals(36, sum)
        assertEquals(35, commission)
    }

    @Test
    fun vkPay() {

    }

    @Test
    fun printDelim() {
    }

    @Test
    fun printFinal() {
    }


}
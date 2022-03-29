package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main() {
        val commissionMastercardAndMaestroPercent = 0.6
        val commissionMastercardAndMaestro = 20
        val minCommissionVisaAndMir = 35.0
        val commissionVisaAndMir = 0.75

        val maxMastercardAndMaestroInMonth = 75_000
        val maxAmountPerDayCard = 150_000
        val maxAmountPerMonthCard = 600_000
        val maxAmountAtOneTimeVKPay = 15_000
        val maxAmountPerMonthVKPay = 40_000
        var amount = 150_001

        var result = printFinal(
            commissionMastercardAndMaestroPercent = commissionMastercardAndMaestroPercent,
            commissionMastercardAndMaestro = commissionMastercardAndMaestro,
            minCommissionVisaAndMir = minCommissionVisaAndMir,
            commissionVisaAndMir = commissionVisaAndMir,
            maxMastercardAndMaestroInMonth = maxMastercardAndMaestroInMonth,
            maxAmountPerDayCard =  maxAmountPerDayCard,
            maxAmountPerMonthCard = maxAmountPerMonthCard,
            maxAmountAtOneTimeVKPay = maxAmountAtOneTimeVKPay,
            maxAmountPerMonthVKPay = maxAmountPerMonthVKPay,
            amount = amount
        )
        assertEquals(Unit,result)

        amount = 0
        result = printFinal(
            commissionMastercardAndMaestroPercent = commissionMastercardAndMaestroPercent,
            commissionMastercardAndMaestro = commissionMastercardAndMaestro,
            minCommissionVisaAndMir = minCommissionVisaAndMir,
            commissionVisaAndMir = commissionVisaAndMir,
            maxMastercardAndMaestroInMonth = maxMastercardAndMaestroInMonth,
            maxAmountPerDayCard =  maxAmountPerDayCard,
            maxAmountPerMonthCard = maxAmountPerMonthCard,
            maxAmountAtOneTimeVKPay = maxAmountAtOneTimeVKPay,
            maxAmountPerMonthVKPay = maxAmountPerMonthVKPay,
            amount = amount
        )
        assertEquals(Unit,result)
    }

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
        val amount = 15_001
        val maxAmountAtOneTimeVKPay = 15_000
        val maxAmountPerMonthVKPay = 40_000

        val result = vkPay(
            amount = amount,
            maxAmountAtOneTimeVKPay = maxAmountAtOneTimeVKPay,
            maxAmountPerMonthVKPay = maxAmountPerMonthVKPay
        )
        assertEquals(Unit, result)
    }

    @Test
    fun printDelim() {
        val sum = 100.5
        val commission = 9.5

        val result = printDelim(
            sum = sum,
            commission = commission
        )
        assertEquals(Unit, result)
    }

    @Test
    fun printFinal() {
        val amount = 5000
        val maxAmountPerDayCard = 150_000
        val maxAmountPerMonthCard = 600_000
        val commissionVisaAndMir = 0.75
        val minCommissionVisaAndMir = 35.0
        val commissionMastercardAndMaestroPercent = 0.6
        val commissionMastercardAndMaestro = 20
        val maxMastercardAndMaestroInMonth = 75_000
        val maxAmountAtOneTimeVKPay = 15_000
        val maxAmountPerMonthVKPay = 40_000

        val result = printFinal(
            amount = amount,
            maxAmountPerDayCard = maxAmountPerDayCard,
            maxAmountPerMonthCard = maxAmountPerMonthCard,
            commissionVisaAndMir = commissionVisaAndMir,
            minCommissionVisaAndMir = minCommissionVisaAndMir,
            commissionMastercardAndMaestroPercent = commissionMastercardAndMaestroPercent,
            commissionMastercardAndMaestro = commissionMastercardAndMaestro,
            maxMastercardAndMaestroInMonth = maxMastercardAndMaestroInMonth,
            maxAmountAtOneTimeVKPay = maxAmountAtOneTimeVKPay,
            maxAmountPerMonthVKPay = maxAmountPerMonthVKPay
        )
        assertEquals(Unit, result)
    }
}
package ru.netology

import kotlin.math.ceil

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



    print("Введите сумму для перевода: ")
    val amount = readLine()?.toInt() ?: return

    vkPay(amount, maxAmountAtOneTimeVKPay, maxAmountPerMonthVKPay)
    if (amount > maxAmountPerDayCard) {
        println("Превышена сумма перевода за одини сутки по картам")
        println("Mastercard, Maestro,Visa, Mir")
    } else {
        println("Перевод с карты Mastercard или Maestro")
        mastercardAndMaestro(
            amount, commissionMastercardAndMaestroPercent,
            commissionMastercardAndMaestro,
            maxMastercardAndMaestroInMonth
        )
        println("Перевод с карты Visa или Mir")
        visaAndMir(amount, commissionVisaAndMir, minCommissionVisaAndMir)
        limits(amount, maxAmountPerDayCard, maxAmountPerMonthCard)
    }
}

private fun mastercardAndMaestro(
    amount: Int, commissionMastercardAndMaestroPercent: Double,
    commissionMastercardAndMaestro: Int,
    maxMastercardAndMaestroInMonth: Int
) {
    var commission: Double
    val sum: Double = if (amount > maxMastercardAndMaestroInMonth) {
        commission = amount / 100 * commissionMastercardAndMaestroPercent + commissionMastercardAndMaestro
        amount + commission
    } else {
        commission = 0.0
        amount.toDouble()
    }
    val pennies = (sum - sum.toInt()) * 100
    println("Комиссия сотавила ${ceil(commission * 100).toInt()} копеек")
    println("Сумма перевода с учетом комиссии сотавит ${ceil(sum).toInt()} рублей ${ceil(pennies).toInt()} копеек\n")
}

private fun visaAndMir(amount: Int, commissionVisaAndMir: Double, minCommissionVisaAndMir: Double) {
    var commission: Double = amount / 100 * commissionVisaAndMir
    val sum = if (commission > minCommissionVisaAndMir) {
        amount + commission
    } else {
        commission = minCommissionVisaAndMir
        (amount + minCommissionVisaAndMir)
    }
    val pennies = (sum - sum.toInt()) * 100
    println("Комиссия сотавила ${ceil(commission * 100).toInt()} копеек")
    println("Сумма перевода с учетом комиссии сотавит ${ceil(sum).toInt()} рублей ${ceil(pennies).toInt()} копеек\n")
}

private fun vkPay(amount: Int, maxAmountAtOneTimeVKPay: Int, maxAmountPerMonthVKPay: Int) {
    println("Перевод с VKPay")
    if (amount > maxAmountAtOneTimeVKPay) {
        println("Превышена сумма перевода за один раз.\n")
    } else {
        println("Сумма перевода $amount рублей ,комиссия не взимается")
        val remainderOnTime = maxAmountAtOneTimeVKPay - amount
        val remainderMonth = maxAmountPerMonthVKPay - amount
        println("Остаток на текущий день $remainderOnTime рубль")
        println("Остаток на текущий месяц $remainderMonth рубль\n")
    }
}

private fun limits(amount: Int, maxAmountPerDayCard: Int, maxAmountPerMonthCard: Int) {
    val remainderDay = maxAmountPerDayCard - amount
    val remainderMonth = maxAmountPerMonthCard - amount
    println("Остаток на текущий день $remainderDay рубль")
    println("Остаток на текущий месяц $remainderMonth рубль")
}




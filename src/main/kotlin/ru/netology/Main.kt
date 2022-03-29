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

    printFinal(
        amount,
        maxAmountPerDayCard,
        maxAmountPerMonthCard,
        commissionVisaAndMir,
        minCommissionVisaAndMir,
        commissionMastercardAndMaestroPercent,
        commissionMastercardAndMaestro,
        maxMastercardAndMaestroInMonth,
        maxAmountAtOneTimeVKPay,
        maxAmountPerMonthVKPay
    )
}

fun mastercardAndMaestro(
    amount: Int, commissionMastercardAndMaestroPercent: Double,
    commissionMastercardAndMaestro: Int,
    maxMastercardAndMaestroInMonth: Int
): Pair<Double, Double> {
    val commission: Double
    val sum: Double = if (amount > maxMastercardAndMaestroInMonth) {
        commission = amount / 100 * commissionMastercardAndMaestroPercent + commissionMastercardAndMaestro
        amount + commission
    } else {
        commission = 0.0
        amount.toDouble()
    }
    return Pair(sum, commission)
}

fun visaAndMir(amount: Int, commissionVisaAndMir: Double, minCommissionVisaAndMir: Double): Pair<Double, Double> {
    var commission: Double = amount / 100 * commissionVisaAndMir
    val sum = if (commission > minCommissionVisaAndMir) {
        amount + commission
    } else {
        commission = minCommissionVisaAndMir
        amount + minCommissionVisaAndMir
    }
    return Pair(sum, commission)
}

fun vkPay(amount: Int, maxAmountAtOneTimeVKPay: Int, maxAmountPerMonthVKPay: Int) {
    println("VKPay")
    if (amount > maxAmountAtOneTimeVKPay) {
        println("Превышена сумма перевода за один раз.\n")
        return
    }
    println("Сумма перевода $amount рублей ,комиссия не взимается\n")
    val remainderOnTime = maxAmountAtOneTimeVKPay - amount
    val remainderMonth = maxAmountPerMonthVKPay - amount
    println("Остаток на текущий день $remainderOnTime рубль")
    println("Остаток на текущий месяц $remainderMonth рубль\n")

}

fun printDelim(sum: Double, commission: Double) {
    val pennies = (sum - sum.toInt()) * 100
    println("Комиссия сотавила ${ceil(commission * 100).toInt()} копеек")
    println("Сумма перевода с учетом комиссии сотавит ${ceil(sum).toInt()} рублей ${ceil(pennies).toInt()} копеек\n")
}

fun printFinal(
    amount: Int, maxAmountPerDayCard: Int, maxAmountPerMonthCard: Int,
    commissionVisaAndMir: Double, minCommissionVisaAndMir: Double, commissionMastercardAndMaestroPercent: Double,
    commissionMastercardAndMaestro: Int, maxMastercardAndMaestroInMonth: Int,
    maxAmountAtOneTimeVKPay: Int, maxAmountPerMonthVKPay: Int
) {
    if (amount <= 0) {
        println("Введена неверная сумма перевода")
        return
    }
    if (amount > maxAmountPerDayCard) {
        println("Превышена сумма перевода за один раз :\nVkPay\n")
        println("Превышена сумма перевода в сутки по картам :")
        println("Mastercard,Maestro,Visa,Mir")
        return
    }
    vkPay(amount, maxAmountAtOneTimeVKPay, maxAmountPerMonthVKPay)
    println("Mastercard и Maestro")
    val (sumMAM, commissionMAM) = mastercardAndMaestro(
        amount, commissionMastercardAndMaestroPercent,
        commissionMastercardAndMaestro,
        maxMastercardAndMaestroInMonth
    )
    printDelim(sumMAM, commissionMAM)
    println("Visa и Mir")
    val (sumVAM, commissionVAM) = visaAndMir(amount, commissionVisaAndMir, minCommissionVisaAndMir)
    printDelim(sumVAM, commissionVAM)
    val remainderDay = maxAmountPerDayCard - amount
    val remainderMonth = maxAmountPerMonthCard - amount
    println("По картам: ")
    println("Остаток на текущий день $remainderDay рубль")
    println("Остаток на текущий месяц $remainderMonth рубль")


}




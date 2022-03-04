package com.example.tdd.ch01

class Money(
    private val stocks: String,
    private val amount: Int,
    private val price: Int,
    private val currency: Currency? = Currency.USD
) {
    fun getTotalStockPrice(): Double {
        return this.amount * (this.price / (this.currency?.exchangeRate ?: 1.0))
    }

    companion object {
        fun Money.add(money: Money): Double {
            return this.getTotalStockPrice() + money.getTotalStockPrice()
        }
    }
}

enum class Currency(val exchangeRate: Double) {
    USD(1.0), CHF(1.5)
}
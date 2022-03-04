package com.example.tdd.ch01

class Money(
    private val stocks: String,
    private val amount: Int,
    private val price: Int,
) {
    fun getTotalStockPrice(): Int {
        return this.amount * this.price
    }
}
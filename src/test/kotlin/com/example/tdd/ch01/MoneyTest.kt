package com.example.tdd.ch01

import com.example.tdd.ch01.Money.Companion.add
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {
    // 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야함
    // 어떤 금액(주가)가 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.

    @Test
    @DisplayName("어떤 금액(주가)가 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.")
    fun testMultiplyValues() {
        val amount = 10000
        val price = 25

        val money = Money("IBM", amount, price)
        assertThat(money.getTotalStockPrice()).isEqualTo(amount * price.toDouble())
    }

    @Test
    @DisplayName("통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 결과로 얻을 수 있어야함")
    fun testAdjustCurrencies() {
        val ibmAmount = 1000
        val ibmPrice = 25

        val ibm = Money("IBM", ibmAmount, ibmPrice, Currency.USD)

        val novartisAmount = 400
        val novartisPrice = 150
        val novartis = Money("Novartis", novartisAmount, novartisPrice, Currency.CHF)

        val result = ibm.add(novartis)
        assertThat(result).isEqualTo(65000.toDouble())
    }
}
package org.hj.domain

object LottoGenerator {
    fun generate(amount: Int): List<Lotto> {
        require(amount % 1000 == 0) { "1000원 단위로만 구매 가능합니다."}
        val count = amount / 1000
        return List(count) { Lotto.generate() }
    }
}

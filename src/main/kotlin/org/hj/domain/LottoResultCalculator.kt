package org.hj.domain

object LottoResultCalculator {
    fun calculate(lotto: Lotto, winningLotto: WinningLotto): Rank {
        val matchCount = lotto.numbers.count {it in winningLotto.numbers}
        val hasBonus = winningLotto.bonus in lotto.numbers

        return when(matchCount) {
            6 -> Rank.FIRST
            5 -> if (hasBonus) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}
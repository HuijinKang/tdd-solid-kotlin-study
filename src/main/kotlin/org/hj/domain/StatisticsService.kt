package org.hj.domain

class StatisticsService {
    fun calculateResult(lottos: List<Lotto>, winning: WinningLotto): Map<Rank, Int> {
        return lottos
            .map { LottoResultCalculator.calculate(it, winning) }
            .groupingBy { it }
            .eachCount()
    }

    fun calculateEarningRate(result: Map<Rank, Int>, totalCost: Int): Double {
        val totalPrize = result.entries.sumOf { it.key.prize * it.value }
        return (totalPrize.toDouble() / totalCost) * 100
    }
}
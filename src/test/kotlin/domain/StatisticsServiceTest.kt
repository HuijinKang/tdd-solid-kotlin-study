package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.hj.domain.Lotto
import org.hj.domain.Rank
import org.hj.domain.StatisticsService
import org.hj.domain.WinningLotto

class StatisticsServiceTest : StringSpec({

    "등수별 개수를 계산하고 전체 수익률을 계산한다" {
        val winning = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)

        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2등
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // 꽝
        )

        val stats = StatisticsService()
        val result = stats.calculateResult(lottos, winning)
        val earningRate = stats.calculateEarningRate(result, totalCost = 3000)

        result[Rank.FIRST] shouldBe 1
        result[Rank.SECOND] shouldBe 1
        result[Rank.NONE] shouldBe 1
        earningRate shouldBeGreaterThan 100000.0
    }
})
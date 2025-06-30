package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.hj.domain.Lotto
import org.hj.domain.LottoResultCalculator
import org.hj.domain.Rank
import org.hj.domain.WinningLotto

class LottoResultCalculatorTest : StringSpec({

    "로또 번호와 당첨 번호 일치 수, 보너스 포함 여부에 따라 등수를 계산한다" {
        val winning = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)

        val first = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val second = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val third = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val none = Lotto(listOf(10, 11, 12, 13, 14, 15))

        LottoResultCalculator.calculate(first, winning) shouldBe Rank.FIRST
        LottoResultCalculator.calculate(second, winning) shouldBe Rank.SECOND
        LottoResultCalculator.calculate(third, winning) shouldBe Rank.THIRD
        LottoResultCalculator.calculate(none, winning) shouldBe Rank.NONE
    }
})
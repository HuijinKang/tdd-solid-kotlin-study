package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.hj.domain.WinningLotto

class WinningLottoTest : StringSpec({

    "당첨 번호는 6개 숫자와 보너스 번호로 구성된다" {
        val winning = WinningLotto(setOf(1, 2, 3, 4, 5, 6), 7)
        winning.numbers shouldHaveSize 6
        winning.bonus shouldBe 7
    }

    "보너스 번호는 당첨 번호와 중복될 수 없다" {
        val exception = shouldThrow<IllegalArgumentException> {
            WinningLotto(setOf(1, 2, 3, 4, 5, 6), 6)
        }

        exception.message shouldBe "보너스 번호는 당첨 번호와 중복될 수 없습니다."
    }
})
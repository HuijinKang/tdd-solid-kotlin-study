package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.hj.domain.LottoGenerator

class LottoGeneratorTest : StringSpec({

    "금액에 따라 로또를 여러 장 생성한다" {
        val lottos = LottoGenerator.generate(5000)
        lottos shouldHaveSize 5
    }

    "1000원 단위가 아닌 금액은 예외를 발생시킨다" {
        val exception = shouldThrow<IllegalArgumentException> {
            LottoGenerator.generate(5500)
        }
        exception.message shouldBe "1000원 단위로만 구매 가능합니다."
    }
})
package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeUnique
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import org.hj.domain.Lotto

class LottoTest : StringSpec({

    "로또 번호는 6개여야 한다" {
        val lotto = Lotto.generate()
        lotto.numbers shouldHaveSize 6
    }

    "로또 번호는 1~45 사이의 중복 없는 수여야 한다" {
        val lotto = Lotto.generate()

        lotto.numbers shouldHaveSize 6
        lotto.numbers.shouldBeUnique()

        lotto.numbers.forEach {
            it shouldBeGreaterThanOrEqual 1
            it shouldBeLessThanOrEqual 45
        }
    }
})
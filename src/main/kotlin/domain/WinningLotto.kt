package org.hj.domain

data class WinningLotto(val numbers: Set<Int>, val bonus: Int) {
    init {
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
        require(bonus !in numbers) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        require((numbers + bonus).all { it in 1..45 })
    }
}

package org.hj.domain

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6 ) { "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    companion object {
        fun generate(): Lotto {
            val numbers = (1..45).shuffled().take(6).sorted()
            return Lotto(numbers)
        }
    }
}
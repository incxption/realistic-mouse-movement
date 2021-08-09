import kotlin.math.pow
import kotlin.math.sin
import kotlin.random.Random

private fun easeInOutBack(x: Double): Double {
    val c1 = 2.70158
    val c2 = c1 * 1.525

    return if (x < 0.5) ((2 * x).pow(2.0) * ((c2 + 1) * 2 * x - c2)) / 2
    else ((2 * x - 2).pow(2.0) * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2
}

private fun easeOutBack(x: Double): Double {
    val c1 = 4.70158;
    val c3 = c1 + 1;

    return 1 + c3 * (x - 1).pow(3) + c1 * (x - 1).pow(2);
}

private fun easeOutElastic(x: Double): Double {
    val c4 = (2 * Math.PI) / 3;

    return when(x) {
        0.0 -> 0.0
        1.0 -> 1.0
        else -> 2.0.pow(-10 * x) * sin((x * 10 - 0.75) * c4) + 1;
    }
}

private fun noEasing(x: Double) = x * x

fun getRandomEasing() = when(Random.nextInt(4)) {
    0 -> ::easeInOutBack
    1 -> ::easeOutBack
    2 -> ::easeOutElastic
    else -> ::noEasing
}

fun getRandomPower(): (x: Double) -> Double {
    val power = Random.nextInt(3) + 1
    return { it.pow(power) }
}

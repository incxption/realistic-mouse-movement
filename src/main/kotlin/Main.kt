import java.awt.Point
import kotlin.random.Random

fun main() {
    simulateRealisticMouseMovement(randomPoint(), Random.nextInt(300) + 100)
}

private fun randomPoint(): Point {
    return Point(Random.nextInt(2560), Random.nextInt(1080))
}

import java.awt.*
import kotlin.random.Random
import kotlin.random.nextLong

val robot = Robot()

fun simulateRealisticMouseMovement(end: Point, steps: Int) {
    val start = MouseInfo.getPointerInfo().location

    val dx = end.x - start.x
    val dy = end.y - start.y

    val easeX = getRandomEasing()
    val easeY = getRandomEasing()

    val powerX = getRandomPower()
    val powerY = getRandomPower()

    for (step in 0..steps) {
        val progress = step / steps.toDouble()

        val randomX = easeX(powerX(progress))
        val randomY = easeY(powerY(progress))

        val x = start.x + (dx * progress * randomX).toInt()
        val y = start.y + (dy * progress * randomY).toInt()

        move(x, y)
        Thread.sleep(Random.nextLong(1L..10L))
    }
}

private fun move(x: Int, y: Int) {
    robot.mouseMove(x, y)
}

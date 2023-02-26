import java.lang.reflect.Array.get


fun main() {
    val seconds = readln().toInt()
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> "был(а) ${minuteFormat(seconds)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${hourFormat(seconds)} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети сегодня"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun minuteFormat(seconds: Int): String {
    return when (seconds) {
        1, 21, 31, 41, 51 -> "$seconds минуту"
        2, 22, 32, 42, 52,
        3, 23, 33, 43, 53,
        4, 24, 34, 44, 54 -> "$seconds минуты"
        else -> "$seconds минут"
    }
}

fun hourFormat(seconds: Int): String {
    return when (seconds / 3600) {
        1 -> "1 час"
        2, 3, 4 -> "${seconds / 3600} часа"
        else -> "${seconds / 3600} часов"
    }
}
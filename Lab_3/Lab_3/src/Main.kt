import java.util.Scanner

fun countNonNullValues(map: Map<String, Int?>): Int {
    return map.values.count { it != null }
}

fun printNonNullPopulations(map: Map<String, Int?>) {
    println("Міста з відомим населенням:")
    map.forEach { (city, population) ->
        if (population != null) {
            println("$city: $population")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введіть кількість міст у мапі: ")
    val numberOfCities = scanner.nextInt()
    scanner.nextLine()  // Спожити залишок нової лінії

    val cityPopulationMap = mutableMapOf<String, Int?>()

    for (i in 1..numberOfCities) {
        println("Введіть назву міста $i: ")
        val city = scanner.nextLine()

        println("Введіть населення для міста $i (натисніть Enter для невідомого населення): ")
        val populationInput = scanner.nextLine()
        val population = if (populationInput.isEmpty()) null else populationInput.toInt()

        cityPopulationMap[city] = population
    }

    val nonNullCount = countNonNullValues(cityPopulationMap)
    println("Кількість міст у мапі, де населення відоме: $nonNullCount")
    printNonNullPopulations(cityPopulationMap)
}

import java.util.Scanner

data class Song(val title: String, val duration: Double)

data class MusicAlbum(val name: String, val artist: String, val songs: List<Song>) {
    fun averageSongDuration(): Double {
        return if (songs.isNotEmpty()) {
            songs.sumByDouble { it.duration } / songs.size
        } else {
            0.0
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Введення інформації про альбом
    println("Введіть назву альбому: ")
    val albumName = scanner.nextLine()

    println("Введіть ім'я виконавця: ")
    val artistName = scanner.nextLine()

    // Введення кількості пісень
    println("Введіть кількість пісень: ")
    val numberOfSongs = scanner.nextInt()
    scanner.nextLine()  // consume the remaining newline

    // Введення інформації про кожну пісню
    val songs = mutableListOf<Song>()
    for (i in 1..numberOfSongs) {
        println("Введіть назву пісні $i: ")
        val songTitle = scanner.nextLine()

        println("Введіть тривалість пісні $i (в хвилинах): ")
        val songDuration = scanner.nextDouble()
        scanner.nextLine()  // consume the remaining newline

        songs.add(Song(songTitle, songDuration))
    }

    // Створення альбому
    val album = MusicAlbum(albumName, artistName, songs)

    // Виведення інформації про альбом та середню тривалість пісень
    println("Альбом: ${album.name} від ${album.artist}")
    println("Пісні:")
    album.songs.forEach { println("${it.title} - ${it.duration} хвилин") }
    println("Середня тривалість пісень: ${album.averageSongDuration()} хвилин")
}

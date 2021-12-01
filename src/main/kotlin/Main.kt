import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.system.exitProcess


const val CURRENCY_LINK = "https://api.coingate.com/v2/rates/merchant/EUR/USD"

fun main(args: Array<String>) {
    val ratio: Double
    try {
        val url = URL(CURRENCY_LINK)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.useCaches = false
        connection.connect()
        ratio = connection.inputStream.bufferedReader().use(BufferedReader::readText).toDouble()
    } catch (e: Exception) {
        println("Ops! Problems with network service.")
        exitProcess(1)
    }
    println("USD -> EUR\nWrite the amount of us dollars or write \"exit\" to leave the converter:")
    while (true) {
        val input = readLine()
        if (input == "exit") {
            println("Exit from converter...")
            break
        }
        try {
            val number = input!!.toDouble()
            println(String.format("%.2f euro", number * ratio))
        } catch (e: NumberFormatException) {
            println("Wrong format of input.")
            exitProcess(1)
        }
    }
    exitProcess(0)
}
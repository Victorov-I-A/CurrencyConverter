import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.system.exitProcess


const val CURRENCY_LINK = "https://api.coingate.com/v2/rates/merchant/EUR/USD"

fun main() {
    val ratio: Double
    val url = URL(CURRENCY_LINK)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    connection.useCaches = false
    connection.connect()
    ratio = connection.inputStream.bufferedReader().use(BufferedReader::readText).toDouble()
    println("USD -> EUR\nWrite the amount of us dollars:")
    val number = readLine()!!.toDouble()
    println(String.format("%.2f euro", number * ratio))
    exitProcess(0)
}
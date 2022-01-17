import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CurrencyConverterTest {

    @Test
    fun `api connection check`() {
        assertDoesNotThrow {
            CurrencyConverter().connection()
        }
    }

    @Test
    fun `api data format check`() {
        val ratio = CurrencyConverter().connection()
        assertTrue(ratio > 0)
        assertTrue(ratio % 1 < 100)
    }
}
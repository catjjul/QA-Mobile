import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckValidityTest {

    @Test
    fun withIntersection() {
        assertEquals(0, checkValidity("{12}([w])1"))
    }

    @Test
    fun withoutIntersection() {
        assertEquals(0, checkValidity("{12}(w)<1>"))
    }

    @Test
    fun withIntersectionEveryBracketType() {
        assertEquals(0, checkValidity("[]{12}(po1)(<12>)"))
    }

    @Test
    fun withoutIntersectionEveryBracketType() {
        assertEquals(0, checkValidity("[]{12}(po1)<12>"))
    }

    @Test
    fun withOneTypeBracket() {
        assertEquals(0, checkValidity("123-{1}"))
    }

    @Test
    fun withIntersectionOpenBracket() {
        assertEquals(3, checkValidity("{[}"))
    }

    @Test
    fun withoutIntersectionOpenBracket() {
        assertEquals(5, checkValidity("([]))["))
    }

    @Test
    fun closeBracket() {
        assertEquals(10, checkValidity("foo(bar[i)"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, checkValidity(""))
    }

    @Test
    fun withoutBrackets() {
        assertEquals(0, checkValidity("123sd-&!jfh"))
    }
}
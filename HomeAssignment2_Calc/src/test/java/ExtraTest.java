import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import laskin.Laskin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testVirtaON() {
        System.out.println("@BeforeAll Virta ON (ennen ensimmäistä testiä)");
        laskin.virtaON();
    }

    @AfterAll
    public static void testVirtaOFF() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), DELTA, "Nollaus ei onnistunut");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 5})
    public void testNelio(int number) {
        laskin.nelio(number);
        assertEquals(number * number, laskin.annaTulos(), DELTA, "Luvun " + number + " neliöön korotus väärin");
    }

    @Test
    public void testNeliojuuri2() {
        laskin.neliojuuri(2);
        assertEquals((int) Math.sqrt(2), laskin.annaTulos(), DELTA, "Luvun 2 neliöjuuri väärin");
    }

    @Test
    @DisplayName("Testaa negatiivinen neliöjuuri")
    public void testNeliojuuriNegat() {
        laskin.neliojuuri(-2);
        assertEquals(0, laskin.annaTulos(), DELTA, "Negatiivisen luvun neliöjuuri ei ole määritelty");
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroTest {
    private String[][] registro;

    @BeforeEach
    public void setUp() {
        registro = new String[50][3];
    }

    @Test
    public void testAgregarPersona() {
        Scanner scanner = new Scanner("John\nsoltero/a\n25\n");
        Registro.agregarPersona(registro, scanner);
        assertEquals("John", registro[0][0]);
        assertEquals("soltero/a", registro[0][1]);
        assertEquals("25", registro[0][2]);
    }

    @Test
    public void testContarMayoresDeEdad() {
        registro[0] = new String[]{"John", "soltero/a", "25"};
        registro[1] = new String[]{"Jane", "casado/a", "17"};
        assertEquals(1, Registro.contarMayoresDeEdad(registro));
    }

    @Test
    public void testContarMenoresDeEdad() {
        registro[0] = new String[]{"John", "soltero/a", "25"};
        registro[1] = new String[]{"Jane", "casado/a", "17"};
        assertEquals(1, Registro.contarMenoresDeEdad(registro));
    }

    @Test
    public void testContarTerceraEdad() {
        registro[0] = new String[]{"John", "casado/a", "60"};
        registro[1] = new String[]{"Jane", "soltero/a", "65"};
        registro[2] = new String[]{"Doe", "soltero/a", "64"};
        assertEquals(2, Registro.contarTerceraEdad(registro));
    }

    @Test
    public void testContarEstadoCivil() {
        registro[0] = new String[]{"John", "casado/a", "30"};
        registro[1] = new String[]{"Jane", "soltero/a", "25"};
        registro[2] = new String[]{"Doe", "casado/a", "40"};
        int[] result = Registro.contarEstadoCivil(registro);
        assertEquals(2, result[0]); // casados
        assertEquals(1, result[1]); // solteros
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataHorarioTest {
    private DataHorario dh;
    private Data d;

    @BeforeEach
    void setUp() {
        d = mock(Data.class);
        when(d.minutos()).thenReturn(0);
        dh = new DataHorario(d);
    }

    @Test
    void constroi() {
        assertEquals(0, dh.getHora());
        assertEquals(0, dh.getMinuto());
        assertEquals(0, dh.minutos());
    }

    @Test
    void horarioBaixo() {
        dh.atualiza(-1, -1);
        assertEquals(0, dh.getHora());
        assertEquals(0, dh.getMinuto());
        assertEquals(0, dh.minutos());
    }

    @Test
    void horarioAlto() {
        dh.atualiza(24, 60);
        assertEquals(23, dh.getHora());
        assertEquals(59, dh.getMinuto());
        assertEquals(1439, dh.minutos());
    }
}
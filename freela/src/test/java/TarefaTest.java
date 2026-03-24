import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarefaTest {
    private Tarefa t;

    @BeforeEach
    void setUp() {
        t = new Tarefa(1);
    }

    @Test
    void constroi() {
        assertEquals(1, t.getId());
        assertEquals("", t.getDescricao());
        assertNull(t.getInicio());
        assertNull(t.getFim());
    }

    @Test
    void mudaDescricao() {
        t.setDescricao("Aps5");
        assertEquals("Aps5", t.getDescricao());
    }

    @Test
    void momentosValidos() {
        Momento inicio = mock(Momento.class);
        Momento fim = mock(Momento.class);
        when(inicio.minutos()).thenReturn(0);
        when(fim.minutos()).thenReturn(1440);

        t.atualiza(inicio, fim);

        assertEquals(inicio, t.getInicio());
        assertEquals(fim, t.getFim());
    }

    @Test
    void momentosInvalidos() {
        Momento inicio = mock(Momento.class);
        Momento fim = mock(Momento.class);
        when(inicio.minutos()).thenReturn(1440);
        when(fim.minutos()).thenReturn(0);

        assertThrows(IllegalArgumentException.class, () -> {
            t.atualiza(inicio, fim);
        });
    }
}
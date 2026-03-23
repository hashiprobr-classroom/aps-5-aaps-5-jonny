package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarefaTest {
    private static final double DELTA = 0.0001;
    private Tarefa t;

    @BeforeEach
    void setUp(){
        t = new Tarefa(1);
    }
    private Momento momento0Falso(int minuto){
        Momento momento01 = mock(Momento.class);
        when(momento01.minutos()).thenReturn(minuto);
        return momento01;
    }

    @Test
    public void constroi(){
        assertEquals(1,t.getId(),DELTA);
        assertEquals("", t.getDescricao());
        assertNull(t.getFim());
        assertNull(t.getInicio());
    }

    @Test
    public void mudaDescricao(){
        t.setDescricao("descricao");
        assertEquals("descricao", t.getDescricao());
    }
    @Test
    public void momentosValidos(){
        Momento m1 = momento0Falso(1);
        Momento m2 = momento0Falso(2);
        t.atualiza(m1,m2);
        assertEquals(m1,t.getInicio());
        assertEquals(m2,t.getFim());
    }

    @Test
    public void momentosInvalidos(){
        Momento m1 = momento0Falso(1);
        Momento m2 = momento0Falso(2);
        assertThrows(IllegalArgumentException.class, () -> {t.atualiza(m2,m1);});
    }


}

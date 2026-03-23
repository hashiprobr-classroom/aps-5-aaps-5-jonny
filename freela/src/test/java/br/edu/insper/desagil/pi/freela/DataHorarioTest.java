package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataHorarioTest {
    private static final double DELTA = 0.0000001;
    private Data data;
    private DataHorario horario;

    @BeforeEach
    void setUp(){
        data = new Data();
        horario = new DataHorario(data);
    }

    @Test
    void constroi(){
        data.atualiza(1970,1,1);
        horario.atualiza(0,0);
        assertEquals(0,horario.getMinuto(), DELTA);
        assertEquals(0,horario.getHora(), DELTA);
        assertEquals(0,horario.minutos(), DELTA);
    }
    @Test
    void horarioBaixo(){
        data.atualiza(1970,1,1);
        horario.atualiza(-1,-1);
        assertEquals(0,horario.getMinuto(), DELTA);
        assertEquals(0,horario.getHora(), DELTA);
        assertEquals(0,horario.minutos(), DELTA);
    }
    @Test
    void horarioAlto(){
        data.atualiza(1970,1,1);
        horario.atualiza(24,60);
        assertEquals(59,horario.getMinuto(), DELTA);
        assertEquals(23,horario.getHora(), DELTA);
        assertEquals(1439,horario.minutos(), DELTA);
    }
}

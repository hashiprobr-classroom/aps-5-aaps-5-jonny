package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {
    private static final double DELTA = 0.0000000001;
    private Data data;

    @BeforeEach
    void setUp(){
        data = new Data();
    }

    @Test
    void constroi(){
        data.atualiza(1970,1,1);
        assertEquals(0,data.minutos(), DELTA);
        assertEquals(1,data.getDia(), DELTA);
        assertEquals(1,data.getMes(), DELTA);
        assertEquals(1970,data.getAno(), DELTA);
    }

    @Test
    void dataBaixa(){
        data.atualiza(1969,0,0);
        assertEquals(0,data.minutos(), DELTA);
        assertEquals(1,data.getDia(), DELTA);
        assertEquals(1,data.getMes(), DELTA);
        assertEquals(1970,data.getAno(), DELTA);
    }

    @Test
    void dataAlta(){
        data.atualiza(2071,13,32);
        assertEquals(53084160,data.minutos(), DELTA);
        assertEquals(31,data.getDia(), DELTA);
        assertEquals(12,data.getMes(), DELTA);
        assertEquals(2070,data.getAno(), DELTA);
    }


}

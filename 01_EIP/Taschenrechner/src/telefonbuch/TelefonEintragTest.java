package telefonbuch;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class TelefonEintragTest {

    TelefonEintrag t = new TelefonEintrag("Max", "123456789");
    TelefonEintrag t2 = new TelefonEintrag("Max", "123456789");

    @Test
    public void testGetName() {
        assertEquals("Max", t.getName());
    }

    @Test
    public void testSetName() {
        t.setName("Frieda");
        assertEquals("Frieda", t.getName());
    }

    @Test
    public void testEquals() {
        assertEquals(t, t2);
    }

    @Test
    void testGetNumber() {
        assertEquals("123456789", t.getNumber());
    }

    @Test
    void testSetNumber() {
        t.setNumber("666");
        assertEquals("666", t.getNumber());
    }
}


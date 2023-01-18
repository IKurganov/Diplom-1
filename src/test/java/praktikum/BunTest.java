package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Test
    public void testGetName() {
        bun = new Bun("black bun", 100);
        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        bun = new Bun("black bun", 100);
        Assert.assertEquals(100, bun.getPrice(), 0);
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTests {
    @Test
    public void testUnionFind() {
        UnionFind uf = new UnionFind(5);
        try{
            assertEquals(2, uf.find(2));
            assertEquals(3, uf.find(3));
            assertFalse(uf.connected(1, 2));

            uf.union(0, 3);
            assertEquals(3, uf.find(3));
            assertEquals(3, uf.find(3));
            assertTrue(uf.connected(0, 3));

            uf.union(1, 2);
            uf.union(2, 4);
            assertEquals(2, uf.parent(1));
            assertEquals(2, uf.find(2));
            assertEquals(-3, uf.parent(2));
            assertEquals(2, uf.parent(4));

            assertTrue(uf.connected(1, 4));
            assertTrue(uf.connected(2, 4));

            assertFalse(uf.connected(0, 1));

            uf.union(0, 1);
            assertEquals(2, uf.parent(0));
            assertEquals(2, uf.parent(3));
            assertEquals(2,uf.parent(3));
            assertEquals(2,uf.find(3));
            assertEquals(2, uf.parent(4));
            assertTrue(uf.connected(2, 3));

        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}

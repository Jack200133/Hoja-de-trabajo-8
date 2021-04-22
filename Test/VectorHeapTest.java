import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() {
        VectorHeap jupei = new VectorHeap();
        jupei.add("5");
        jupei.add("1");
        jupei.add("3");
        jupei.add("2");
        jupei.add("4");
        assertFalse(jupei.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        VectorHeap jupei = new VectorHeap();
        jupei.add("5");
        jupei.add("1");
        assertTrue(jupei.remove()=="1");
    }
}
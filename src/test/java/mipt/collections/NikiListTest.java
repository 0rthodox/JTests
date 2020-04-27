package mipt.collections;

import static org.junit.Assert.*;

public class NikiListTest {

    @org.junit.Test
    public void size() {
        CustomList list = new NikiList();
        assertEquals(0, list.size());
        list.add(042);
        list.add(42);
        list.add(0x42);
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void isEmpty() {
        CustomList list = new NikiList();
        assertTrue(list.isEmpty());
        list.add(42);
        assertFalse(list.isEmpty());
        list.remove(42);
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void contains() {
        CustomList list = new NikiList();
        assertFalse(list.contains(42));
        list.add(42);
        assertTrue(list.contains(42));
    }

    @org.junit.Test
    public void add() {
        CustomList list = new NikiList();
        list.add(42);
        assertTrue(list.contains(42));
        list.add(0x42);
        list.add(042);
        assertTrue(list.contains(0x42));
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void remove() {
        CustomList list = new NikiList();
        list.add(42);
        list.remove(42);
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void find() {
        NikiList list = new NikiList();
        list.add(42);
        list.find(42);
        assertEquals(0, list.find(42));
        list.add(42);
        assertEquals(0, list.find(42));
        assertEquals(list.size(), list.find(042));
    }

    @org.junit.Test
    public void containsAll() {
        CustomList list = new NikiList();
        list.add(42);
        list.add(042);
        list.add(0x42);
        CustomList anotherList = new NikiList();
        anotherList.add(42);
        anotherList.add(042);
        anotherList.add(0x42);
        assertTrue(list.containsAll(anotherList));
        anotherList.remove(042);
        assertFalse(list.containsAll(anotherList));
        list.remove(042);
        assertTrue(list.containsAll(anotherList));
        list.remove(0x42);
        assertFalse(list.containsAll(anotherList));
    }

    @org.junit.Test
    public void containsSublist() {
        CustomList list = new NikiList();
        list.add(42);
        list.add(042);
        list.add(0x42);
        CustomList anotherList = new NikiList();
        anotherList.add(42);
        anotherList.add(042);
        assertTrue(list.containsSublist(anotherList));
        list.remove(0x42);
        assertTrue(list.containsAll(anotherList));
        list.remove(042);
        assertFalse(list.containsAll(anotherList));
    }

    @org.junit.Test
    public void get() {
        CustomList list = new NikiList();
        try {
            list.get(1);
        } catch (Throwable ex) {
            assertTrue(ex instanceof IndexOutOfBoundsException);
            assertEquals("Wrong index", ex.getMessage());
        }
        list.add(42);
        assertEquals(42, list.get(0));
    }
}
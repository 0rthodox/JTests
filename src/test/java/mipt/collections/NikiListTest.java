package mipt.collections;

import static org.junit.Assert.*;

public class NikiListTest {

    private NikiList list;

    @org.junit.Before
    public void init() {
        list = new NikiList();
    }

    @org.junit.Test
    public void shouldYieldCorrectSize() {
        assertEquals(0, list.size());
        list.add(042);
        list.add(42);
        list.add(0x42);
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void shouldIndicateEmptiness() {
        assertTrue(list.isEmpty());
        list.add(42);
        assertFalse(list.isEmpty());
        list.remove(42);
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void shouldContainAddedItems() {
        list.add(42);
        assertTrue(list.contains(42));
        list.add(0x42);
        list.add(042);
        assertTrue(list.contains(0x42));
        assertEquals(3, list.size());
    }

    @org.junit.Test
    public void shouldProperlyRemoveItems() {
        list.add(42);
        list.remove(42);
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void shouldFindIndexOfExistingItems() {
        list.add(42);
        list.find(42);
        assertEquals(0, list.find(42));
        list.add(42);
        assertEquals(0, list.find(42));
        assertEquals(list.size(), list.find(042));
    }

    @org.junit.Test
    public void shouldYieldSizeIfItemNotExists() {
        assertEquals(list.size(), list.find(042));
    }

    @org.junit.Test
    public void shouldMatchWithEqualList() {
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
    public void shouldYieldTrueIfContainsSublist() {
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
    public void shouldGetItemByIndexOrThrowException() {
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

    @org.junit.After
    public void clear() {
        init();
    }
}
package mipt.collections;

public class NikiList implements CustomList {

    private static final int INITIAL_CAPACITY = 7;
    private static final int TIMES_OF_ENLARGEMENT = 2;
    private int size;
    private int capacity;
    private Object[] data;

    public NikiList(int capacity) {
        if (capacity <= 0) {
            this.capacity = 1;
        } else {
            this.capacity = capacity;
        }
        data = new Object[this.capacity];
        size = 0;
    }

    public NikiList() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        if (element != null && !isEmpty()) {
            for (Object currentElement : data) {
                if (currentElement.equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Object element) {
        if (element == null) {
            return false;
            //throw new java.lang.IllegalArgumentException("Please do not add null to me");
        }
        if (size == capacity) {
            enlarge();
        }
        data[size++] = element;
        return true;
    }

    private void enlarge() {
        capacity = TIMES_OF_ENLARGEMENT * capacity;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public boolean remove(Object element) {
        boolean result = false;
        int foundIndex = find(element);
        while (foundIndex != size) {
            if (foundIndex + 1 != size) {
                System.arraycopy(data, foundIndex + 1, data, foundIndex, size - foundIndex - 1);
            }
            size--;
            result = true;
            foundIndex = find(element);
        }
        return result;
    }

    public int find(Object element) {
        for (int i = 0; i < size; ++i) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return size;
    }

    @Override
    public boolean containsAll(CustomList anotherCustomList) {
        return (anotherCustomList.size() == size && containsSublist(anotherCustomList));
    }

    @Override
    public boolean containsSublist(CustomList anotherCustomList) {
        if (anotherCustomList.isEmpty()) {
            return true;
        }
        for (int i = 0; i < size; ++i) {
            if (data[i].equals(anotherCustomList.get(0))) { // checking first element
                if (checkEquity(anotherCustomList, i)) { // checking next size(sublist) elements
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkEquity(CustomList anotherCustomList, int foundFirstsIndex) {
        if (size - foundFirstsIndex < anotherCustomList.size()) {
            return false;
        }
        for (int i = 0; i < anotherCustomList.size(); ++i) {
            if (!data[i + foundFirstsIndex].equals(anotherCustomList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return new IndexOutOfBoundsException("Wrong index");
        }
        return data[index];
    }
}
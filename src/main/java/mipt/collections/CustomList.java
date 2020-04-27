package mipt.collections;

/**
 * Кастомная реализация динамического списка
 */
public interface CustomList {

    /**
     * @return возвращет количество элементов в списке
     */
    int size();

    /**
     * @return возвращет true, если список не пустой, и false в обратном случае
     */
    boolean isEmpty();

    /**
     * Проверяет содержит ли ваш список объект element
     *
     * @param element объект, наличие которого вы хотите проверить в вашем списке
     */
    boolean contains(Object element);

    /**
     * Добавляет элемент в ваш список. В случае, если массив, содержащийся в вашем списке, переполнен,
     * ваш список должен динамически расиширить его в 2 раза.
     *
     * @param element объект, который вы хотите добавить
     * @return возвращает true, если объект element добавлен
     */
    boolean add(Object element);

    /**
     * Удаляет объект
     * @param element объект, который вы хотите удалить
     * @return возвращает true, если объект element был удален, или false, если такого объекта не было в списке
     */
    boolean remove(Object element);

    /**
     * Проверяет полное совпадение вашего списка с другим списком
     *
     * @param  anotherCustomList список, который вы хотите сравнить с текущим
     * @return true, если ваш список содержит anotherCustomList, и false в обратном случае
     */
    boolean containsAll(CustomList anotherCustomList);

    /**
     * Проверяет частичное совпадение вашего списка с другим списком. То есть проверяется содержит ли ваш список anotherCustomList, как подсписок.
     * Пример. Допустим у вас есть список int вида {44,39,72,51,14,55}, тогда если список anotherCustomList содержит в себе элементы {72,51,14}, то
     * значит, что ваш список содержит anotherCustomList, как подсписок
     *
     * @param  anotherCustomList список, который вы хотите сравнить с текущим
     * @return true, если ваш список содержит anotherCustomList, как подсписок, и false в обратном случае
     */
    boolean containsSublist(CustomList anotherCustomList);

    /**
     * Возврашает элемент по входному индексу
     *
     * @param  index индекс элемента, который вы хотите получить из своего списка. Если индекс, по которому вы хотите достать больше количества элементов,
     *               тогда возвращайте null
     * @return объект по заданному индексу или null
     */
    Object get(int index);
}

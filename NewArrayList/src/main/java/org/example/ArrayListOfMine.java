package org.example;

/**
 Собственная реализация ArrayList со встроенным алгоритмом быстрой сортировки
 */
public class ArrayListOfMine<E> {
    private static final int START_SIZE = 10;
    private final int ARRAY_SIZE_DIVIDER = 4;
    private final int ARRAY_SIZE_MUILTIPLIER = 2;
    private Object[] array = new Object[START_SIZE];
    private int arrayIndex = 0;

    /**
    Добавление нового элемента в список.
    */
    public void add(E item) {
        if (arrayIndex == array.length - 1) {
            int newArraySize = array.length * ARRAY_SIZE_MUILTIPLIER;
            Object[] newArray = new Object[newArraySize];
            System.arraycopy(array, 0, newArray, 0, arrayIndex);
            array = newArray;
        }
        array[arrayIndex++] = item;
    }

    /**
     Возвращение элемента из списка.
     */
    public E get(int index) {
        return (E) array[index];
    }

    /**
    Удаление элемента списка по индексу.
    */
    public void remove(int index) {
        for (int i = index; i < arrayIndex; i++) {
            array[i] = array[i + 1];
        }
        array[arrayIndex] = null;
        --arrayIndex;
        if (array.length > START_SIZE && arrayIndex < array.length / ARRAY_SIZE_DIVIDER) {
            int newArraySize = array.length * ARRAY_SIZE_MUILTIPLIER;
            Object[] newArray = new Object[newArraySize];
            System.arraycopy(array, 0, newArray, 0, arrayIndex);
            array = newArray;
        }
    }
    /**
     Возвращение количества элементов в списке
     */
    public int size() {
        return arrayIndex;
    }

    /**
     Удаление лишних null-элементов списка
     */
    public void trimToSize() {
        if (size() < array.length) {
            Object[] newArray = new Object[size()];
            System.arraycopy(array, 0, newArray, 0, arrayIndex);
            array = newArray;
        }
    }

    /**
    Реализация алгоритма быстрой сортировки
     */
    public void quickSort() {
        trimToSize();
        int startIndex = 0;
        int endIndex = array.length - 1;
        quickSort(startIndex, endIndex);
        }

        private void quickSort(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int start = startIndex;
        int end = endIndex;
        int currentIndex = startIndex + (endIndex - startIndex) / 2;
        Integer valueOfCurrentIndex = Integer.parseInt(get(currentIndex).toString());
            while (startIndex <= endIndex) {
                while (Integer.parseInt(get(startIndex).toString()) < valueOfCurrentIndex) {
                    startIndex++;
                }
                while (Integer.parseInt(get(endIndex).toString()) > valueOfCurrentIndex) {
                    endIndex--;
                }
                if (startIndex <= endIndex) {//меняем местами
                    int temp = Integer.parseInt(get(startIndex).toString());
                    array[startIndex] = Integer.parseInt(get(endIndex).toString());
                    array[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
            }
            if (start < endIndex)
                quickSort(start, endIndex);

            if (end > startIndex)
                quickSort(startIndex, end);
        }
}

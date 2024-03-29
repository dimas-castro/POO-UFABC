/**
 * Uma lista generica duplamente encadeada.
 * @param <T> O tipo generico
 */
public class GenericLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * Uma representacao interna de no.
     * @param <T> o tipo generico
     */
    private static final class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        /**
         * Constroi um no contendo um valor.
         * @param value o valor do no
         */
        public Node(T value) {
            this.value = value;
            this.next = this.prev = null;
        }
    }

    public GenericLinkedList() {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public int size() {
        return size;
    }

    /**
     * Obtem o valor do primeiro elemento.
     * @return o valor do elemento.
     */
    public T peekFirst() {
        if (isEmpty()) {
            throw  new ListEmptyException("There is no element in the list");
        }
        return first.value;
    }

    /**
     * Obtem o valor do ultimo elemento.
     * @return o valor do elemento
     */
    public T peekLast() {
        if (isEmpty()) {
            throw new ListEmptyException("There is no element in the list");
        }
        return last.value;
    }

    /**
     * Adiciona um novo elemento no inicio da lista.
     * @param value o valor do novo elemento
     */
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        size++;
    }

    /**
     * Adiciona um novo elemento no final da lista.
     * @param value o valor do novo elemento
     */
    public void addLast(T value) {
        Node<T> node = new Node<>(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    /**
     * Remove o primeiro elemento.
     * @return o valor do elemento removido
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        T value = first.value;
        Node<T> trash = first;

        if (first.equals(last)) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
            trash.prev = trash.next = null;
        }
        size--;

        return value;
    }

    /**
     * Remove o ultimo elemento.
     * @return o valor do elemento removido
     */
    public T removeLast()  {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        T value = last.value;
        Node<T> trash = last;

        if (first.equals(last)) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
            trash.prev = trash.next = null;
        }
        size--;

        return value;
    }

    /**
     * Remove todos os elementos.
     */
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = first;

        sb.append("[");
        while (cur != null) {
            sb.append(cur.value);
            if (!cur.equals(last)) {
                sb.append(" <=> ");
            }
            cur = cur.next;
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * The main method with some random tests.
     * @param args the args (not used)
     */
    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        System.out.println(list.size());

        for (int i = 0; i < 5; i++) {
            list.addLast(i);
            System.out.println(list);
        }
        System.out.println(list.size());

        for (int i = 0; i < 10; i++) {
            System.out.println(list.removeFirst());
            System.out.println(list);
        }
        System.out.println(list.size());

        try {
            list.removeFirst();
        } catch (ListEmptyException e) {
            System.out.println("Passed: list empty on remove first");
        }

        try {
            list.removeFirst();
        } catch (ListEmptyException e) {
            System.out.println("Passed: list empty on remove last");
        }

        try {
            list.peekFirst();
        } catch (ListEmptyException e) {
            System.out.println("Passed: list empty on peek first");
        }

        try {
            list.peekFirst();
        } catch (ListEmptyException e) {
            System.out.println("Passed: list empty on peek last");
        }
    }
}

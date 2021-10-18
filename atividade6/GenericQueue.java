/**
 * Classe de listas encadeadas.
 * @param <T> tipo de dado
 */
public class GenericQueue<T> {
    GenericLinkedList<T> list;
    int cont;

    /**
     * Construtor da lista.
     * @param size tamanho maximo da lista
     */
    public GenericQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        list = new GenericLinkedList<>();
        cont = size;
    }

    /**
     * Lista cheia.
     * @return true caso esteja cheia
     */
    public boolean isFull() {
        return list.size() == cont;
    }

    /**
     * Lista vazia.
     * @return true caso esteja vazia
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * tamanho da lista.
     * @return o tamanho da lista
     */
    public int size() {
        return list.size();
    }

    /**
     * adiciona no final da lista.
     * @param value valor a ser adicionado
     */
    public void enqueue(T value) {
        if (isFull()) {
            throw new QueueFullException("The list is full");
        }
        if (list.size() == 0) {
            list.addFirst(value);
        } else {
            list.addLast(value);
        }
    }

    /**
     * tira o ultimo valor.
     * @return valor retirado
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException("The list is empty");
        }
        return list.removeFirst();
    }

    /**
     * pega o primeiro valor.
     * @return primeiro valor
     */
    public T front() {
        if (isEmpty()) {
            throw new QueueEmptyException("The list is empty");
        }
        return list.peekFirst();
    }

    /**
     * ultimo valor.
     * @return ultimo valor
     */
    public T rear() {
        if (isEmpty()) {
            throw new QueueEmptyException("The list is empty");
        }
        T resposta = list.peekLast();
        System.out.println(resposta);
        return resposta;
    }

    /**
     * esvazia a lista.
     */
    public void clear() {
        if (isEmpty()) {
            throw new QueueEmptyException("The list is empty");
        }
        list.clear();
    }
}

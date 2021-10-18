/**
 * Classe de pilha genérica.
 * @param <T> tipo de dado
 */
public class GenericStack<T> {
    private final T[] elements;
    private int top;

    /**
     * construtor de pilha.
     * @param size tamanho da pilha
     */
    public GenericStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        elements = (T[]) new Object[size];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    /**
     * lista vazia.
     * @return retorna true se estiver vazia
     */
    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    /**
     * Adiciona valor a lista.
     * @param value valor a ser adicionado
     * @throws StackFullException caso esteja cheia
     */
    public void push(T value) {
        if (isFull()) {
            throw new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    /**
     * retira valor da lista.
     * @return valor retirado
     * @throws StackEmptyException caso esteja vazia
     */
    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[top--];
    }

    /**
     * consulta o topo da pilha.
     * @return o valor do topo
     * @throws StackEmptyException caso esteja vazia
     */
    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. No element to show");
        }
        return elements[top];
    }

    /**
     * retira os valores da lista.
     * @throws StackEmptyException caso a lista esteja vazia
     */
    public void clear() {
        if (isEmpty()) {
            throw new StackEmptyException("A lista está vazia");
        }
        while (!isEmpty()) {
            pop();
        }
    }
}

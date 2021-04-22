public interface PriorityQueueMIO<E extends Comparable<E>> {
    /**
     * @return el valor mínimo en la cola de prioridad
     */
    public E getFirst();

    /**
     *
     * @return devuelve y elimina el valor mínimo de la cola
     */
    public E remove();

    /**
     *
     * @param value se añade a la cola de prioridad
     *
     */
    public void add(E value);

    /**
     *
     * @return true si no hay elementos en la cola
     */
    public boolean isEmpty();

    /**
     *
     * @return número de elementos en la cola
     */
    public int size();

    /**
     * elimina todos los elementos de la cola
     */
    public void clear();


}

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueueMIO<E>
{
    /**
     *los datos, guardados en el orden de la pila
     */
    protected Vector<E> data;

    /**
     *construye una nueva cola prioritaria
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     *
     * @param i posicion del nodo del que se desea el padre
     * @return padre del nodo en la ubicación i
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     *
     * @param i posicion del nodo del que se dea buiscar la izquierda
     * @return devuelve el índice del hijo izquierdo del nodo en la posición i
     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     *
     * @param i posicion del nodo que se desea buscar el derecho
     * @return índice del hijo derecho del nodo en la posición i
     */
    protected static int right(int i)
    {
        return (2*i+1) + 1;
    }

    /**
     *mueve el nodo de la hoja del índice a la posición adecuada
     * @param leaf nodo hoja
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, (E) value);
    }

    /**
     *
     * @param value se añade a la cola de prioridad
     */
    public void add(E value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     *
     * @return si el vector tiene elementos
     */
    @Override
    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     *
     * @return tamano del vector
     */
    @Override
    public int size()
    {
        return data.size();
    }

    /**
     * limpia todo el almacen de datos
     */
    @Override
    public void clear() {
        data.removeAllElements();
    }

    /**
     *mueve el nodo en la raíz del índice hacia abajo a la posición apropiada en el subárbol
     * @param root posicion de la base
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexa el menor de los dos hijos
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // seguir bajando
                } else { // encontró la ubicación correcta
                    data.set(root,value);
                    return;
                }
            } else { // en una hoja! insertar y detener
                data.set(root,value);
                return;
            }
        }
    }

    /**
     *
     * @return el primer elemento del vector
     */
    @Override
    public E getFirst()
    {
        return (E)data.get(0);
    }


    /**
     *devuelve y elimina el valor mínimo de la cola
     * @return el valor minimo de la cola
     */
    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     *
     * @return Muestra los datos del vector 1 por 1
     */
    @Override
    public String toString() {
        StringBuilder ver = new StringBuilder();
        for (E datum : data) {
            ver.append(datum);
            ver.append("\n");
        }
        return ver.toString();
    }
}

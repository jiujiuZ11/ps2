public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    @Override
public boolean isEmpty() {
    return size == 0;
}

@Override
public E[] toArray() {
    return Arrays.copyOf(contents, size);
}

@Override
public void transformAll(MyTransformer<E> transformer) {
    for (int i = 0; i < size; i++) {
        contents[i] = transformer.transform(contents[i]);
    }
}

@Override
public MyList<E> chooseAll(MyChooser<E> chooser) {
    E[] newArray = (E[]) new Object[size];
    int newSize = 0;
    for (int i = 0; i < size; i++) {
        if (chooser.choose(contents[i])) {
            newArray[newSize++] = contents[i];
        }
    }
    return new ArrayGL<>(Arrays.copyOf(newArray, newSize));
}

}
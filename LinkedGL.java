public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        head = null;
        for (int i = contents.length - 1; i >= 0; i--) {
            head = new Node(contents[i], head);
        }
    }
    
    @Override
public boolean isEmpty() {
    return head == null;
}

@Override
public E[] toArray() {
    E[] array = (E[]) new Object[size];
    Node current = head;
    int index = 0;
    while (current != null) {
        array[index++] = current.data;
        current = current.next;
    }
    return array;
}

@Override
public void transformAll(MyTransformer<E> transformer) {
    Node current = head;
    while (current != null) {
        current.data = transformer.transform(current.data);
        current = current.next;
    }
}

@Override
public MyList<E> chooseAll(MyChooser<E> chooser) {
    LinkedGL<E> newList = new LinkedGL<>();
    Node current = head;
    while (current != null) {
        if (chooser.choose(current.data)) {
            newList.add(current.data);
        }
        current = current.next;
    }
    return newList;
}

// Helper method to add elements to the end of the linked list
private void add(E data) {
    if (head == null) {
        head = new Node(data, null);
    } else {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data, null);
    }
}


    // Fill in all methods

}
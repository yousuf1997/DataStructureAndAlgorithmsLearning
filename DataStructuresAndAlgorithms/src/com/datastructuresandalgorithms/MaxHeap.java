package com.datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private List<T> container;

    public MaxHeap() {
        container = new ArrayList<>();
    }

    public void add(T element) {
        container.add(element);
        if (container.size() == 1) {
            // we added root so we do not need to percolate up
            return;
        }
        percolate(container.size() - 1, container);
    }

    public T getMax() {
        if (container.size() == 0) return null;
        return container.get(0);
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public void heapSort(List<T> elements) {
        // assume that the first element is the placeholder
        makeHeap(elements);
        int index = elements.size() - 1;
        while(index > -1) {
            T topElement = elements.get(0);

            // swap with the current element
            elements.set(0, elements.get(index));
            elements.set(index, topElement);

            siftDown(0, elements, index - 1);
            index--;
        }
    }

    private void makeHeap(List<T> elements) {
        // assume that the first element is the placeholder
        int index = elements.size() / 2;
        while (index >= 0) {
            siftDown(index, elements);
            index--;
        }
    }

    public void removeMax() {
        if (container.size() == 0) {
            // nothing to remove;
            return;
        }
        container.set(0, container.get(container.size() - 1));
        // remove the last element
        container.remove(container.size() - 1);
        // sift down
        siftDown(0, container);
    }

    public void replace(T element, int position) {
        if(position >= container.size()) {
            return;
        }
        T currentValue = container.get(position);
        container.set(position, element);
        if (currentValue.compareTo(element) > 0) {
            siftDown(position, container);
        } else {
            percolate(position, container);
        }
    }

    /**
     * This method sifts up the value until it reaches the
     * heap property
     * @param fromPosition
     */
    private void percolate(int fromPosition, List<T> container) {
        while(true) {
            int parentPosition = getParent(fromPosition);
            if (fromPosition == 0 || container.get(parentPosition).compareTo(container.get(fromPosition)) >= 0) {
                // heap property condition met
                break;
            } else {
                // swap
                T temp = container.get(parentPosition);
                container.set(parentPosition, container.get(fromPosition));
                container.set(fromPosition, temp);
                fromPosition = parentPosition;
            }
        }
    }


    /**
     * This method sifts down the value until it reaches the
     * heap property
     * @param fromPosition
     */
    private void siftDown(int fromPosition, List<T> container, int ...newSize) {
       int sizeOfContainer = container.size();

       if (newSize.length > 0) {
           sizeOfContainer = newSize[0];
       }

       while (true) {

           int leftChildIndex = getLeftChild(fromPosition);
           int rightChildIndex = getRightChild(fromPosition);

           int positionToBeSwapped = -1;
           // check the bounds of the left and right child
           if (leftChildIndex < sizeOfContainer && rightChildIndex < sizeOfContainer) {
               // check which one is bigger
               if (container.get(leftChildIndex).compareTo(container.get(rightChildIndex)) >= 0) {
                   // left child is bigger
                   positionToBeSwapped = leftChildIndex;
               } else {
                   // right child is bigger
                   positionToBeSwapped = rightChildIndex;
               }
           } else if (leftChildIndex < sizeOfContainer) {
               positionToBeSwapped = leftChildIndex;
           } else if (rightChildIndex < sizeOfContainer){
               positionToBeSwapped = rightChildIndex;
           } else {
               // heap property achieved
               break;
           }
           if (container.get(fromPosition).compareTo(container.get(positionToBeSwapped)) < 0) {
               T temp = container.get(fromPosition);
               container.set(fromPosition, container.get(positionToBeSwapped));
               container.set(positionToBeSwapped, temp);
               fromPosition = positionToBeSwapped;
           } else {
               // heap property achieved
               break;
           }
       }
    }

    private int getParent(int index) {
        return ((index + 1) / 2) - 1;
    }

    private int getLeftChild(int index) {
        return ((index + 1) * 2) - 1;
    }

    private int getRightChild(int index) {
        return (((index + 1) * 2) + 1) - 1;
    }

}
